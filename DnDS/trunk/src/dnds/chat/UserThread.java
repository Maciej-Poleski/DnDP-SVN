/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnds.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Wątek urzytkownika
 * Wzorzec projektowy Obserwator
 */
public class UserThread extends Thread
{

    private Socket handle;
    private BufferedWriter writer;
    private BufferedReader reader;
    private String message;
    private static SimpleDateFormat format = new SimpleDateFormat("H : mm : ss");
    private ChatServer mother;

    public UserThread(Socket handle, ChatServer mother)
    {
        this.handle = handle;
        this.mother = mother;
        try
        {
            writer = new BufferedWriter(new OutputStreamWriter(handle.getOutputStream(), "UTF-8"));
            reader = new BufferedReader(new InputStreamReader(handle.getInputStream(), "UTF-8"));
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.write("<root>");
            start();
        }
        catch (IOException ex)
        {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void sendToClient(String what) throws IOException
    {
        writer.write(what);
        writer.flush();
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                try
                {
                    message = reader.readLine();
                    Logger.getLogger("Client").log(Level.INFO, "Wiadomość {0}", message);
                    message = "<time>" + format.format(Calendar.getInstance().getTime()) + "</time>" + message;
                    mother.sendToOther(message);
                }
                catch (IOException e)
                {
                    Logger.getLogger("Client").log(Level.INFO, "Wyjątek", e);
                    break;
                }
                Thread.sleep(20);
            }
        }
        catch (InterruptedException e)
        {
            Logger.getLogger("Client").log(Level.INFO, "Wyjątek", e);
        }
        finally
        {
            Logger.getLogger("Client").log(Level.INFO, "Roz\u0142\u0105czy\u0142 si\u0119 {0}", handle.getInetAddress().getHostName());
            try
            {
                writer.write("</root>");
                writer.flush();
            }
            catch (IOException ex)
            {
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, "Błąd przy zamykaniu węzła <root>", ex);
            }
            mother.removeClient(this);
            try
            {
                handle.close();
            }
            catch (IOException ex)
            {
                Logger.getLogger(UserThread.class.getName()).log(Level.SEVERE, "Błąd przy zamykaniu połączenia", ex);
            }
        }
    }
}


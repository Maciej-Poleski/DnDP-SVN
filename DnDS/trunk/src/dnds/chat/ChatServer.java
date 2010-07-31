package dnds.chat;

/**
 * Klasa na Serwer chatu składnik Servera
 * 
 * Wzorzec projektowy Thread per Requste
 *
 * @author bambucha
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer extends Thread
{

    private ServerSocket mainSoket;
    private Socket client;
    private Calendar time;
    private List<UserThread> UrserList;
    private static final Logger log = Logger.getLogger("Chat Server");

    /**
     * Standardowy konstruktor
     * Nieskończona pętla pozwala na działanie a 5 ms sleep nie rozwala komputera masa przerwan
     */
    public ChatServer(Logger parient)
    {
        try
        {
            UrserList = Collections.synchronizedList(new LinkedList<UserThread>());
            time = Calendar.getInstance();
            log.setParent(parient);
            mainSoket = new ServerSocket(31116);
        }
        catch (IOException ex)
        {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Głowna funkcja wątku. Pozwala na podłanczanie się użytkownikół
     * i torzy dla nich osobny wątek
     */
    @Override
    public void run()
    {
        super.run();
        UserThread actualUser;
        while (true)
        {
            try
            {
                client = mainSoket.accept();
                actualUser = new UserThread(client, this);
                UrserList.add(actualUser);
                log.log(Level.INFO, "{0} has been connected", client.getInetAddress().getHostName());
                Thread.sleep(5);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex)
            {
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Przesyła wszytkim urzytkownikom zadany String
     * @param what Wiadomosc do przeslania
     */
    public synchronized void sendToOther(String what) throws IOException
    {
        for (UserThread x : UrserList)
        {
            x.sendToClient(what);
        }
    }

    public synchronized void removeClient(UserThread x)
    {
        UrserList.remove(x);
    }
}

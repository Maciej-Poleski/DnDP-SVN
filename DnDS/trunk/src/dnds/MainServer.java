package dnds;

import com.db4o.ObjectServer;
import com.db4o.cs.Db4oClientServer;
import dnds.chat.ChatServer;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Klasa agregująca i zarządzając a serwerami.
 * @author bambucha
 */
public class MainServer
{

    private static final Logger log = Logger.getLogger("MainServer");
    private ChatServer chatServer;
    private ObjectServer openServer;

    public MainServer(int socked)
    {
        try
        {
            Handler t = new FileHandler("log%g.log");
            t.setFormatter(new SimpleFormatter());
            log.addHandler(t);
        }
        catch (IOException ex)
        {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SecurityException ex)
        {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        chatServer = new ChatServer(log);
        log.log(Level.INFO, "Serwer chatu zbudowany");
        openServer = Db4oClientServer.openServer("db4o.db", 31117);
        log.log(Level.INFO, "Baza stoi");
        openServer.grantAccess("dndtest", "dupad12");
        log.log(Level.INFO, "Ustwiony urzytkownik bazy");
        chatServer.start();
        log.log(Level.INFO, "Serwer chatu pracuje");



    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        MainServer serwer = new MainServer(31116);
    }
}

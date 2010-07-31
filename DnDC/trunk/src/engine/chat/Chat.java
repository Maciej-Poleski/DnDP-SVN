package engine.chat;

import client.FrontToServer;
import client.ParserHandler;
import gui.chat.ChatPanel;
import java.io.IOException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * Klasa parsująca i przygotowująca wiadomość do wyświetlenia oraz wysłania
 * @author bambucha
 */
public class Chat extends Thread
{

    private MutableAttributeSet timeFormat;
    private MutableAttributeSet nickFormat;
    private MutableAttributeSet messageFormat;
    private ChatPanel gui;
    private String nick;
    private FrontToServer handle;

    /**
     * Standarody konstruktor tworzy czas dla bezimiennego.
     */
    public Chat(FrontToServer handle)
    {
        this.nick = "No name ";
        timeFormat = new SimpleAttributeSet();
        StyleConstants.setItalic(timeFormat, true);
        nickFormat = new SimpleAttributeSet();
        StyleConstants.setBold(nickFormat, true);
        messageFormat = new SimpleAttributeSet();
        this.handle = handle;
        handle.setContentHandlerForParser(new ParserHandler(this));
        handle.start();
    }

    /**
     * Wyświetla tekst z odpowienim formatem
     * 1 - format czasu
     * 2 - format nick'u
     * 3 - format wiadomości
     * @param text teskt do wyświetlenia
     * @param state jaki format
     */
    public void showText(String text, int state)
    {
        switch (state)
        {
            case 1:
                gui.showMessage(text, timeFormat);
                break;
            case 2:
                gui.showMessage(text, nickFormat);
                break;
            case 3:
                gui.showMessage(text, messageFormat);
                break;
        }
    }

    public void sendMessage(String message)
    {
        try
        {
            handle.sendMessage(nick, prepare(message));
        }
        catch (IOException ex)
        {
        }
    }

    public void setGui(ChatPanel gui)
    {
        this.gui = gui;
    }

    public String getNick()
    {
        return nick;
    }

    public void setNick(String nick)
    {
        this.nick = prepare(nick);
    }

    /**
     * Zamienia tekst na taki który łyka parser
     * @param what Tekst do przygotowania
     * @return Obrobiony tekst
     */
    private String prepare(String what)
    {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < what.length(); i++)
            switch (what.charAt(i))
            {
                case '<':
                    output.append("&lt;");
                    break;
                case '>':
                    output.append("&gt;");
                    break;
                case '&':
                    output.append("&amp;");
                    break;
                default:
                    output.append(what.charAt(i));
                    break;
            }
        return output.toString();
    }
}   

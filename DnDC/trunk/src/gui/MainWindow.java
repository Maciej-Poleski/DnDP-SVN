package gui;

import gui.chat.ChatStartDialog;
import gui.chat.ChatPanel;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import client.FrontToServer;
import engine.chat.Chat;

public class MainWindow extends JFrame
{

    private static final long serialVersionUID = 1L;
    private ChatPanel chat;

    public MainWindow(Chat chatHandler)
    {
        super("DnD Client");
        this.chat = new ChatPanel(chatHandler);

        new ChatStartDialog(this, chatHandler);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(chat,BorderLayout.LINE_END);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public ChatPanel getChat()
    {
        return chat;
    }


}

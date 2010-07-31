/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.chat;

import engine.chat.Chat;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author bambucha
 */
public class ChatStartDialog extends JDialog implements ActionListener, KeyListener
{

    private JTextField nickField;
    private JLabel nickLabel;
    private JButton goButton;
    private Chat chatHandle;

    public ChatStartDialog(Frame owner, Chat chatHandle)
    {
        super(owner, "Wybierz nick używany w chat'cie", true);
        this.chatHandle = chatHandle;
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(130, 100));

        this.setResizable(false);

        JPanel t = new JPanel();
        t.setLayout(new BoxLayout(t, BoxLayout.X_AXIS));
        nickLabel = new JLabel("Nick");
        t.add(nickLabel);
        nickField = new JTextField();
        nickField.addKeyListener(this);
        t.add(nickField);
        t.setPreferredSize(new Dimension(130, 30));
        this.add(t, BorderLayout.CENTER);

        goButton = new JButton("Go");
        goButton.addActionListener(this);
        this.add(goButton, BorderLayout.AFTER_LAST_LINE);


        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.action();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.action();
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }

    private void action()
    {
        chatHandle.setNick(nickField.getText());
        this.setVisible(false);
        this.dispose();
    }
}

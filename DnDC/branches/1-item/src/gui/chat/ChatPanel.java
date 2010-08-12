package gui.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

import engine.chat.Chat;

/**
 * Panel z chatem. Przyjmuje informacje, nie zajmuje się jej obróbką.
 * 
 * @author bambucha
 */
public class ChatPanel extends JPanel implements KeyListener, ActionListener,
        MouseListener
{

    private static final long serialVersionUID = 1L;
    private JTextField        fieldToTyped;
    private JTextPane         conversation;
    private JScrollPane       t;
    private Chat              handle;
    private StyledDocument    doc;
    private RTFEditorKit      kit;

    /**
     * Buduje całość
     * 
     * @param handle
     *            Referencja do fasady od serwera
     */
    public ChatPanel(Chat handle)
    {
        super();
        // this.setPreferredSize(new Dimension(300, 400));
        this.handle = handle;

        kit = new RTFEditorKit();
        doc = new DefaultStyledDocument();

        this.setLayout(new BorderLayout());
        conversation = new JTextPane();

        conversation.setStyledDocument(doc);
        conversation.setEditorKit(kit);
        conversation.addMouseListener(this);

        conversation.setPreferredSize(new Dimension(700, 300));
        t = new JScrollPane(conversation);
        this.add(t, BorderLayout.CENTER);

        JPanel x = new JPanel();
        x.setLayout(new BoxLayout(x, BoxLayout.X_AXIS));
        fieldToTyped = new JTextField();
        fieldToTyped.addKeyListener(this);
        x.add(fieldToTyped);

        JButton tx = new JButton("Send");
        tx.addActionListener(this);
        x.add(tx);
        this.add(x, BorderLayout.PAGE_END);

        conversation.setEditable(false);
        conversation.setContentType("text/plain");
        this.setVisible(true);
    }

    /**
     * Wyświetla zadany tekst z uwzględnienim formatu
     * 
     * @param message
     *            Tekst do wyświetlenia
     * @param aset
     *            Format wiadomość
     */
    public void showMessage(String message, AttributeSet aset)
    {
        try
        {
            doc.insertString(doc.getLength(), message, aset);
            conversation.setDocument(doc);
            conversation.setCaretPosition(conversation.getText().length());
        }
        catch(BadLocationException ex)
        {
            Logger.getLogger(ChatPanel.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

    }

    @Override
    public void keyTyped(KeyEvent e)
    {}

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            handle.sendMessage(fieldToTyped.getText());
            fieldToTyped.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {}

    @Override
    public void actionPerformed(ActionEvent e)
    {
        handle.sendMessage(fieldToTyped.getText());
        fieldToTyped.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        fieldToTyped.grabFocus();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {}

    @Override
    public void mouseReleased(MouseEvent e)
    {}

    @Override
    public void mouseEntered(MouseEvent e)
    {}

    @Override
    public void mouseExited(MouseEvent e)
    {}
}

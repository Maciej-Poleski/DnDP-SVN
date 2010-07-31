/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.card;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author bambucha
 */
public class TestFrame extends JFrame
{

    public TestFrame() throws HeadlessException
    {
        super("Okno testowe");
        this.setLayout(new BorderLayout());
        this.getContentPane().add(new CardPanel(),BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String arg[])
    {
        new TestFrame();
    }
}

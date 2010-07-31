/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HPPanel.java
 *
 * Created on 2010-07-18, 01:30:02
 */

package gui.card;

import engine.card.hp.DnDHitPoints;
import engine.card.hp.HitPoints;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Widok dla punktów życia
 * @author bambucha
 */
public class HPPanel extends javax.swing.JPanel implements ChangeListener
{

    /** Creates new form HPPanel */
    public HPPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        current = new javax.swing.JLabel();
        maxHP = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Hit Points"));

        jLabel1.setText("Current");

        jLabel2.setText("HP");

        current.setText("10");

        maxHP.setText("10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(current, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(maxHP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(current))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(maxHP))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("CurrentHP");
        jLabel2.getAccessibleContext().setAccessibleName("MaxHP");
        current.getAccessibleContext().setAccessibleName("CurrentValue");
        maxHP.getAccessibleContext().setAccessibleName("MaxValue");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel current;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel maxHP;
    // End of variables declaration//GEN-END:variables

    @Override
    public void stateChanged(ChangeEvent e)
    {
        if(e.getSource() instanceof HitPoints)
        {
            HitPoints source = (HitPoints)e.getSource();
            current.setText(source.getHP().toString());
            maxHP.setText(source.getMaxHP().toString());
        }
    }

}

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

/*
 * AbilitiPanel.java Created on 2010-07-18, 00:53:44
 */

package gui.card;


/**
 * Panel Atrybutów. Większy kontener na poszególnej
 * 
 * @author bambucha
 */
public class AbilitiesPanel extends javax.swing.JPanel
{

    /** Creates new form AbilitiPanel */
    public AbilitiesPanel()
    {
        initComponents();
        strPanel.getNameLabel().setText("STR");
        dexPanel.getNameLabel().setText("DEX");
        conPanel.getNameLabel().setText("CON");
        intPanel.getNameLabel().setText("INT");
        wisPanel.getNameLabel().setText("WIS");
        chaPanel.getNameLabel().setText("CHA");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        strPanel = new gui.card.AbilitiPanel();
        dexPanel = new gui.card.AbilitiPanel();
        conPanel = new gui.card.AbilitiPanel();
        intPanel = new gui.card.AbilitiPanel();
        wisPanel = new gui.card.AbilitiPanel();
        chaPanel = new gui.card.AbilitiPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
                        0, 0, 0), 2), "Abilities",
                javax.swing.border.TitledBorder.LEFT,
                javax.swing.border.TitledBorder.TOP));
        setMinimumSize(new java.awt.Dimension(132, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(
                                                        chaPanel,
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        108, Short.MAX_VALUE)
                                                .addComponent(
                                                        wisPanel,
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        108, Short.MAX_VALUE)
                                                .addComponent(
                                                        intPanel,
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        108, Short.MAX_VALUE)
                                                .addComponent(
                                                        conPanel,
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        108, Short.MAX_VALUE)
                                                .addComponent(
                                                        strPanel,
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        108, Short.MAX_VALUE)
                                                .addComponent(
                                                        dexPanel,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))
                                .addContainerGap()));
        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addComponent(strPanel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dexPanel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conPanel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(intPanel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wisPanel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chaPanel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.card.AbilitiPanel chaPanel;
    private gui.card.AbilitiPanel conPanel;
    private gui.card.AbilitiPanel dexPanel;
    private gui.card.AbilitiPanel intPanel;
    private gui.card.AbilitiPanel strPanel;
    private gui.card.AbilitiPanel wisPanel;

    // End of variables declaration//GEN-END:variables

    public AbilitiPanel getChaPanel()
    {
        return chaPanel;
    }

    public AbilitiPanel getConPanel()
    {
        return conPanel;
    }

    public AbilitiPanel getDexPanel()
    {
        return dexPanel;
    }

    public AbilitiPanel getIntPanel()
    {
        return intPanel;
    }

    public AbilitiPanel getStrPanel()
    {
        return strPanel;
    }

    public AbilitiPanel getWisPanel()
    {
        return wisPanel;
    }
}
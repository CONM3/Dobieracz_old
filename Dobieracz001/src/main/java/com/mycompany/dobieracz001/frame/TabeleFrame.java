package com.mycompany.dobieracz001.frame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 * @since 2017-10-10, 11:36:02
 * @author Grzegorz Brodowski
 */
public class TabeleFrame extends javax.swing.JFrame {
    String[] columnNames = {"Urządzenie", "Ilość"};
    Object[][] data;

    

    /**
     * Creates new form TabeleFrame
     */
    public TabeleFrame(Object[][] tab) {
        this.data = tab;
        uzupelnijTabele();
        initComponents();

    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabelka1");

        jButtonClose.setText("Zamknij");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonClose)
                .addContainerGap(362, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(533, Short.MAX_VALUE)
                .addComponent(jButtonClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void uzupelnijTabele() {

//        Object[][] data = {{nazwa1, 1},
//        {nazwa2, "1"},
//        {nazwa3, "1"},
//        {"KAC-4", String.valueOf((int) kac)},
//        {"CYK-1", String.valueOf((int) cyk)},
//        {"BLC-24", String.valueOf((int) blc)}
//        };



        JTable table = new JTable();
        table.setModel(new DefaultTableModel(data, columnNames));

        this.add(new JScrollPane(table));
        this.setTitle("Table Example");
        table.setFillsViewportHeight(true);
        this.pack();

    }

    public void pobierzDane(Object[][] tab) {
        this.data = tab;
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    // End of variables declaration//GEN-END:variables

}

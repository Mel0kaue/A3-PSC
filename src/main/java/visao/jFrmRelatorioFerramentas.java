package visao;

import dao.FerramentaDAO;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Ferramenta;

/**
 *
 * @author josue
 */
public class jFrmRelatorioFerramentas extends javax.swing.JFrame {

    /**
     * Creates new form jFrmRelatórioFerramentas
     */
    public jFrmRelatorioFerramentas() {
        initComponents();
        
        DefaultTableModel modelo = (DefaultTableModel) this.jTableHistCompras.getModel();
        jTableHistCompras.setRowSorter(new TableRowSorter(modelo));
        
        readJTable();
        
        txtTotalGasto.setText("Ola Mundo");
    }
    
    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableHistCompras.getModel();
        modelo.setNumRows(0); // 
        String totalGasto = this.txtTotalGasto.getText();
        
        FerramentaDAO fdao = new FerramentaDAO();
        
        for (Ferramenta f: fdao.read()) {
            
            modelo.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getMarca(),
                f.getCusto(),
            });
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtPaneGasto = new javax.swing.JTextPane();
        lblHistCompras = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistCompras = new javax.swing.JTable();
        lblTotGasto = new javax.swing.JLabel();
        txtTotalGasto = new javax.swing.JTextField();

        jScrollPane2.setViewportView(txtPaneGasto);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de ferramentas");

        lblHistCompras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHistCompras.setText("HISTÓRICO DE COMPRAS");

        jTableHistCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Marca", "Valor"
            }
        ));
        jScrollPane1.setViewportView(jTableHistCompras);

        lblTotGasto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotGasto.setText("Total Gasto:");

        txtTotalGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalGastoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHistCompras)
                        .addGap(326, 326, 326)
                        .addComponent(lblTotGasto))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtTotalGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHistCompras)
                    .addComponent(lblTotGasto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTotalGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalGastoActionPerformed
        Ferramenta objetoFerramen = new Ferramenta();
    }//GEN-LAST:event_txtTotalGastoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFrmRelatorioFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrmRelatorioFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrmRelatorioFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrmRelatorioFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrmRelatorioFerramentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableHistCompras;
    private javax.swing.JLabel lblHistCompras;
    private javax.swing.JLabel lblTotGasto;
    private javax.swing.JTextPane txtPaneGasto;
    private javax.swing.JTextField txtTotalGasto;
    // End of variables declaration//GEN-END:variables
}
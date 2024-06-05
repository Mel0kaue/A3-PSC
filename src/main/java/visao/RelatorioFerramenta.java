package visao;

import dao.FerramentaDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Ferramenta;

/**
 *
 * @author josue
 */
public class RelatorioFerramenta extends javax.swing.JFrame {

    /**
     * Creates new form jFrmRelatórioFerramentas
     */
    public RelatorioFerramenta() {
        initComponents();

        DefaultTableModel modelo = (DefaultTableModel) this.tabelaFerramenta.getModel();
        tabelaFerramenta.setRowSorter(new TableRowSorter(modelo));

        readJTable();
    }

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) this.tabelaFerramenta.getModel();
        modelo.setNumRows(0); // 

        FerramentaDAO fdao = new FerramentaDAO();

        for (Ferramenta f : fdao.read()) {

            modelo.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getMarca(),
                f.getCusto(),});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtPaneGasto = new javax.swing.JTextPane();
        lblHistCompras = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFerramenta = new javax.swing.JTable();
        lblTotGasto = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        btnAlterarFerramenta = new javax.swing.JButton();
        inputNome = new javax.swing.JTextField();
        inputMarca = new javax.swing.JTextField();
        inputValor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTotalValor = new javax.swing.JTextField();

        jScrollPane2.setViewportView(txtPaneGasto);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de ferramentas");

        lblHistCompras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHistCompras.setText("HISTÓRICO DE FERRAMENTAS");

        tabelaFerramenta.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaFerramenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFerramentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFerramenta);
        if (tabelaFerramenta.getColumnModel().getColumnCount() > 0) {
            tabelaFerramenta.getColumnModel().getColumn(0).setMaxWidth(55);
        }

        lblTotGasto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTotGasto.setText("Total Gasto:");

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(195, 47, 39));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterarFerramenta.setBackground(new java.awt.Color(255, 255, 255));
        btnAlterarFerramenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlterarFerramenta.setForeground(new java.awt.Color(246, 170, 28));
        btnAlterarFerramenta.setText("Editar");
        btnAlterarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarFerramentaActionPerformed(evt);
            }
        });

        inputMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMarcaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Marca");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Valor");

        txtTotalValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTotalValorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTotalValorMouseEntered(evt);
            }
        });
        txtTotalValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHistCompras)
                .addGap(152, 152, 152))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAlterarFerramenta))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(inputValor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblTotGasto)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblHistCompras)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lblTotGasto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterarFerramenta)
                    .addComponent(btnExcluir))
                .addGap(47, 47, 47))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarFerramentaActionPerformed

        int id = 0;
        String nome = "";
        String marca = "";
        double preco = 0.0;

        if (this.inputNome.getText().length() <= 2) {
            JOptionPane.showMessageDialog(null, "O campo nome deve ter pelo menos 3 caracteres!");
        } else {
            nome = this.inputNome.getText();
        }

        if (this.inputMarca.getText().length() <= 2) {
            JOptionPane.showMessageDialog(null, "O campo marca deve ter pelo menos 3 caracteres!");
        } else {
            marca = this.inputMarca.getText();
        }

        if (this.inputValor.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "O campo marca deve ter pelo menos 1 caracterer!");
        }

        String textoPreco = this.inputValor.getText();
        textoPreco = textoPreco.replace("R$ ", " ");
        textoPreco = textoPreco.replace(",", ".");
        preco = Double.parseDouble(textoPreco); // transformando um dado do tipo String em double.

        if (this.tabelaFerramenta.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma Ferramenta para Alterar");
        } else {
            id = Integer.parseInt(this.tabelaFerramenta.getValueAt(this.tabelaFerramenta.getSelectedRow(), 0).toString());
        }

        if (tabelaFerramenta.getSelectedRow() != -1) {

            Ferramenta f = new Ferramenta(); //instancia ferramenta
            FerramentaDAO dao = new FerramentaDAO(); //conecta sql

            f.setNome(nome);
            f.setMarca(marca);
            f.setCusto(preco);
            f.setId(id);

            dao.update(f);

            //limpando os campos
//            this.inputId.setText("");
            this.inputNome.setText("");
            this.inputMarca.setText("");
            this.inputValor.setText("");

            readJTable();
        }
    }//GEN-LAST:event_btnAlterarFerramentaActionPerformed

    private void tabelaFerramentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFerramentaMouseClicked

        if (this.tabelaFerramenta.getSelectedRow() != -1) {
            
            String id = this.tabelaFerramenta.getValueAt(this.tabelaFerramenta.getSelectedRow(), 0).toString();
            String nome = this.tabelaFerramenta.getValueAt(this.tabelaFerramenta.getSelectedRow(), 1).toString();
            String marca = this.tabelaFerramenta.getValueAt(this.tabelaFerramenta.getSelectedRow(), 2).toString();
            String aquisicao = this.tabelaFerramenta.getValueAt(this.tabelaFerramenta.getSelectedRow(), 3).toString().replace("R$ ", "");

//            this.inputId.setText(id);
            this.inputNome.setText(nome);
            this.inputMarca.setText(marca);
            this.inputValor.setText(aquisicao);
        }
    }//GEN-LAST:event_tabelaFerramentaMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        if (tabelaFerramenta.getSelectedRow() != -1) {
            int[] selectedRows = tabelaFerramenta.getSelectedRows();
            FerramentaDAO dao = new FerramentaDAO();

            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                for (int i = 0; i < selectedRows.length; i++) {
                    int modelIndex = tabelaFerramenta.convertRowIndexToModel(selectedRows[i]);
                    int id = (int) tabelaFerramenta.getModel().getValueAt(modelIndex, 0);
                    Ferramenta f = new Ferramenta();
                    f.setId(id);
                    dao.delete(f);
                }

                // Limpar campos
                this.inputMarca.setText("");
                this.inputNome.setText("");
                this.inputValor.setText("");

                readJTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um ou mais produtos para excluir.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtTotalValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalValorActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtTotalValorActionPerformed

    private void txtTotalValorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTotalValorMouseClicked
        // TODO add your handling code here:

        double total = FerramentaDAO.somarValores();
        String totalTxt = Double.toString(total);

        this.txtTotalValor.setText(totalTxt);
    }//GEN-LAST:event_txtTotalValorMouseClicked

    private void txtTotalValorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTotalValorMouseEntered
        // TODO add your handling code here:

        double total = FerramentaDAO.somarValores();
        String totalTxt = Double.toString(total);

        this.txtTotalValor.setText(totalTxt);
    }//GEN-LAST:event_txtTotalValorMouseEntered

    private void inputMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMarcaActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarFerramenta;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JTextField inputMarca;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputValor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHistCompras;
    private javax.swing.JLabel lblTotGasto;
    private javax.swing.JTable tabelaFerramenta;
    private javax.swing.JTextPane txtPaneGasto;
    private javax.swing.JTextField txtTotalValor;
    // End of variables declaration//GEN-END:variables
}
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
public class VerFerramenta extends javax.swing.JFrame {

    /**
     * Creates new form jFrmRelatórioFerramentas
     */
    public VerFerramenta() {
        initComponents();
        
        DefaultTableModel modelo = (DefaultTableModel) this.jTableHistCompras.getModel();
        jTableHistCompras.setRowSorter(new TableRowSorter(modelo));
        
        readJTable();
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
        btnExcluir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnAlterarFerramenta = new javax.swing.JButton();
        inputId = new javax.swing.JTextField();
        txtInserirNome = new javax.swing.JTextField();
        txtInserirMarcaa = new javax.swing.JTextField();
        txtFormatCusto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jScrollPane2.setViewportView(txtPaneGasto);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de ferramentas");

        lblHistCompras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHistCompras.setText("HISTÓRICO DE FERRAMENTAS");

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
        jTableHistCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHistComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHistCompras);
        if (jTableHistCompras.getColumnModel().getColumnCount() > 0) {
            jTableHistCompras.getColumnModel().getColumn(0).setMaxWidth(55);
        }

        lblTotGasto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotGasto.setText("Total Gasto:");

        txtTotalGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalGastoActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(64, 61, 57));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(195, 47, 39));
        btnExcluir.setText("Deletar");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jButton2.setText("somar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnAlterarFerramenta.setBackground(new java.awt.Color(64, 61, 57));
        btnAlterarFerramenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlterarFerramenta.setForeground(new java.awt.Color(246, 170, 28));
        btnAlterarFerramenta.setText("Editar");
        btnAlterarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarFerramentaActionPerformed(evt);
            }
        });

        inputId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIdActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Nome");

        jLabel3.setText("Marca");

        jLabel4.setText("Valor");

        jButton1.setBackground(new java.awt.Color(195, 47, 39));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotGasto)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTotalGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtInserirNome, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(txtInserirMarcaa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(txtFormatCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterarFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)))
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblHistCompras)
                        .addGap(152, 152, 152))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(9, 9, 9)
                .addComponent(lblHistCompras)
                .addGap(40, 40, 40)
                .addComponent(lblTotGasto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInserirNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInserirMarcaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormatCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterarFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalGastoActionPerformed
        Ferramenta objetoFerramen = new Ferramenta();
    }//GEN-LAST:event_txtTotalGastoActionPerformed

    private void btnAlterarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarFerramentaActionPerformed
        // TODO add your handling code here:
        
        int id = 0;
        String nome = "";
        String marca = "";
        double preco = 0.0;

        if (this.txtInserirNome.getText().length() <= 2) {
            JOptionPane.showMessageDialog(null, "O campo nome deve ter pelo menos 3 caracteres!");
        } else {
            nome = this.txtInserirNome.getText();
        }

        if (this.txtInserirMarcaa.getText().length() <= 2) {
            JOptionPane.showMessageDialog(null, "O campo marca deve ter pelo menos 3 caracteres!");
        } else {
            marca = this.txtInserirMarcaa.getText();
        }

        if (this.txtFormatCusto.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "O campo marca deve ter pelo menos 1 caracterer!");
        }

        String textoPreco = this.txtFormatCusto.getText();
        textoPreco = textoPreco.replace("R$ ", " ");
        textoPreco = textoPreco.replace(",", ".");
        preco = Double.parseDouble(textoPreco); // transformando um dado do tipo String em double.

        if (this.jTableHistCompras.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma Ferramenta para Alterar");
        } else {
            id = Integer.parseInt(this.jTableHistCompras.getValueAt(this.jTableHistCompras.getSelectedRow(), 0).toString());
        }

        if (jTableHistCompras.getSelectedRow() != -1) {

            Ferramenta f = new Ferramenta(); //instancia ferramenta
            FerramentaDAO dao = new FerramentaDAO(); //conecta sql

            //atualiza os valores
            f.setNome(nome);
            f.setMarca(marca);
            f.setCusto(preco);
            f.setId(id);

            //update nos dados
            dao.update(f);

            //limpando os campos
            this.inputId.setText("");
            this.txtInserirMarcaa.setText("");
            this.txtInserirNome.setText("");
            this.txtFormatCusto.setText("");

            //atualizando tabela
            readJTable();
        }
    }//GEN-LAST:event_btnAlterarFerramentaActionPerformed

    private void inputIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIdActionPerformed

    private void jTableHistComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistComprasMouseClicked
        // TODO add your handling code here:
        
        if (this.jTableHistCompras.getSelectedRow() != -1) {
            
            String id = this.jTableHistCompras.getValueAt(this.jTableHistCompras.getSelectedRow(), 0).toString();
            String nome = this.jTableHistCompras.getValueAt(this.jTableHistCompras.getSelectedRow(), 1).toString();
            String marca = this.jTableHistCompras.getValueAt(this.jTableHistCompras.getSelectedRow(), 2).toString();
            String aquisicao = this.jTableHistCompras.getValueAt(this.jTableHistCompras.getSelectedRow(), 3).toString().replace("R$ ", "");

            this.inputId.setText(id);
            this.txtInserirNome.setText(nome);
            this.txtInserirMarcaa.setText(marca);
            this.txtFormatCusto.setText(aquisicao);
        }
    }//GEN-LAST:event_jTableHistComprasMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        
        if (jTableHistCompras.getSelectedRow() != -1) {
            int[] selectedRows = jTableHistCompras.getSelectedRows();
            FerramentaDAO dao = new FerramentaDAO();

            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                for (int i = 0; i < selectedRows.length; i++) {
                    int modelIndex = jTableHistCompras.convertRowIndexToModel(selectedRows[i]);
                    int id = (int) jTableHistCompras.getModel().getValueAt(modelIndex, 0);
                    Ferramenta f = new Ferramenta();
                    f.setId(id);
                    dao.delete(f);
                }

                // Limpar campos
                this.inputId.setText("");
                this.txtInserirMarcaa.setText("");
                this.txtInserirNome.setText("");
                this.txtFormatCusto.setText("");

                // Atualizar tabela
                readJTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um ou mais produtos para excluir.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        
        double soma = FerramentaDAO.somarValores();
        String somaTxt = Double.toString(soma);
        this.txtTotalGasto.setText(somaTxt);
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(VerFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarFerramenta;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JTextField inputId;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableHistCompras;
    private javax.swing.JLabel lblHistCompras;
    private javax.swing.JLabel lblTotGasto;
    private javax.swing.JTextField txtFormatCusto;
    private javax.swing.JTextField txtInserirMarcaa;
    private javax.swing.JTextField txtInserirNome;
    private javax.swing.JTextPane txtPaneGasto;
    private javax.swing.JTextField txtTotalGasto;
    // End of variables declaration//GEN-END:variables
}

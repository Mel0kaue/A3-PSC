package visao;

import dao.AmigoDAO;
import dao.FerramentaDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Amigo;
import modelo.Ferramenta;

/**
 *
 * @author josue
 */
public class RelatorioAmigo extends javax.swing.JFrame {
    
    public RelatorioAmigo() {
        initComponents();
        
        DefaultTableModel modelo = (DefaultTableModel) this.tabelaAmigos.getModel();
        tabelaAmigos.setRowSorter(new TableRowSorter(modelo));
        
        readJTable();
    }
    
    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) this.tabelaAmigos.getModel();
        modelo.setNumRows(0); // 
        
        AmigoDAO amigoDao = new AmigoDAO();
        
        for (Amigo a: amigoDao.read()) {
            
            modelo.addRow(new Object[]{
                a.getIdAmigo(),
                a.getNome(),
                a.getTelefone(),
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAmigos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputTelefone = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatorio de amigos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("HISTÓRICO DE AMIGOS");

        tabelaAmigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone"
            }
        ));
        tabelaAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAmigosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAmigos);
        if (tabelaAmigos.getColumnModel().getColumnCount() > 0) {
            tabelaAmigos.getColumnModel().getColumn(0).setMaxWidth(55);
            tabelaAmigos.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel3.setText("Nome");

        jLabel4.setText("ID");

        jLabel5.setText("Telefone");

        btnExcluir.setBackground(new java.awt.Color(64, 61, 57));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(195, 47, 39));
        btnExcluir.setText("Deletar");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(64, 61, 57));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(246, 170, 28));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

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
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(60, 60, 60)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(55, 55, 55))
                                .addComponent(inputTelefone)))))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        
        if (tabelaAmigos.getSelectedRow() != -1) {
            int[] selectedRows = tabelaAmigos.getSelectedRows();
            AmigoDAO dao = new AmigoDAO();

            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                for (int i = 0; i < selectedRows.length; i++) {
                    int modelIndex = tabelaAmigos.convertRowIndexToModel(selectedRows[i]);
                    int id = (int) tabelaAmigos.getModel().getValueAt(modelIndex, 0);
                    Amigo amigo = new Amigo();
                    amigo.setIdAmigo(id);
                    dao.delete(amigo);
                }

                // Limpar campos
                this.inputId.setText("");
                this.inputNome.setText("");
                this.inputTelefone.setText("");

                // Atualizar tabela
                readJTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um ou mais produtos para excluir.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        
        int id = 0;
        String nome = "";
        String telefone = "";

        if (this.inputNome.getText().length() <= 2) {
            JOptionPane.showMessageDialog(null, "O campo nome deve ter pelo menos 3 caracteres!");
        } else {
            nome = this.inputNome.getText();
        }

        if (this.inputTelefone.getText().length() <= 2) {
            JOptionPane.showMessageDialog(null, "O campo telefone deve conter o DDD e 8 caracteres");
        } else {
            telefone = this.inputTelefone.getText();
        }

        if (this.tabelaAmigos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma Ferramenta para Alterar");
        } else {
            id = Integer.parseInt(this.tabelaAmigos.getValueAt(this.tabelaAmigos.getSelectedRow(), 0).toString());
        }

        if (tabelaAmigos.getSelectedRow() != -1) {

            Amigo amigo = new Amigo(); //instancia ferramenta
            AmigoDAO dao = new AmigoDAO(); //conecta sql

            //atualiza os valores
            amigo.setNome(nome);
            amigo.setTelefone(telefone);
            amigo.setIdAmigo(id);

            //update nos dados
            dao.update(amigo);

            //limpando os campos
            this.inputId.setText("");
            this.inputNome.setText("");
            this.inputTelefone.setText("");

            //atualizando tabela
            readJTable();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tabelaAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAmigosMouseClicked
        
        if (this.tabelaAmigos.getSelectedRow() != -1) {
            
            String id = this.tabelaAmigos.getValueAt(this.tabelaAmigos.getSelectedRow(), 0).toString();
            String nome = this.tabelaAmigos.getValueAt(this.tabelaAmigos.getSelectedRow(), 1).toString();
            String telefone = this.tabelaAmigos.getValueAt(this.tabelaAmigos.getSelectedRow(), 2).toString();

            this.inputId.setText(id);
            this.inputNome.setText(nome);
            this.inputTelefone.setText(telefone);
        }
    }//GEN-LAST:event_tabelaAmigosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(RelatorioAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioAmigo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputTelefone;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAmigos;
    // End of variables declaration//GEN-END:variables
}

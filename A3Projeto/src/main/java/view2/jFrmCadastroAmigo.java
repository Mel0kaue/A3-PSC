package view2;

import dao.AmigosDAO;
import dao.FerramentaDAO;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Amigo;
import model.Ferramenta;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author kauem
 */
public class jFrmCadastroAmigo extends javax.swing.JFrame {

    public jFrmCadastroAmigo() {

        initComponents();

        //pra centraliazr a exibição dos valores na tabela
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        // Permitir seleção de múltiplas linhas
        jTableCadastroAmigos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Aplicar o renderer às colunas desejadas (ID e Quantidade)
        jTableCadastroAmigos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // Coluna ID

        readJtable(); //carrega a tabela
    }

    public void readJtable() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableCadastroAmigos.getModel();
        modelo.setNumRows(0); //posiciona na primeira linha da tabela

        AmigosDAO adao = new AmigosDAO();

        for (Amigo a : adao.read()) {

            modelo.addRow(new Object[]{
                a.getIdAmigo(),
                a.getNome(),
                a.getTelefone()
            });
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadastroAmigos = new javax.swing.JTable();
        txtNome = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        btnAdicionarAmigo = new javax.swing.JButton();
        btnExcluirAmigo = new javax.swing.JButton();
        btnAlterarAmigo = new javax.swing.JButton();
        jFormatTelefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar amigos");

        jTableCadastroAmigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableCadastroAmigos.setShowHorizontalLines(true);
        jTableCadastroAmigos.setShowVerticalLines(true);
        jTableCadastroAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadastroAmigosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadastroAmigos);

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefone.setText("Telefone:");

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setText("Nome:");

        btnAdicionarAmigo.setText("Adicionar");
        btnAdicionarAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAmigoActionPerformed(evt);
            }
        });
        btnAdicionarAmigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAdicionarAmigoKeyPressed(evt);
            }
        });

        btnExcluirAmigo.setText("Excluir");
        btnExcluirAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAmigoActionPerformed(evt);
            }
        });

        btnAlterarAmigo.setText("Alterar");
        btnAlterarAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarAmigoActionPerformed(evt);
            }
        });

        try {
            jFormatTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormatTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormatTelefoneKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone)
                            .addComponent(lblNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                            .addComponent(jFormatTelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdicionarAmigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAlterarAmigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluirAmigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnAdicionarAmigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterarAmigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirAmigo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefone)
                            .addComponent(jFormatTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dados() {

        Amigo amg = new Amigo(); //instancia produto
        AmigosDAO dao = new AmigosDAO(); //conecta sql

        //atualiza os valores
        amg.setNome(txtNome.getText());
        amg.setTelefone(jFormatTelefone.getText());

        //insere novo objeto dentro da tabela
        dao.create(amg);

        //limpando os campos
        txtNome.setText("");
        jFormatTelefone.setText("");

        //atualizando tabela
        readJtable();
    }
    private void btnAdicionarAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAmigoActionPerformed

        Amigo amg = new Amigo(); //instancia produto
        AmigosDAO dao = new AmigosDAO(); //conecta sql

        //atualiza os valores
        amg.setNome(txtNome.getText());
        amg.setTelefone(jFormatTelefone.getText());

        dao.create(amg);

        //limpando os campos
        txtNome.setText("");
        jFormatTelefone.setText("");

        //atualizando tabela
        readJtable();
    }//GEN-LAST:event_btnAdicionarAmigoActionPerformed

    private void btnAdicionarAmigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAdicionarAmigoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dados();
        }
    }//GEN-LAST:event_btnAdicionarAmigoKeyPressed

    private void btnExcluirAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAmigoActionPerformed

        if (jTableCadastroAmigos.getSelectedRow() != -1) {
            int[] selectedRows = jTableCadastroAmigos.getSelectedRows();
            AmigosDAO dao = new AmigosDAO();

            for (int i = 0; i < selectedRows.length; i++) {
                int modelIndex = jTableCadastroAmigos.convertRowIndexToModel(selectedRows[i]);
                int id = (int) jTableCadastroAmigos.getModel().getValueAt(modelIndex, 0);
                Amigo amg = new Amigo();
                amg.setIdAmigo(id);
                dao.delete(amg);

                //limpa os campos
                txtNome.setText("");
                jFormatTelefone.setText("");

                //atualizando tabela
                readJtable();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
    }//GEN-LAST:event_btnExcluirAmigoActionPerformed

    private void btnAlterarAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarAmigoActionPerformed

        if (jTableCadastroAmigos.getSelectedRow() != -1) {

            Amigo amg = new Amigo(); //instancia amigo
            AmigosDAO dao = new AmigosDAO(); //conecta sql

            //atualiza os valores
            amg.setNome(txtNome.getText());
            amg.setTelefone(jFormatTelefone.getText());
            amg.setIdAmigo((int) jTableCadastroAmigos.getValueAt(jTableCadastroAmigos.getSelectedRow(), 0)); //pega id na tabela 0

            //update nos dados
            dao.update(amg);

            //limpando os campos
            txtNome.setText("");
            jFormatTelefone.setText("");

            //atualizando tabela
            readJtable();
        }
    }//GEN-LAST:event_btnAlterarAmigoActionPerformed

    //preencher os campos ao selecionar objeto na tabela
    private void jTableCadastroAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroAmigosMouseClicked
        // TODO add your handling code here:
        if (this.jTableCadastroAmigos.getSelectedRow() != -1) {

            String nome = this.jTableCadastroAmigos.getValueAt(this.jTableCadastroAmigos.getSelectedRow(), 1).toString();
            String telefone = this.jTableCadastroAmigos.getValueAt(this.jTableCadastroAmigos.getSelectedRow(), 2).toString();

            this.txtNome.setText(nome);
            this.jFormatTelefone.setText(telefone);

        }
    }//GEN-LAST:event_jTableCadastroAmigosMouseClicked

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        // ir pro próximo campo clicando Enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            //vai pro inserir custo
            jFormatTelefone.requestFocus();
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void jFormatTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormatTelefoneKeyPressed
        // ir pro próximo campo clicando Enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            //vai pro botão Adicionar
            btnAdicionarAmigo.requestFocus();
        }

    }//GEN-LAST:event_jFormatTelefoneKeyPressed

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
            java.util.logging.Logger.getLogger(jFrmCadastroAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrmCadastroAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrmCadastroAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrmCadastroAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrmCadastroAmigo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAmigo;
    private javax.swing.JButton btnAlterarAmigo;
    private javax.swing.JButton btnExcluirAmigo;
    private javax.swing.JFormattedTextField jFormatTelefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadastroAmigos;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

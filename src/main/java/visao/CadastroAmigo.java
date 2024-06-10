package visao;

import dao.AmigoDAO;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Amigo;

/**
 * Classe responsável pela interface de cadastro de amigos.
 *
 * <p>
 * Esta classe é responsável por fornecer uma interface gráfica para cadastrar
 * amigos.
 * </p>
 *
 * @author josue
 */
public class CadastroAmigo extends javax.swing.JFrame {

    /**
     * Cria uma nova instância de CadastroAmigo.
     */
    public CadastroAmigo() {

        initComponents();

        //Centralizar valores
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        // Permitir seleção de múltiplas linhas
        jTableCadastroAmigos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //Centraliza colunas desejadas
        jTableCadastroAmigos.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); // Coluna Telefone

        readJtable();
    }

    /**
     * Lê os dados da tabela.
     */
    public void readJtable() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableCadastroAmigos.getModel();
        modelo.setNumRows(0);

        AmigoDAO adao = new AmigoDAO();

        for (Amigo a : adao.read()) {

            modelo.addRow(new Object[]{
                a.getNome(),
                a.getTelefone()
            });
        }

    }

    /**
     * Inicializa os componentes da interface.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadastroAmigos = new javax.swing.JTable();
        txtNome = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        btnAdicionarAmigo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jFormatTelefone = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar amigos");

        jTableCadastroAmigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
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
        lblTelefone.setText("Telefone");

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setText("Nome");

        btnAdicionarAmigo.setBackground(new java.awt.Color(255, 255, 255));
        btnAdicionarAmigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdicionarAmigo.setForeground(new java.awt.Color(0, 204, 0));
        btnAdicionarAmigo.setText("Cadastrar");
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

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(195, 47, 39));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cadastrar Amigos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addGap(192, 192, 192))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionarAmigo))
                    .addComponent(lblNome)
                    .addComponent(lblTelefone)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jFormatTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormatTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para lidar com os dados inseridos.
     */
    private void dados() {

        Amigo amg = new Amigo();
        AmigoDAO dao = new AmigoDAO();

        amg.setNome(txtNome.getText());
        amg.setTelefone(jFormatTelefone.getText());

        dao.create(amg);

        //limpando os campos
        txtNome.setText("");
        jFormatTelefone.setText("");

        readJtable();
    }
     /**
     * Método executado quando o botão "Cadastrar" é clicado.
     * 
     * @param evt Evento de clique do mouse.
     */
    private void btnAdicionarAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAmigoActionPerformed

        Amigo amg = new Amigo();
        AmigoDAO dao = new AmigoDAO();

        amg.setNome(txtNome.getText());
        amg.setTelefone(jFormatTelefone.getText());

        dao.create(amg);

        //limpando os campos
        txtNome.setText("");
        jFormatTelefone.setText("");

        readJtable();
    }//GEN-LAST:event_btnAdicionarAmigoActionPerformed

    
    /**
     * Método executado quando a tecla Enter é pressionada no botão "Cadastrar".
     * 
     * @param evt Evento de teclado.
     */
    private void btnAdicionarAmigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAdicionarAmigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dados();
        }
    }//GEN-LAST:event_btnAdicionarAmigoKeyPressed

    
    /**
     * Método executado quando o botão "Cancelar" é clicado.
     * 
     * @param evt Evento de clique do mouse.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

     /**
     * Método executado quando uma célula na tabela de amigos é clicada.
     * 
     * @param evt Evento de clique do mouse.
     */
    private void jTableCadastroAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroAmigosMouseClicked
        if (this.jTableCadastroAmigos.getSelectedRow() != -1) {

            String nome = this.jTableCadastroAmigos.getValueAt(this.jTableCadastroAmigos.getSelectedRow(), 1).toString();
            String telefone = this.jTableCadastroAmigos.getValueAt(this.jTableCadastroAmigos.getSelectedRow(), 2).toString();

            this.txtNome.setText(nome);
            this.jFormatTelefone.setText(telefone);
        }
    }//GEN-LAST:event_jTableCadastroAmigosMouseClicked

    /**
     * Método executado quando a tecla Enter é pressionada no campo de texto Nome.
     * 
     * @param evt Evento de teclado.
     */
    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jFormatTelefone.requestFocus();
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    /**
     * Método executado quando a tecla Enter é pressionada no campo de texto Telefone.
     * 
     * @param evt Evento de teclado.
     */
    private void jFormatTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormatTelefoneKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdicionarAmigo.requestFocus();
        }

    }//GEN-LAST:event_jFormatTelefoneKeyPressed

   /**
     * Método principal. Cria e exibe o formulário de CadastroAmigo.
     * 
     * @param args Argumentos da linha de comando.
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
            java.util.logging.Logger.getLogger(CadastroAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CadastroAmigo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAmigo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JFormattedTextField jFormatTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadastroAmigos;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

package visao;

import dao.AmigoDAO;
import dao.EmprestimoDAO;
import dao.FerramentaDAO;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Amigo;
import modelo.Emprestimo;
import modelo.Ferramenta;

/**
 *
 * @author kauem
 */
public class RelatorioEmprestimo extends javax.swing.JFrame {

    private List<Integer> listaIds = new ArrayList<>();

    public RelatorioEmprestimo() {
        initComponents();

        //Centralizar valores
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        //Cetralizando colunas desejadas 
        TabelaQuantidade.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); // Coluna data
        jTableEmp.getColumnModel().getColumn(2).setCellRenderer(centerRenderer); // Coluna status
        jTableEmp.getColumnModel().getColumn(3).setCellRenderer(centerRenderer); // Coluna status
        readJtable();
        readTabelaQtd();
    }

    public void readJtable() {
        DefaultTableModel modelo = (DefaultTableModel) jTableEmp.getModel();
        modelo.setNumRows(0);
        listaIds.clear();

        EmprestimoDAO edao = new EmprestimoDAO();

        for (Emprestimo e : edao.read()) {

            listaIds.add(e.getID());

            modelo.addRow(new Object[]{
                e.getAmigoEsc(),
                e.getFerramentaEsc(),
                e.getData(),
                e.getStatus()

            });

        }
    }

    public void readTabelaQtd() {
        DefaultTableModel modelo = (DefaultTableModel) TabelaQuantidade.getModel();
        modelo.setNumRows(0);

        EmprestimoDAO edao = new EmprestimoDAO(); //instancia a classe DAO

        // HashMap de id e quantidade
        Map<String, Integer> mapaDeAmigos = new HashMap<>(); //cria um hashmap  

        for (Emprestimo e : edao.read()) {
            if (mapaDeAmigos.containsKey(e.getAmigoEsc())) { //se essa for a chave (o nome)

                int qtd = mapaDeAmigos.get(e.getAmigoEsc()); //cria a variavel qtd e armazena o valor da quantidade
                mapaDeAmigos.put(e.getAmigoEsc(), ++qtd); //adiciona a quantidade dentro do hashmap

                //testando
                System.out.println("quantidade adicionada: " + qtd);
                System.out.println("total: " + mapaDeAmigos.get(e.getAmigoEsc()));
            } else {
                mapaDeAmigos.put(e.getAmigoEsc(), e.getQuantidade()); //senão, mantém como tava
                System.out.println("nada adicionado à quantidade");
            }
        }

        for (Map.Entry<String, Integer> entry : mapaDeAmigos.entrySet()) {
            modelo.addRow(new Object[]{
                entry.getKey(),
                entry.getValue()
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

        lblEmpAtivos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEmp = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaQuantidade = new javax.swing.JTable();
        lblEmpAtivos1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de empréstimos");

        lblEmpAtivos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmpAtivos.setText("RELATÓRIO DE EMPRÉSTIMOS");

        jTableEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Ferramenta", "Data", "Status"
            }
        ));
        jTableEmp.setShowGrid(true);
        jScrollPane2.setViewportView(jTableEmp);

        jButton1.setText("Registrar Devolução");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("↩");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TabelaQuantidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TabelaQuantidade.setColumnSelectionAllowed(true);
        TabelaQuantidade.setShowGrid(true);
        TabelaQuantidade.setShowHorizontalLines(true);
        TabelaQuantidade.setShowVerticalLines(true);
        jScrollPane1.setViewportView(TabelaQuantidade);
        TabelaQuantidade.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (TabelaQuantidade.getColumnModel().getColumnCount() > 0) {
            TabelaQuantidade.getColumnModel().getColumn(1).setPreferredWidth(14);
        }

        lblEmpAtivos1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmpAtivos1.setText("QUANTIDADE POR AMIGO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmpAtivos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpAtivos1))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpAtivos)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpAtivos1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int[] selectedRows = jTableEmp.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecione ao menos uma linha para excluir.");
            return;
        }

        EmprestimoDAO dao = new EmprestimoDAO();
        FerramentaDAO fdao = new FerramentaDAO();

        for (int i = 0; i < selectedRows.length; i++) {
            int modelRow = jTableEmp.convertRowIndexToModel(selectedRows[i]);

            if (modelRow >= 0 && modelRow < listaIds.size()) {
                int id = listaIds.get(modelRow);

                String nome = (String) jTableEmp.getModel().getValueAt(modelRow, 1);
                System.out.println("nome da ferramenta: " + nome);

                Emprestimo e = new Emprestimo();
                e.setID(id);
                e.setStatus("Devolvido");
                dao.updateStatus(e);

                Ferramenta ferramenta = fdao.getPorNome(nome);

                if (ferramenta != null) {
                    ferramenta.setQuantidade(ferramenta.getQuantidade() + 1);
                    fdao.update(ferramenta);
                }

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String dataHora = sdf.format(new Date());
                JOptionPane.showMessageDialog(rootPane, "Devolução realizada em: " + dataHora);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao realizar a devolução. Índice inválido.");
                return;
            }
            readJtable();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int[] selectedRows = jTableEmp.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecione ao menos uma linha para excluir.");
            return;
        }
        EmprestimoDAO dao = new EmprestimoDAO();
        FerramentaDAO fdao = new FerramentaDAO();

        for (int i = 0; i < selectedRows.length; i++) {
            int modelRow = jTableEmp.convertRowIndexToModel(selectedRows[i]);

            if (modelRow >= 0 && modelRow < listaIds.size()) {
                int id = listaIds.get(modelRow);

                String nome = (String) jTableEmp.getModel().getValueAt(modelRow, 1);

                Emprestimo e = new Emprestimo();
                e.setID(id);
                e.setStatus("Ativo");
                dao.updateStatus(e);

                Ferramenta ferramenta = fdao.getPorNome(nome);

                if (ferramenta != null) {
                    ferramenta.setQuantidade(ferramenta.getQuantidade() - 1);
                    fdao.update(ferramenta);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao realizar a devolução. Índice inválido.");
                return;
            }
            readJtable();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new RelatorioEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaQuantidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEmp;
    private javax.swing.JLabel lblEmpAtivos;
    private javax.swing.JLabel lblEmpAtivos1;
    // End of variables declaration//GEN-END:variables
}

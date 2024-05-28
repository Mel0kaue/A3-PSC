/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import dao.AmigosDAO;
import dao.EmprestimosDAO;
import dao.FerramentaDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import modelo.Amigo;
import modelo.Emprestimos;
import modelo.Ferramenta;

/**
 *
 * @author kauem
 */
public class jFrmRealizarEmp extends javax.swing.JFrame {

    private List<Integer> listaIds = new ArrayList<>();

    MaskFormatter mfData;

    public jFrmRealizarEmp() {

        try {
            mfData = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            System.out.println("Ocorreu um erro na criação da máscara");
        }

        initComponents();

        DefaultTableModel modelo = (DefaultTableModel) jTableEmprestimos.getModel();
        jTableEmprestimos.setRowSorter(new TableRowSorter(modelo));

        // Permitir seleção de múltiplas linhas
        jTableEmprestimos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //pra centraliazr a exibição dos valores na tabela
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        // Aplicar o renderer às colunas desejadas (ID e Quantidade)
        jTableEmprestimos.getColumnModel().getColumn(2).setCellRenderer(centerRenderer); // Coluna emprestimo
        jTableEmprestimos.getColumnModel().getColumn(3).setCellRenderer(centerRenderer); // Coluna devolução

        carregarAmigos();
        carregarFerramentas();
        readJtable();

    }

    //puxando ferramentas do bd
    private void carregarFerramentas() {
        FerramentaDAO ferramentaDAO = new FerramentaDAO();
        List<Ferramenta> ferramentas = ferramentaDAO.read();

        for (Ferramenta ferramenta : ferramentas) {
            jComboBoxFerramenta.addItem(ferramenta.getNome());
        }
    }

    private void carregarAmigos() {
        AmigosDAO amigosDAO = new AmigosDAO();
        List<Amigo> amigos = amigosDAO.read();

        for (Amigo amigo : amigos) {
            jComboBoxAmiguitos.addItem(amigo.getNome());
        }
    }

    // Método para converter a data do formato DD/MM/YYYY para java.sql.Date no formato YYYY-MM-DD
    private Date convertStringToDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = null;
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new java.sql.Date(date.getTime());
    }

    public void readJtable() {
        DefaultTableModel modelo = (DefaultTableModel) jTableEmprestimos.getModel();
        modelo.setNumRows(0);
        listaIds.clear();

        EmprestimosDAO edao = new EmprestimosDAO();

        for (Emprestimos e : edao.read()) {

            listaIds.add(e.getID());

            modelo.addRow(new Object[]{
                //e.getID(),
                e.getAmigoEsc(),
                e.getFerramentaEsc(),
                e.getDataEms(),
                e.getDataDev()
            });

        }
    }

    private void dados() throws ParseException {

        Emprestimos e = new Emprestimos(); //instancia produto
        EmprestimosDAO dao = new EmprestimosDAO(); //conecta sql

        //atualiza os valores
        e.setAmigoEsc((String) jComboBoxAmiguitos.getSelectedItem());
        e.setFerramentaEsc((String) jComboBoxFerramenta.getSelectedItem());

        // Obtém as datas do formulário
        String dataEmpStr = jFormDataEmp.getText();
        String dataDevStr = jFormDataDevolucao.getText();

        // Converte as datas para java.sql.Date
        Date dataEmp = convertStringToDate(dataEmpStr);
        Date dataDev = convertStringToDate(dataDevStr);

        // Converte as datas para java.sql.Date
        java.sql.Date sqlDataEmp = new java.sql.Date(dataEmp.getTime());
        java.sql.Date sqlDataDev = new java.sql.Date(dataDev.getTime());

        // Define as datas convertidas no objeto Emprestimos
        e.setDataEms(sqlDataEmp);
        e.setDataDev(sqlDataDev);

        //limpando os campos
        jFormDataEmp.setText("");
        jFormDataDevolucao.setText("");

        try {
            //insere novo objeto dentro da tabela
            dao.create(e, dataEmpStr, dataDevStr);
        } catch (ParseException ex) {
            Logger.getLogger(jFrmRealizarEmp.class.getName()).log(Level.SEVERE, null, ex);
        }

        //atualizando tabela
        readJtable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFerramenta = new javax.swing.JLabel();
        lblAmigo = new javax.swing.JLabel();
        jComboBoxFerramenta = new javax.swing.JComboBox<>();
        btnRealizarEmp = new javax.swing.JButton();
        jFormDataEmp = new javax.swing.JFormattedTextField(mfData);
        jFormDataDevolucao = new javax.swing.JFormattedTextField(mfData);
        lblDataEmp = new javax.swing.JLabel();
        lblDataDev = new javax.swing.JLabel();
        jComboBoxAmiguitos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmprestimos = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar empréstimo");

        lblFerramenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFerramenta.setText("Ferramenta:");

        lblAmigo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAmigo.setText("Amigo:");

        jComboBoxFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFerramentaActionPerformed(evt);
            }
        });

        btnRealizarEmp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRealizarEmp.setText("Realizar Empréstimo");
        btnRealizarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarEmpActionPerformed(evt);
            }
        });

        jFormDataEmp.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jFormDataDevolucao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormDataDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormDataDevolucaoActionPerformed(evt);
            }
        });

        lblDataEmp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDataEmp.setText("Data do Empréstimo:");

        lblDataDev.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDataDev.setText("Data de Devolução:");

        jComboBoxAmiguitos.setToolTipText("");
        jComboBoxAmiguitos.setName(""); // NOI18N
        jComboBoxAmiguitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAmiguitosActionPerformed(evt);
            }
        });

        jTableEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Amigo", "Ferramenta", "Empréstimo", "Devolução"
            }
        ));
        jScrollPane1.setViewportView(jTableEmprestimos);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAmigo)
                            .addComponent(jComboBoxAmiguitos, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataDev)
                            .addComponent(lblDataEmp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFormDataEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jFormDataDevolucao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRealizarEmp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAmigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAmiguitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataEmp)
                            .addComponent(jFormDataEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataDev)
                            .addComponent(jFormDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnRealizarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFerramentaActionPerformed
    }//GEN-LAST:event_jComboBoxFerramentaActionPerformed


    private void btnRealizarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarEmpActionPerformed
        // TODO add your handling code here:

        // Obtém as datas do formulário
        String dataEmpStr = jFormDataEmp.getText();
        String dataDevStr = jFormDataDevolucao.getText();

        // Converte as datas para java.sql.Date
        Date dataEmp = convertStringToDate(dataEmpStr);
        Date dataDev = convertStringToDate(dataDevStr);

        // Verifica se as datas foram convertidas corretamente
        if (dataEmp == null || dataDev == null) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Emprestimos e = new Emprestimos(); //instancia produto
        EmprestimosDAO dao = new EmprestimosDAO(); //conecta sql

        //atualiza os valores
        e.setAmigoEsc((String) jComboBoxAmiguitos.getSelectedItem());
        e.setFerramentaEsc((String) jComboBoxFerramenta.getSelectedItem());

        // Converte as datas para java.sql.Date
        java.sql.Date sqlDataEmp = new java.sql.Date(dataEmp.getTime());
        java.sql.Date sqlDataDev = new java.sql.Date(dataDev.getTime());

        // Define as datas convertidas no objeto Emprestimos
        e.setDataEms(sqlDataEmp);
        e.setDataDev(sqlDataDev);

        try {
            //insere novo objeto dentro da tabela
            dao.create(e, dataEmpStr, dataDevStr);
        } catch (ParseException ex) {
            Logger.getLogger(jFrmRealizarEmp.class.getName()).log(Level.SEVERE, null, ex);
        }

        //limpando os campos
        jFormDataEmp.setText("");
        jFormDataDevolucao.setText("");

        //atualizando tabela
        readJtable();

    }//GEN-LAST:event_btnRealizarEmpActionPerformed

    private void jComboBoxAmiguitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAmiguitosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAmiguitosActionPerformed

    private void jFormDataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormDataDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormDataDevolucaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        int[] selectedRows = jTableEmprestimos.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecione ao menos uma linha para excluir.");
            return;
        }

        EmprestimosDAO dao = new EmprestimosDAO();

        for (int i = 0; i < selectedRows.length; i++) {
            int modelRow = jTableEmprestimos.convertRowIndexToModel(selectedRows[i]);

            if (modelRow >= 0 && modelRow < listaIds.size()) {
                int id = listaIds.get(modelRow);

                Emprestimos e = new Emprestimos();
                e.setID(id);
                dao.delete(e);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir. Índice inválido.");
                return;
            }
        }
        
        //atualizando tabela
        readJtable();
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(jFrmRealizarEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrmRealizarEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrmRealizarEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrmRealizarEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrmRealizarEmp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnRealizarEmp;
    private javax.swing.JComboBox<String> jComboBoxAmiguitos;
    private javax.swing.JComboBox<String> jComboBoxFerramenta;
    private javax.swing.JFormattedTextField jFormDataDevolucao;
    private javax.swing.JFormattedTextField jFormDataEmp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmprestimos;
    private javax.swing.JLabel lblAmigo;
    private javax.swing.JLabel lblDataDev;
    private javax.swing.JLabel lblDataEmp;
    private javax.swing.JLabel lblFerramenta;
    // End of variables declaration//GEN-END:variables
}

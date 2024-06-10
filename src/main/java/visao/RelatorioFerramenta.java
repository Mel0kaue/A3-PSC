package visao;

import dao.EmprestimoDAO;
import dao.FerramentaDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Emprestimo;
import modelo.Ferramenta;

/**
 *
 * @author josue
 */
public class RelatorioFerramenta extends javax.swing.JFrame {

    private List<Ferramenta> listaFerramentas = new ArrayList<>();
    Map<Integer, Ferramenta> mapaDeFerramentasPorld = new HashMap<>();

    public RelatorioFerramenta() {
        initComponents();

        DefaultTableModel modelo = (DefaultTableModel) this.tabelaFerramenta.getModel();
        tabelaFerramenta.setRowSorter(new TableRowSorter(modelo));

        tabelaFerramenta.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaFerramenta.getColumnModel().getColumn(0).setMaxWidth(0);

        //Centralizar valores
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        //Cetralizando colunas desejadas 
        tabelaFerramenta.getColumnModel().getColumn(4).setCellRenderer(centerRenderer); // Coluna status
        readJTable();
    }

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaFerramenta.getModel();
        modelo.setNumRows(0);

        FerramentaDAO fdao = new FerramentaDAO();
        List<Ferramenta> listFerramentas = fdao.read();

        // Mapa para armazenar as ferramentas já existentes na tabela
        Map<String, Integer> ferramentasExistente = new HashMap<>();

        for (Ferramenta f : listFerramentas) {
            // Gerar uma chave única com base no nome, marca e custo da ferramenta
            String chave = f.getNome() + "-" + f.getMarca() + "-" + String.format("%.2f", f.getCusto());

            if (ferramentasExistente.containsKey(chave)) {
                // Se a ferramenta já existe na tabela, atualizar a quantidade
                int indice = ferramentasExistente.get(chave);
                int quantidadeAtual = (int) modelo.getValueAt(indice, 4);
                modelo.setValueAt(quantidadeAtual + f.getQuantidade(), indice, 4);
            } else {
                modelo.addRow(new Object[]{
                    f.getId(),
                    f.getNome(),
                    f.getMarca(),
                    String.format("R$ %.2f", f.getCusto()),
                    f.getQuantidade()
                });
                ferramentasExistente.put(chave, modelo.getRowCount() - 1); // Armazenar o índice da nova ferramenta
            }
        }
        double total = FerramentaDAO.somarValores();
        String totalTxt = Double.toString(total);

        this.inputTotal.setText(totalTxt);
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
        inputTotal = new javax.swing.JLabel();

        jScrollPane2.setViewportView(txtPaneGasto);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de ferramentas");

        lblHistCompras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHistCompras.setText("RELATÓRIO DE FERRAMENTAS");

        tabelaFerramenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Marca", "Valor", "Quantidade"
            }
        ));
        tabelaFerramenta.setShowGrid(true);
        tabelaFerramenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFerramentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFerramenta);
        if (tabelaFerramenta.getColumnModel().getColumnCount() > 0) {
            tabelaFerramenta.getColumnModel().getColumn(0).setHeaderValue("ID");
        }

        lblTotGasto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

        inputTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputTotal.setText("0.0");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblHistCompras)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotGasto)
                    .addComponent(inputTotal))
                .addGap(34, 34, 34)
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
                .addContainerGap(48, Short.MAX_VALUE))
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

        FerramentaDAO dao = new FerramentaDAO();
        Ferramenta ferramentaAtual = dao.getPorId(id);

        if (ferramentaAtual != null) {
            ferramentaAtual.setNome(nome);
            ferramentaAtual.setMarca(marca);
            ferramentaAtual.setCusto(preco);

            dao.update(ferramentaAtual);

            // Limpa os campos
            this.inputNome.setText("");
            this.inputMarca.setText("");
            this.inputValor.setText("");

            readJTable();
        } else {
            JOptionPane.showMessageDialog(null, "Ferramenta não encontrada.");
        }
    }//GEN-LAST:event_btnAlterarFerramentaActionPerformed

    private void tabelaFerramentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFerramentaMouseClicked

        if (this.tabelaFerramenta.getSelectedRow() != -1) {

            String nome = this.tabelaFerramenta.getValueAt(this.tabelaFerramenta.getSelectedRow(), 1).toString();
            String marca = this.tabelaFerramenta.getValueAt(this.tabelaFerramenta.getSelectedRow(), 2).toString();
            String aquisicao = this.tabelaFerramenta.getValueAt(this.tabelaFerramenta.getSelectedRow(), 3).toString().replace("R$ ", "");

            this.inputNome.setText(nome);
            this.inputMarca.setText(marca);
            this.inputValor.setText(aquisicao);
        }
    }//GEN-LAST:event_tabelaFerramentaMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        FerramentaDAO dao = new FerramentaDAO();

        listaFerramentas = dao.read();
        System.out.println("lista: " + listaFerramentas);

        for (int i = 0; i < listaFerramentas.size(); i++) {
            mapaDeFerramentasPorld.put(listaFerramentas.get(i).getId(), listaFerramentas.get(i));
        }
        if (tabelaFerramenta.getSelectedRow() != -1) { //se a linha selecionada for diferente de -1
            int[] selectedRows = tabelaFerramenta.getSelectedRows(); //pega a linha selecionada

            //pergunta de confirmação
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                //se confirmar 
                for (int i = 0; i < selectedRows.length; i++) {
                    int modelIndex = tabelaFerramenta.convertRowIndexToModel(selectedRows[i]);
                    int id = (int) tabelaFerramenta.getModel().getValueAt(modelIndex, 0);

                    Ferramenta ferramenta = mapaDeFerramentasPorld.get(id);
                    System.out.println("id: " + ferramenta.getId());

                    if (ferramenta.getQuantidade() == 0) {
                        dao.delete(ferramenta);
                    } else {
                        ferramenta.emprestar();
                        dao.update(ferramenta);
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
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
    private javax.swing.JLabel inputTotal;
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
    // End of variables declaration//GEN-END:variables
}

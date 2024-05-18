/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view2;

import dao.FerramentaDAO;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import model.Ferramenta;

/**
 *
 * @author kauem
 */
public class jFrmCadastroFerramentas extends javax.swing.JFrame {

    /**
     * Creates new form jFrmCadastroFerramentas
     */
    MaskFormatter mfCusto;
    MaskFormatter mfAluguel;

    public jFrmCadastroFerramentas() {

        try {
            mfCusto = new MaskFormatter("R$##,##");
        } catch (ParseException ex) {
            System.out.println("erro na criação da mascara");
        }

        try {
            mfAluguel = new MaskFormatter("R$##,##");
        } catch (ParseException ex) {
            System.out.println("erro na criação da mascara");
        }

        initComponents();

        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroFerramenta.getModel();
        jTableCadastroFerramenta.setRowSorter(new TableRowSorter(modelo));

        // Permitir seleção de múltiplas linhas
        jTableCadastroFerramenta.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //pra centraliazr a exibição dos valores na tabela
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        // Aplicar o renderer às colunas desejadas (ID e Quantidade)
        jTableCadastroFerramenta.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // Coluna ID
        jTableCadastroFerramenta.getColumnModel().getColumn(5).setCellRenderer(centerRenderer); // Coluna Quantidade

        readJtable();
    }

    //Método que atualiza a tabela com os valores adicionados
    public void readJtable() {
        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroFerramenta.getModel();
        modelo.setNumRows(0);

        FerramentaDAO fdao = new FerramentaDAO();

        for (Ferramenta f : fdao.read()) {

            modelo.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getMarca(),
                String.format("R$ %.2f", f.getCusto()),
                String.format("R$ %.2f", f.getAluguel()),
                f.getQuantidade()
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

        jLabel1 = new javax.swing.JLabel();
        lblFerramenta = new javax.swing.JLabel();
        lblUnidade = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        txtInserirFerramenta = new javax.swing.JTextField();
        txtInserirMarca = new javax.swing.JTextField();
        btnAdicionarFerramenta = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterarFerramenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadastroFerramenta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtFormatCusto = new javax.swing.JFormattedTextField(mfCusto);
        txtFormatAluguel = new javax.swing.JFormattedTextField(mfCusto);
        txtFormatQuantidade = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar ferramentas");

        lblFerramenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFerramenta.setText("Ferramenta:");

        lblUnidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUnidade.setText("Custo de aq:");

        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMarca.setText("Marca:");

        txtInserirFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInserirFerramentaActionPerformed(evt);
            }
        });
        txtInserirFerramenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtInserirFerramentaKeyPressed(evt);
            }
        });

        txtInserirMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInserirMarcaActionPerformed(evt);
            }
        });
        txtInserirMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtInserirMarcaKeyPressed(evt);
            }
        });

        btnAdicionarFerramenta.setText("Adicionar");
        btnAdicionarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarFerramentaActionPerformed(evt);
            }
        });
        btnAdicionarFerramenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAdicionarFerramentaKeyPressed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterarFerramenta.setText("Alterar");
        btnAlterarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarFerramentaActionPerformed(evt);
            }
        });

        jTableCadastroFerramenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ferramenta", "Marca", "Custo de Aquisição", "Aluguel", "Qtd"
            }
        ));
        jTableCadastroFerramenta.setShowHorizontalLines(true);
        jTableCadastroFerramenta.setShowVerticalLines(true);
        jTableCadastroFerramenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadastroFerramentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadastroFerramenta);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Aluguel:");

        txtFormatCusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtFormatCusto.setValue(0.00);
        txtFormatCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFormatCustoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFormatCustoFocusLost(evt);
            }
        });
        txtFormatCusto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFormatCustoKeyPressed(evt);
            }
        });

        txtFormatAluguel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtFormatAluguel.setValue(0.00);
        txtFormatAluguel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFormatAluguelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFormatAluguelFocusLost(evt);
            }
        });
        txtFormatAluguel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFormatAluguelKeyPressed(evt);
            }
        });

        txtFormatQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtFormatQuantidade.setValue(0);
        txtFormatQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFormatQuantidadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFormatQuantidadeFocusLost(evt);
            }
        });
        txtFormatQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFormatQuantidadeKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Quantidade:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblFerramenta, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                        .addComponent(txtInserirFerramenta, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                                    .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInserirMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(lblUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFormatCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFormatAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btnAdicionarFerramenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluir)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(btnAlterarFerramenta))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFormatQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInserirFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFormatCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInserirMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormatAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormatQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarFerramenta)
                    .addComponent(btnAlterarFerramenta)
                    .addComponent(btnExcluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /* dados() => mesmo método do botão adicionar, mas usado pra executar
        a ação do botão ao pressionar enter
     */
    private void dados() {

        Ferramenta f = new Ferramenta(); //instancia produto
        FerramentaDAO dao = new FerramentaDAO(); //conecta sql

        //atualiza os valores
        f.setNome(txtInserirFerramenta.getText());
        f.setMarca(txtInserirMarca.getText());
        f.setCusto(Double.parseDouble(txtFormatCusto.getText().replace(',', '.')));
        f.setAluguel(Double.parseDouble(txtFormatAluguel.getText().replace(',', '.')));
        f.setQuantidade(Integer.parseInt(txtFormatQuantidade.getText()));

        //insere novo objeto dentro da tabela
        dao.create(f);

        //limpando os campos
        txtInserirFerramenta.setText("");
        txtInserirMarca.setText("");
        txtFormatCusto.setText("");
        txtFormatAluguel.setText("");
        txtFormatQuantidade.setText("");

        //atualizando tabela
        readJtable();
    }

    private void txtInserirFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInserirFerramentaActionPerformed
        //label do botão ferramenta
    }//GEN-LAST:event_txtInserirFerramentaActionPerformed

    // BOTAO ADICIONAR
    private void btnAdicionarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarFerramentaActionPerformed

        Ferramenta f = new Ferramenta(); //instancia produto
        FerramentaDAO dao = new FerramentaDAO(); //conecta sql

        //atualiza os valores
        f.setNome(txtInserirFerramenta.getText());
        f.setMarca(txtInserirMarca.getText());
        f.setCusto(Double.parseDouble(txtFormatCusto.getText().replace(',', '.')));
        f.setAluguel(Double.parseDouble(txtFormatAluguel.getText().replace(',', '.')));
        f.setQuantidade(Integer.parseInt(txtFormatQuantidade.getText()));
        dao.create(f);

        //limpando os campos
        txtInserirFerramenta.setText("");
        txtInserirMarca.setText("");
        txtFormatCusto.setText("");
        txtFormatAluguel.setText("");
        txtFormatQuantidade.setText("");

        //atualizando tabela
        readJtable();
    }//GEN-LAST:event_btnAdicionarFerramentaActionPerformed

    // BOTAO ALTERAR
    private void btnAlterarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarFerramentaActionPerformed

        if (jTableCadastroFerramenta.getSelectedRow() != -1) {

            Ferramenta f = new Ferramenta(); //instancia produto
            FerramentaDAO dao = new FerramentaDAO(); //conecta sql

            //atualiza os valores
            f.setNome(txtInserirFerramenta.getText());
            f.setMarca(txtInserirMarca.getText());
            f.setCusto(Double.parseDouble(txtFormatCusto.getText().replace(',', '.')));
            f.setAluguel(Double.parseDouble(txtFormatAluguel.getText().replace(',', '.')));
            f.setQuantidade(Integer.parseInt(txtFormatQuantidade.getText()));

            //update nos dados
            dao.update(f);

            //limpando os campos
            txtInserirFerramenta.setText("");
            txtInserirMarca.setText("");
            txtFormatCusto.setText("");
            txtFormatAluguel.setText("");
            txtFormatQuantidade.setText("");

            //atualizando tabela
            readJtable();
        }
    }//GEN-LAST:event_btnAlterarFerramentaActionPerformed
    // BOTAO EXCLUIR
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        if (jTableCadastroFerramenta.getSelectedRow() != -1) {
            int[] selectedRows = jTableCadastroFerramenta.getSelectedRows();
            FerramentaDAO dao = new FerramentaDAO();

            for (int i = 0; i < selectedRows.length; i++) {
                int modelIndex = jTableCadastroFerramenta.convertRowIndexToModel(selectedRows[i]);
                int id = (int) jTableCadastroFerramenta.getModel().getValueAt(modelIndex, 0);
                Ferramenta f = new Ferramenta();
                f.setId(id);
                dao.delete(f);
            }

            // Limpar campos
            txtInserirFerramenta.setText("");
            txtInserirMarca.setText("");
            txtFormatCusto.setText("");
            txtFormatAluguel.setText("");
            txtFormatQuantidade.setText("");

            // Atualizar tabela
            readJtable();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um ou mais produtos para excluir.");
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtInserirMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInserirMarcaActionPerformed
        // label do botao marca
    }//GEN-LAST:event_txtInserirMarcaActionPerformed

    private void txtInserirFerramentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInserirFerramentaKeyPressed
        // ir pro próximo campo clicando Enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            //vai pro inserir marca
            txtInserirMarca.requestFocus();
        }

    }//GEN-LAST:event_txtInserirFerramentaKeyPressed

    private void txtInserirMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInserirMarcaKeyPressed
        // ir pro próximo campo clicando Enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            //vai pro inserir custo
            txtFormatCusto.requestFocus();
        }
    }//GEN-LAST:event_txtInserirMarcaKeyPressed

    private void btnAdicionarFerramentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAdicionarFerramentaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dados();
        }
    }//GEN-LAST:event_btnAdicionarFerramentaKeyPressed

    //pro "0,00" que tava no campo sumir quando o usuario clicar
    private void txtFormatCustoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFormatCustoFocusGained

        if ("0,00".equals(txtFormatCusto.getText())) {
            txtFormatCusto.setText("");
        }
    }//GEN-LAST:event_txtFormatCustoFocusGained

    private void txtFormatCustoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFormatCustoKeyPressed
        // ir pro próximo campo clincando Enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            //vai pro inserir aluguel
            txtFormatAluguel.requestFocus();
        }
    }//GEN-LAST:event_txtFormatCustoKeyPressed

    //pro "0" que tava no campo aparecer quando o usuario desclicar
    private void txtFormatCustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFormatCustoFocusLost

        if ("".equals(txtFormatCusto.getText())) {
            txtFormatCusto.setValue(0.00);
        }
    }//GEN-LAST:event_txtFormatCustoFocusLost

    //pro "0,00" que tava no campo sumir quando o usuario clicar
    private void txtFormatAluguelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFormatAluguelFocusGained
        // TODO add your handling code here:
        if ("0,00".equals(txtFormatAluguel.getText())) {
            txtFormatAluguel.setText("");
        }
    }//GEN-LAST:event_txtFormatAluguelFocusGained

    //pro "0,00" que tava no campo aparecer quando o usuario desclicar
    private void txtFormatAluguelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFormatAluguelFocusLost

        if ("".equals(txtFormatAluguel.getText())) {
            txtFormatAluguel.setValue(0.00);
        }
    }//GEN-LAST:event_txtFormatAluguelFocusLost

    private void txtFormatAluguelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFormatAluguelKeyPressed
        // ir pro próximo campo clicando Enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            //vai pro campo quantidade
            txtFormatQuantidade.requestFocus();
        }
    }//GEN-LAST:event_txtFormatAluguelKeyPressed

    //pro "0" que tava no campo sumir quando o usuario clicar
    private void txtFormatQuantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFormatQuantidadeFocusGained
        if ("0".equals(txtFormatQuantidade.getText())) {
            txtFormatQuantidade.setText("");
        }
    }//GEN-LAST:event_txtFormatQuantidadeFocusGained

    //pro "0" que tava no campo aparecer quando o usuario desclicar
    private void txtFormatQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFormatQuantidadeFocusLost
        if ("".equals(txtFormatQuantidade.getText())) {
            txtFormatQuantidade.setValue(0);
        }
    }//GEN-LAST:event_txtFormatQuantidadeFocusLost

    private void txtFormatQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFormatQuantidadeKeyPressed
        // ir pro próximo campo clicando Enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            //vai pro botão adicionar
            btnAdicionarFerramenta.requestFocus();
        }

    }//GEN-LAST:event_txtFormatQuantidadeKeyPressed

    private void jTableCadastroFerramentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroFerramentaMouseClicked
        // TODO add your handling code here:
        if (this.jTableCadastroFerramenta.getSelectedRow() != -1) {

            String nome = this.jTableCadastroFerramenta.getValueAt(this.jTableCadastroFerramenta.getSelectedRow(), 1).toString();
            String marca = this.jTableCadastroFerramenta.getValueAt(this.jTableCadastroFerramenta.getSelectedRow(), 2).toString();
            String aquisicao = this.jTableCadastroFerramenta.getValueAt(this.jTableCadastroFerramenta.getSelectedRow(), 3).toString();
            String aluguel = this.jTableCadastroFerramenta.getValueAt(this.jTableCadastroFerramenta.getSelectedRow(), 4).toString();

            this.txtInserirFerramenta.setText(nome);
            this.txtInserirMarca.setText(marca);
            this.txtFormatCusto.setText(aquisicao);
            this.txtFormatAluguel.setText(aluguel);

        }
    }//GEN-LAST:event_jTableCadastroFerramentaMouseClicked

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
            java.util.logging.Logger.getLogger(jFrmCadastroFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrmCadastroFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrmCadastroFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrmCadastroFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrmCadastroFerramentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarFerramenta;
    private javax.swing.JButton btnAlterarFerramenta;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadastroFerramenta;
    private javax.swing.JLabel lblFerramenta;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblUnidade;
    private javax.swing.JFormattedTextField txtFormatAluguel;
    private javax.swing.JFormattedTextField txtFormatCusto;
    private javax.swing.JFormattedTextField txtFormatQuantidade;
    private javax.swing.JTextField txtInserirFerramenta;
    private javax.swing.JTextField txtInserirMarca;
    // End of variables declaration//GEN-END:variables
}

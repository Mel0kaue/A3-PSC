/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexaobd.ConexaoBancoDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Ferramenta;


public class FerramentaDAO implements DaoGenerico<Ferramenta>{

    public void create(Ferramenta f) {

        Connection con = ConexaoBancoDados.getConnection();//pegando o método da classe ConnectionFactory
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("INSERT INTO tb_ferramentas (nome,marca,Custo, Aluguel) VALUES (?,?,?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getMarca());
            stmt.setDouble(3, f.getCusto());
            stmt.setDouble(4, f.getAluguel());

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "salvo com sucesso!"); //se der certo
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex); //se der errado
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt); //fecha a conexão
        }

    }

    public List<Ferramenta> read() { //lista

        //gerando conexão
        Connection con = ConexaoBancoDados.getConnection(); //pegando o método da classe ConnectionFactory
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Ferramenta> ferramentas = new ArrayList<>(); //cria uma lista pra adicionar os produtos

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_ferramentas");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Ferramenta ferramenta = new Ferramenta();

                ferramenta.setId(rs.getInt("id"));
                ferramenta.setNome(rs.getString("nome"));
                ferramenta.setMarca(rs.getString("marca"));
                ferramenta.setCusto(rs.getDouble("Custo"));
                ferramenta.setAluguel(rs.getDouble("Aluguel"));

                ferramentas.add(ferramenta);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt, rs); //fecha conexão
        }

        return ferramentas;

    }

    public void update(Ferramenta f) { //atualiza

        Connection con = ConexaoBancoDados.getConnection(); //pegando o método da classe ConnectionFactory
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("UPDATE tb_ferramentas SET nome = ?, marca = ?, Custo = ?, Aluguel = ? WHERE id = ?");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getMarca());
            stmt.setDouble(3, f.getCusto());
            stmt.setDouble(4, f.getAluguel());
            stmt.setInt(5, f.getId()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "atualizado com sucesso!"); //se der certo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex); //se der errado
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt); //fecha a conexão
        }

    }
    public void delete(Ferramenta f) { //deleta

        Connection con = ConexaoBancoDados.getConnection(); //pegando o método da classe ConnectionFactory
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("DELETE FROM tb_ferramentas WHERE id = ?");
            stmt.setInt(1, f.getId()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "excluido com sucesso!"); //se der certo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao xcluir: " + ex); //se der errado
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt); //fecha a conexão
        }

    }
    
    public List<Ferramenta> readForDesc(String desc) { //pesquisa

        //gerando conexão
        Connection con = ConexaoBancoDados.getConnection(); //pegando o método da classe ConnectionFactory
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Ferramenta> produtos = new ArrayList<>(); //cria uma lista pra adicionar os produtos

        try { //pesquisar se colocar palavra completa
            stmt = con.prepareStatement("SELECT * FROM tb_ferramentas WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Ferramenta ferramenta = new Ferramenta();

                ferramenta.setId(rs.getInt("id"));
                ferramenta.setNome(rs.getString("descricao"));
                ferramenta.setMarca(rs.getString("Marca"));
                ferramenta.setCusto(rs.getDouble("Custo"));
                ferramenta.setAluguel(rs.getDouble("Aluguel"));
                produtos.add(ferramenta);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt, rs); //fecha conexão
        }

        return produtos;

    }

    @Override
    public void inserir(Ferramenta f) {

        Connection con = ConexaoBancoDados.getConnection();//pegando o método da classe ConnectionFactory
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("INSERT INTO tb_ferramentas (nome,marca,Custo, Aluguel) VALUES (?,?,?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getMarca());
            stmt.setDouble(3, f.getCusto());
            stmt.setDouble(4, f.getAluguel());

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "salvo com sucesso!"); //se der certo
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex); //se der errado
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt); //fecha a conexão
        }
    }

    @Override
    public void alterar(Ferramenta obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Ferramenta> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

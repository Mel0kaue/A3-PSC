/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
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

/**
 *
 * @author Samuelson
 */
public class FerramentaDAO {

    public void create(Ferramenta f) {

        Connection con = ConnectionFactory.getConnection(); //pegando o método da classe ConnectionFactory
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("INSERT INTO tb_ferramenta (Nome,Marca,Unidade, Aluguel) VALUES (?,?,?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getMarca());
            stmt.setDouble(3, f.getUnidade());
            stmt.setDouble(4, f.getAluguel());

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "salvo com sucesso!"); //se der certo
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex); //se der errado
        } finally {
            ConnectionFactory.closeConnection(con, stmt); //fecha a conexão
        }

    }

    public List<Ferramenta> read() { //lista

        //gerando conexão
        Connection con = ConnectionFactory.getConnection(); //pegando o método da classe ConnectionFactory
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Ferramenta> ferramentas = new ArrayList<>(); //cria uma lista pra adicionar os produtos

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_ferramenta");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Ferramenta ferramenta = new Ferramenta();

                ferramenta.setId(rs.getInt("id"));
                ferramenta.setNome(rs.getString("Nome"));
                ferramenta.setMarca(rs.getString("Marca"));
                ferramenta.setUnidade(rs.getDouble("Unidade"));
                ferramenta.setAluguel(rs.getDouble("Aluguel"));

                ferramentas.add(ferramenta);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs); //fecha conexão
        }

        return ferramentas;

    }

    public void update(Ferramenta f) { //atualiza

        Connection con = ConnectionFactory.getConnection(); //pegando o método da classe ConnectionFactory
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("UPDATE tb_ferramenta SET Nome = ?, Marca = ?, Unidade = ?, Aluguel = ? WHERE id = ?");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getMarca());
            stmt.setDouble(3, f.getUnidade());
            stmt.setDouble(4, f.getAluguel());
            stmt.setInt(5, f.getId()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "atualizado com sucesso!"); //se der certo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex); //se der errado
        } finally {
            ConnectionFactory.closeConnection(con, stmt); //fecha a conexão
        }

    }
    public void delete(Ferramenta f) { //deleta

        Connection con = ConnectionFactory.getConnection(); //pegando o método da classe ConnectionFactory
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("DELETE FROM tb_ferramenta WHERE id = ?");
            stmt.setInt(1, f.getId()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "excluido com sucesso!"); //se der certo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao xcluir: " + ex); //se der errado
        } finally {
            ConnectionFactory.closeConnection(con, stmt); //fecha a conexão
        }

    }
    
    public List<Ferramenta> readForDesc(String desc) { //pesquisa

        //gerando conexão
        Connection con = ConnectionFactory.getConnection(); //pegando o método da classe ConnectionFactory
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Ferramenta> produtos = new ArrayList<>(); //cria uma lista pra adicionar os produtos

        try { //pesquisar se colocar palavra completa
            stmt = con.prepareStatement("SELECT * FROM tb_ferramenta WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Ferramenta ferramenta = new Ferramenta();

                ferramenta.setId(rs.getInt("id"));
                ferramenta.setNome(rs.getString("descricao"));
                ferramenta.setMarca(rs.getString("Marca"));
                ferramenta.setUnidade(rs.getDouble("Unidade"));
                ferramenta.setAluguel(rs.getDouble("Aluguel"));
                produtos.add(ferramenta);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs); //fecha conexão
        }

        return produtos;

    }

}

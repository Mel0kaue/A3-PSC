package dao;

import conexao.ConexaoBancoDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Emprestimos;
import modelo.Ferramenta;

/**
 *
 * @author kauem
 */
public class EmprestimosDAO implements DaoGenerico<Emprestimos>{

    public void create(Emprestimos e) throws ParseException {

        Connection con = ConexaoBancoDados.getConnection();
        PreparedStatement stmt = null;

        try {
   
            //colocando dentro da tabela
            stmt = con.prepareStatement("INSERT INTO tb_emprestimos(amigo,ferramenta,Status, data) VALUES (?,?,?, NOW())");
            stmt.setString(1, e.getAmigoEsc());
            stmt.setString(2, e.getFerramentaEsc());
            stmt.setString(3, e.getStatus());


            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "salvo com sucesso!"); //se der certo
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex); //se der errado
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt); //fecha a conexão
        }

    }

    public List<Emprestimos> read() { //lista

        //gerando conexão
        Connection con = ConexaoBancoDados.getConnection(); 
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Emprestimos> emprestimos = new ArrayList<>(); //cria uma lista pra adicionar os produtos

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_emprestimos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Emprestimos emprestimo = new Emprestimos();

                emprestimo.setID(rs.getInt("ID"));
                emprestimo.setAmigoEsc(rs.getString("amigo"));
                emprestimo.setFerramentaEsc(rs.getString("ferramenta"));
                emprestimo.setStatus(rs.getString("Status"));
                emprestimo.setData(rs.getDate("data"));
               
                emprestimos.add(emprestimo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt, rs); //fecha conexão
        }

        return emprestimos;

    }
    
    public void updateStatus(Emprestimos e) { //atualiza o status

        Connection con = ConexaoBancoDados.getConnection(); 
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("UPDATE tb_emprestimos SET Status = ? WHERE ID = ?");
            stmt.setString(1, e.getStatus());
            stmt.setInt(2, e.getID()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "atualizado com sucesso!"); //se der certo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex); //se der errado
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt); //fecha a conexão
        }

    }
    
    public void delete(Emprestimos e) { //deleta

        Connection con = ConexaoBancoDados.getConnection(); 
        PreparedStatement stmt = null;

        try {
            
            stmt = con.prepareStatement("DELETE FROM tb_emprestimos WHERE id = ?");
            stmt.setInt(1, e.getID()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "excluido com sucesso!"); //se der certo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao xcluir: " + ex); //se der errado
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt); //fecha a conexão
        }

    }
    
    @Override
    public void inserir(Emprestimos obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void alterar(Emprestimos obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Emprestimos> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
    
}

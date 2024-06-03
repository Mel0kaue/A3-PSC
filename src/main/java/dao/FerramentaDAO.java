package dao;

import conexao.ConexaoBancoDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Ferramenta;

/**
 *
 * @author josue
 */
public class FerramentaDAO {
    
    public static List<Ferramenta> MinhaLista = new ArrayList<>(); // Cria uma lista pra adicionar as ferramentas

    public boolean create(Ferramenta f) {
        boolean result = false;

        Connection con = ConexaoBancoDados.getConnection();
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("INSERT INTO tb_ferramentas (nome,marca,custo) VALUES (?,?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getMarca());
            stmt.setDouble(3, f.getCusto());
  
            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "salvo com sucesso!"); //se der certo
            
            return result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex); //se der errado
            return result;
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt); //fecha a conexão
        }
    }

    public List<Ferramenta> read() { //lista
    
        MinhaLista.clear(); // importante limpar a lista antes de retornar com os dados buscados.

        //gerando conexão
        Connection con = ConexaoBancoDados.getConnection(); 
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            if (con != null) {
                stmt = con.prepareStatement("SELECT * FROM tb_ferramentas");
                rs = stmt.executeQuery();

                while (rs.next()) {

                    Ferramenta ferramenta = new Ferramenta();

                    ferramenta.setId(rs.getInt("ID"));
                    ferramenta.setNome(rs.getString("nome"));
                    ferramenta.setMarca(rs.getString("marca"));
                    ferramenta.setCusto(rs.getDouble("custo"));
       
                    MinhaLista.add(ferramenta);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt, rs); //fecha conexão
        }

        return MinhaLista;
    }

    public boolean update(Ferramenta f) { //atualiza
        boolean result = false;


        Connection con = ConexaoBancoDados.getConnection(); 
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("UPDATE tb_ferramentas SET nome = ?, marca = ?, custo = ? WHERE ID = ?");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getMarca());
            stmt.setDouble(3, f.getCusto());
            stmt.setInt(4, f.getId()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "atualizado com sucesso!"); //se der certo
            return result = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex); //se der errado
            return result;
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt); //fecha a conexão
        }

    }
    public void delete(Ferramenta f) { //deleta

        Connection con = ConexaoBancoDados.getConnection(); 
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tb_ferramentas WHERE ID = ?");
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
        Connection con = ConexaoBancoDados.getConnection(); 
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
         
                produtos.add(ferramenta);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt, rs); //fecha conexão
        }

        return produtos;
    }
    
    // método que soma todos os valores das ferramentas
    public static double somarValores() {
        double soma = 0.0;
        String sql = "SELECT * FROM bd_a3.tb_ferramentas";
        
        Connection con = ConexaoBancoDados.getConnection(); 
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Itera pelos resultados e soma os valores
            while (rs.next()) {
                double valor = rs.getDouble("custo");
                soma += valor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return soma;
    }
}
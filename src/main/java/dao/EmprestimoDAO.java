package dao;

import conexao.ConexaoBD;
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
import modelo.Emprestimo;
import modelo.Ferramenta;

/**
 *
 * @author kauem
 */
public class EmprestimoDAO implements DAOGenerico<Emprestimo> {

    public void create(Emprestimo e) throws ParseException {

        Connection con = ConexaoBD.getConnection();
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
            ConexaoBD.closeConnection(con, stmt); //fecha a conexão
        }

    }

    public List<Emprestimo> read() { //lista

        //gerando conexão
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Emprestimo> emprestimos = new ArrayList<>(); //cria uma lista pra adicionar os produtos

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_emprestimos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Emprestimo emprestimo = new Emprestimo();

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
            ConexaoBD.closeConnection(con, stmt, rs); //fecha conexão
        }

        return emprestimos;

    }

    public void updateStatus(Emprestimo e) { //atualiza o status

        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("UPDATE tb_emprestimos SET Status = ? WHERE ID = ?");
            stmt.setString(1, e.getStatus());
            stmt.setInt(2, e.getID()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex); //se der errado
        } finally {
            ConexaoBD.closeConnection(con, stmt); //fecha a conexão
        }

    }

    public void delete(Emprestimo e) { //deleta

        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM tb_emprestimos WHERE id = ?");
            stmt.setInt(1, e.getID()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "excluido com sucesso!"); //se der certo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao xcluir: " + ex); //se der errado
        } finally {
            ConexaoBD.closeConnection(con, stmt); //fecha a conexão
        }

    }

    public boolean amigoPossuiFerramentasNaoDevolvidas(String nomeAmigo) {
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT COUNT(*) FROM tb_emprestimos WHERE amigo = ? AND Status = 'Ativo'");
            stmt.setString(1, nomeAmigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao verificar empréstimos não devolvidos: " + ex);
        } finally {
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        return false;
    }

    public List<String> listarFerramentasNaoDevolvidasPorAmigo(String nomeAmigo) {
        List<String> ferramentasNaoDevolvidas = new ArrayList<>();
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT ferramenta FROM tb_emprestimos WHERE amigo = ? AND Status = 'Emprestado'");
            stmt.setString(1, nomeAmigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String ferramenta = rs.getString("ferramenta");
                ferramentasNaoDevolvidas.add(ferramenta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar ferramentas não devolvidas: " + ex);
        } finally {
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        return ferramentasNaoDevolvidas;
    }

    @Override
    public void inserir(Emprestimo obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(Emprestimo obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Emprestimo> consultar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

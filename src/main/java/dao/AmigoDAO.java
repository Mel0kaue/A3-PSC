package dao;

import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Amigo;
import modelo.Ferramenta;

/**
 * Classe responsável pelo acesso e manipulação dos dados dos amigos no banco de
 * dados. Implementa a interface DAOGenerico para operações CRUD.
 *
 * @autor kauem
 */
public class AmigoDAO implements DAOGenerico<Amigo> {

    /**
     * Insere um novo amigo no banco de dados.
     *
     * @param amg O objeto Amigo a ser inserido.
     */
    public void create(Amigo amg) {

        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tb_amigos (nome,telefone) VALUES (?,?)");
            stmt.setString(1, amg.getNome());
            stmt.setString(2, amg.getTelefone());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "salvo com sucesso!"); //se der certo
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex); //se der errado
        } finally {
            ConexaoBD.closeConnection(con, stmt);
        }

    }

    /**
     * Retorna uma lista de todos os amigos no banco de dados.
     *
     * @return Lista de amigos.
     */
    public List<Amigo> read() { //lista

        //gerando conexão
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Amigo> amigos = new ArrayList<>(); //cria uma lista pra adicionar os produtos

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_amigos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Amigo amigo = new Amigo();

                amigo.setIdAmigo(rs.getInt("ID"));
                amigo.setNome(rs.getString("nome"));
                amigo.setTelefone(rs.getString("telefone"));

                amigos.add(amigo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBD.closeConnection(con, stmt, rs); //fecha conexão
        }

        return amigos;

    }

    /**
     * Atualiza os dados de um amigo no banco de dados.
     *
     * @param amg O objeto Amigo com os dados atualizados.
     */
    public void update(Amigo amg) { //atualiza

        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("UPDATE tb_amigos SET nome = ?, telefone = ? WHERE ID = ?");
            stmt.setString(1, amg.getNome());
            stmt.setString(2, amg.getTelefone());
            stmt.setInt(3, amg.getIdAmigo()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "atualizado com sucesso!"); //se der certo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex); //se der errado
        } finally {
            ConexaoBD.closeConnection(con, stmt); //fecha a conexão
        }

    }

    /**
     * Remove um amigo do banco de dados.
     *
     * @param amg O objeto Amigo a ser removido.
     */
    public void delete(Amigo amg) { //deleta

        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM tb_amigos WHERE ID = ?");
            stmt.setInt(1, amg.getIdAmigo()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "excluido com sucesso!"); //se der certo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao xcluir: " + ex); //se der errado
        } finally {
            ConexaoBD.closeConnection(con, stmt); //fecha a conexão
        }

    }

    /**
     * Pesquisa e retorna uma lista de amigos com base na descrição fornecida.
     *
     * @param desc A descrição a ser pesquisada.
     * @return Lista de amigos que correspondem à descrição.
     */
    public List<Amigo> readForDesc(String desc) { //pesquisa

        //gerando conexão
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Amigo> dadosAmigo = new ArrayList<>(); //cria uma lista pra adicionar os produtos

        try { //pesquisar sem colocar palavra completa
            stmt = con.prepareStatement("SELECT * FROM tb_amigos WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Amigo amigos = new Amigo();

                amigos.setIdAmigo(rs.getInt("ID"));
                amigos.setNome(rs.getString("nome"));
                amigos.setTelefone(rs.getString("telefone"));

                dadosAmigo.add(amigos);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBD.closeConnection(con, stmt, rs); //fecha conexão
        }

        return dadosAmigo;

    }

    @Override
    public void inserir(Amigo amg) {

        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("INSERT INTO tb_amigos (nome,telefone) VALUES (?,?)");
            stmt.setString(1, amg.getNome());
            stmt.setString(2, amg.getTelefone());

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "salvo com sucesso!"); //se der certo
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex); //se der errado
        } finally {
            ConexaoBD.closeConnection(con, stmt); //fecha a conexão
        }
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Amigo> consultar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(Amigo amg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

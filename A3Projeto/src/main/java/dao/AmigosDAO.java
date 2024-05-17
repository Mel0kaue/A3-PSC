package dao;

import conexaobd.ConexaoBancoDados;
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
import model.Amigo;
import model.Ferramenta;

/**
 *
 * @author kauem
 */
public class AmigosDAO implements DaoGenerico<Amigo> {

    public void create(Amigo amg) {

        Connection con = ConexaoBancoDados.getConnection();
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("INSERT INTO tb_amigos (Nome,Telefone) VALUES (?,?)");
            stmt.setString(1, amg.getNome());
            stmt.setInt(2, amg.getTelefone());

            

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "salvo com sucesso!"); //se der certo
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex); //se der errado
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt); //fecha a conexão
        }

    }

    public List<Amigo> read() { //lista

        //gerando conexão
        Connection con = ConexaoBancoDados.getConnection(); 
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Amigo> amigos = new ArrayList<>(); //cria uma lista pra adicionar os produtos

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_amigos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Amigo amigo = new Amigo();

                amigo.setIdAmigo(rs.getInt("id"));
                amigo.setNome(rs.getString("Nome"));
                amigo.setTelefone(rs.getInt("Telefone"));


                amigos.add(amigo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AmigosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt, rs); //fecha conexão
        }

        return amigos;

    }

    public void update(Amigo amg) { //atualiza

        Connection con = ConexaoBancoDados.getConnection(); 
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("UPDATE tb_amigos SET Nome = ?, Telefone = ? WHERE id = ?");
            stmt.setString(1, amg.getNome());
            stmt.setInt(2, amg.getTelefone());
            stmt.setInt(3, amg.getIdAmigo()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "atualizado com sucesso!"); //se der certo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex); //se der errado
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt); //fecha a conexão
        }

    }
    
    public Amigo carregaAmigo(int idAmigo) { //----------------arrumar-----------------------
        
        Amigo objeto = new Amigo();
        objeto.setIdAmigo(idAmigo);
        
        Connection con = ConexaoBancoDados.getConnection(); 
        PreparedStatement stmt = null;
        
        try {
            
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos WHERE id = " + idAmigo);
            res.next();

            objeto.setNome(res.getString("Nome"));
            objeto.setTelefone(res.getInt("Telefone"));


            stmt.close();            
            
        } catch (SQLException erro) {
        }
        return objeto;
    }

    public void delete(Amigo amg) { //deleta

        Connection con = ConexaoBancoDados.getConnection(); 
        PreparedStatement stmt = null;

        try {
            
            stmt = con.prepareStatement("DELETE FROM tb_amigos WHERE id = ?");
            stmt.setInt(1, amg.getIdAmigo()); //pra pegar o id

            stmt.executeUpdate(); //atualiza

            JOptionPane.showMessageDialog(null, "excluido com sucesso!"); //se der certo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao xcluir: " + ex); //se der errado
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt); //fecha a conexão
        }

    }
    
    public List<Amigo> readForDesc(String desc) { //pesquisa

        //gerando conexão
        Connection con = ConexaoBancoDados.getConnection(); 
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Amigo> dadosAmigo = new ArrayList<>(); //cria uma lista pra adicionar os produtos

        try { //pesquisar sem colocar palavra completa
            stmt = con.prepareStatement("SELECT * FROM tb_amigos WHERE Nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Amigo amigos = new Amigo();

                amigos.setIdAmigo(rs.getInt("id"));
                amigos.setNome(rs.getString("Nome"));
                amigos.setTelefone(rs.getInt("Telefone"));

                dadosAmigo.add(amigos);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBancoDados.closeConnection(con, stmt, rs); //fecha conexão
        }

        return dadosAmigo;

    }

    @Override
    public void inserir(Amigo amg) {

        Connection con = ConexaoBancoDados.getConnection();
        PreparedStatement stmt = null;

        try {
            //colocando dentro da tabela
            stmt = con.prepareStatement("INSERT INTO tb_amigos (Nome,Telefone) VALUES (?,?)");
            stmt.setString(1, amg.getNome());
            stmt.setInt(2, amg.getTelefone());


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
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Amigo> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void alterar(Amigo amg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

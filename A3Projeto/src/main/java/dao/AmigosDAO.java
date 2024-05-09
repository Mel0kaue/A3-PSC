package dao;

import conexaobd.ConexaoBancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Amigo;

/**
 *
 * @author kauem
 */
public class AmigosDAO implements DaoGenerico<Amigo> {

    private ConexaoBancoDados conexao;

    public AmigosDAO() {
        this.conexao = new ConexaoBancoDados();
    }

    @Override
    public void inserir(Amigo amigo) {
        String sql = "INSERT INTO AMIGO (NOME, TELEFONE) VALUES (?,?)";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setString(1, amigo.getNome());
                sentenca.setInt(2, amigo.getTelefone());

                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void alterar(Amigo amigo) {
        String sql = "UPDATE AMIGO SET NOME = ?, TELEFONE = ? WHERE IDAMIGO = ?";
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setString(1, amigo.getNome());
                sentenca.setInt(2, amigo.getTelefone());
                
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void excluir() {
        String sql = "DELETE FROM AMIGO"; //deleta a tabela inteira
        
        try {
            if (this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public void ecluirID(int id){ 
        String sql = "DELETE FROM AMIGO WHERE IDAMIGO = ?"; //deleta uma pessoa da tabela
        
        try {
            if (this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setInt(1, id);
                
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    } 

    @Override
    public ArrayList<Amigo> consultar() {
        
        ArrayList<Amigo> listaAmigos = new ArrayList<Amigo>();
        String sql = "SELECT * FROM AMIGO ORDER BY IDAMIGO";
        
        try{
            if (this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while(resultadoSentenca.next()){
                    
                    Amigo amigo = new Amigo();
                    amigo.setIdAmigo(resultadoSentenca.getInt("IDAMIGO"));
                    amigo.setNome(resultadoSentenca.getString("NOME"));
                    amigo.setTelefone(resultadoSentenca.getInt("NUMERO"));
                    
                    listaAmigos.add(amigo);
                    
                }
                sentenca.close();
                this.conexao.getConnection().close();
            }
            return listaAmigos;
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }

    }
    
    public static ArrayList<Amigo> minhaLista = new ArrayList<>();

    public static ArrayList<Amigo> getMinhaLista() {
        return minhaLista;
    }

    public static void setMinhaLista(ArrayList<Amigo> minhaLista) {
        AmigosDAO.minhaLista = minhaLista;
    }

}

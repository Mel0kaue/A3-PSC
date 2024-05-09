package conexaobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBancoDados {
    
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao;
    
    public ConexaoBancoDados(){
        this.servidor = "localhost";
        this.banco = "bd_a3";
        this.usuario = "root";
        this.senha = "Unisul@1520";
    }

//    public static void main(String[] args) throws SQLException {
//
//        Connection conexao = null;
    public boolean conectar(){
          try {
//            Class.forName("com.mysql.jdbc.Driver");
            this.conexao = DriverManager.getConnection("jdbc:mysql://"+this.servidor+"/"+this.banco, this.usuario, this.senha);
            return true;
            
          } catch (SQLException ex) {
              throw new RuntimeException(ex);
        }     
             
    }
    public Connection getConnection(){
        return conexao;
    }
}


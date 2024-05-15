package conexaobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBancoDados {
    
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/dbmercadinho";
    private static String USER = "root";
    private static String PASS = "Unisul@1520";

    public static Connection getConnection() { //criando conexão

        try {

            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("erro de conexão: ", ex);
        }
    }

    //aqui começa uma sobrecarga fechando as conexões
    public static void closeConnection(Connection con) {

        try { //se a conexão tiver aberta, feche

            if (con != null) {
                con.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);
        try { //se a conexão tiver aberta, feche

            if (stmt != null) {
                stmt.close();

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);
        try { //se a conexão tiver aberta, feche

            if (rs != null) {
                rs.close();

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


} 


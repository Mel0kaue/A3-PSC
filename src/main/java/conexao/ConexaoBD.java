package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados MySql.
 * @author kauem
 */
public class ConexaoBD {
    
    // Propriedades da conexão
    private static String DRIVER = "com.mysql.cj.jdbc.Driver"; 
    private static String URL = "jdbc:mysql://localhost:3306/bd_a3"; 
    private static String USER = "root"; 
    private static String PASS = "Unisul@1520"; 
    
    /**
     * Cria e retorna uma conexão com o banco de dados.
     *
     * @return Conexão com o banco de dados.
     */
    public static Connection getConnection() { 
        Connection conn = null;
        try {

            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            
            if (conn != null) {
                System.out.println("Banco conectado!");
                return conn;
            } 
            else {
                System.out.println("-> -> -> Banco NÂO conectado!");
            }
        } 
        catch (ClassNotFoundException e) {
            System.out.println("O Driver JDBC nao foi encontrado!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            if (e.getMessage().contains("Unknown database")) {
                System.out.println("O DataBase não existe!");
                e.printStackTrace();
            } 
            else if (e.getMessage().contains("Access denied")) {
                System.out.println("Os dados do usuário login e senha estao incorretos!");
                e.printStackTrace();
            } 
            else { 
                System.out.println("Erro na conexao!" + e.getMessage());
                e.printStackTrace();
            }       
        }
        return conn;
    }

    /**
     * Fecha a conexão com o banco de dados.
     *
     * @param con A conexão a ser fechada.
     */
    public static void closeConnection(Connection con) {

        try { //se a conexão tiver aberta, feche

            if (con != null) {
                con.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Fecha a conexão e o PreparedStatement.
     *
     * @param con A conexão a ser fechada.
     * @param stmt O PreparedStatement a ser fechado.
     */
    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);
        try { //se a conexão tiver aberta, feche

            if (stmt != null) {
                stmt.close();

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fecha a conexão, o PreparedStatement e o ResultSet.
     *
     * @param con A conexão a ser fechada.
     * @param stmt O PreparedStatement a ser fechado.
     * @param rs O ResultSet a ser fechado.
     */
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);
        try { //se a conexão tiver aberta, feche

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
} 


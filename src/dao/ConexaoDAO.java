package dao;

/**
 *
 * @author Tércio Ribeiro
 */
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO implements Serializable  {
    
    private static Connection connection;
    private String usuario;
    private String senha;
    private String url;

    private ConexaoDAO() {
        // Altere o usuário e senha de acordo com o banco de dados instalado
        usuario = "root";
        senha = "tercio1996";
        
        // Defina aqui o nome do seu banco de dados
        url = "jdbc:mysql://localhost:3306/sistema_pecas";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
    }

    public static Connection getInstance() {
        Object conexao = null;
        if (conexao == null) {
            synchronized (ConexaoDAO.class) {
                conexao = new ConexaoDAO();
            }
        }
        return connection;
    }

    public static void closeInstance() throws SQLException {
        Object conexao = null;
        if (conexao != null) {
            connection.close();
        }
    }

    public static void setAutoCommit(boolean vlr) throws SQLException {
        connection.setAutoCommit(vlr);
    }

    public static void commit() throws SQLException {
        connection.commit();
    }

    public static void rollback() throws SQLException {
        connection.rollback();
    }
    
}
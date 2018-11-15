package dao;

/**
 *
 * @author Tércio Ribeiro
 */
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO implements Serializable  {
    
    private static Connection connection;
    private String usuario;
    private String senha;
    private String url;

    private ConexaoDAO() {
        // Altere o usuário e senha de acordo com o banco de dados instalado
        usuario = "root";
        senha = "";
        
        // Defina aqui o nome do seu banco de dados
        url = "jdbc:mysql://localhost:3306/sistema_pecas";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar com o banco de dados\n"
                    + "Entre em contato com o desenvolvedor!", "Sistema - Erro de conexão com banco de dados",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            System.exit(1);
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
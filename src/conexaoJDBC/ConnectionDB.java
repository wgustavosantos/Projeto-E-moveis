package conexaoJDBC;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author WendersoN
 */
public class ConnectionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/emoveisdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null; 
    private static void toConnect() {
        try {
            if (connection == null || connection.isClosed()) {//se tiver vazio ou se a conexão estiver fechada
                try {
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    connection.setAutoCommit(false);
                    System.out.println("Conectado ao banco de dados!");
                } catch (SQLException e) {
                    System.out.println("Erro ao conectar o banco de dados: " + e);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao restabelecer conexão ");
        }
    }
    public static Connection getConnection() {
        toConnect();
        return connection;
    }
}

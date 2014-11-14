package BancodeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 631220116
 */


public class ConnectionFactory {

    public final static String host = "localhost";
    public final static String banco = "TrabalhoCantina";
    public final static String user = "postgres";
    public final static String senha = "senacrs";

    public static Connection getConnectionPostgre() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgressql.Driver");
        String url = "jdbc:postgresql://" + host + ":5432/" + banco + "";
        Connection conexao = DriverManager.getConnection(url, user, senha);
        return conexao;

    }

}

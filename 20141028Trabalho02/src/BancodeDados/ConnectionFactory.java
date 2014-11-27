package BancodeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 631220116
 */


public class ConnectionFactory {

    public final static String HOST = "localhost";
    
    public final static String BANCOPOST = "TrabalhoCantina";
    public final static String USERPOST = "postgres";
    public final static String SENHAPOST = "senacrs";
    
    public final static String BANCOMYSQL = "cantina";
    public final static String USERMYSQL = "root";
    public final static String SENHAMYSQL = "";
    
    //Configuração para BANCO de dados Postgres
    public static Connection getConexaoPostgres() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://" + HOST + ":5432/" + BANCOPOST + "";
        Connection conexao = DriverManager.getConnection(url, USERPOST, SENHAPOST);
        return conexao;
    }

    //Configuração para BANCO de dados MYSQL
    public static Connection getConexaoMySQL() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + HOST + ":3306/" + BANCOMYSQL;
        Connection conexao = DriverManager.getConnection(url, USERMYSQL, SENHAMYSQL);
        return conexao;
    }
        
}

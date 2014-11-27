package BancodeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 631220116
 */
public class Conexao {

    Connection conexao = null;
    PreparedStatement comando = null;

    //Configuração para banco de dados Postgres
    public void iniciarConexaoPostgres() throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConexaoPostgres();
    }

    //Configuração para banco de dados MYSQL
    public void iniciarConexaoMySQL() throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConexaoMySQL();
    }
    
    public void fecharConexao() throws ClassNotFoundException, SQLException {
        comando.close();
        conexao.close();
    }

}

package DAO;

import BancodeDados.ConnectionFactory;
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

    public void iniciarConexao() throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnectionPostgre();
    }

    public void fecharConexao() throws ClassNotFoundException, SQLException {
        comando.close();
        conexao.close();
    }

}

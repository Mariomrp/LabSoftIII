package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {

    Connection conexao = null;
    PreparedStatement comando = null;

    public void iniciarConexao() throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnectionPostgre();
    }

    public void fecharConexao() throws SQLException {
        comando.close();
        conexao.close();
    }

}

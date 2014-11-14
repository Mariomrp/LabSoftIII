package DAO;

import BancodeDados.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Produto;

/**
 *
 * @author 631220116
 */
public class ProdutoDAO_JDBC implements ProdutoDAO {

    private Connection conexao;
    private PreparedStatement comando;

    public void iniciarConexao(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnectionPostgre();
        comando = conexao.prepareStatement(sql);
    }

    public void fecharConexao() throws SQLException {
        comando.close();
        conexao.close();
    }

    @Override
    public void inserir(Produto produto) {
        String sql = "INSERT INTO pessoa(nome,email) "
                + "VALUES (?,?)";
        try {
            iniciarConexao(sql);
            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getTipo());
            comando.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO_JDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void deletar(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

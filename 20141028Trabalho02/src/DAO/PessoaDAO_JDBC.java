package DAO;

import BancodeDados.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pessoa;

/**
 *
 * @author 631220116
 */
public class PessoaDAO_JDBC implements PessoaDAO {

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
    public void inserir(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa(nome,email) "
                + "VALUES (?,?)";
        try {
            iniciarConexao(sql);
            comando.setString(1, pessoa.getNome());
            comando.setString(2, pessoa.getEmail());
            comando.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PessoaDAO_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(PessoaDAO_JDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void deletar(Pessoa pessoa) {
        String sql = "DELETE FROM pessoa WHERE id=?";
        try {
            iniciarConexao(sql);
            comando.setInt(1, pessoa.getId());
            comando.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PessoaDAO_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(PessoaDAO_JDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Pessoa> listarPessoa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package DAO;

import BancodeDados.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

/**
 *
 * @author 631220116
 */
public class ClienteDAO_JDBC implements ClienteDAO {

    private Connection conexao;
    private PreparedStatement comando;

    public void iniciarConexao(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConexaoMySQL();
   //     conexao = ConnectionFactory.getConexaoPostgres();
        comando = conexao.prepareStatement(sql);
    }

    public void fecharConexao() throws SQLException {
        comando.close();
        conexao.close();
    }

    @Override
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente(nome, email, telefone, cidade, endereco, cpf, rg, senha) VALUES (?,?,?,?,?,?,?,?)";
        try {
            iniciarConexao(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getTelefone());
            comando.setString(4, cliente.getCidade());
            comando.setString(5, cliente.getEndereco());
            comando.setString(6, cliente.getCpf());
            comando.setString(7, cliente.getRg());
            comando.setInt(8, cliente.getSenha());
            comando.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO_JDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void deletar(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE id=?";
        try {
            iniciarConexao(sql);
            comando.setInt(1, cliente.getId());
            comando.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO_JDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Cliente> listarCliente() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            iniciarConexao(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("email"),
                        resultado.getString("telefone"),
                        resultado.getString("cidade"),
                        resultado.getString("endereço"),
                        resultado.getString("cpf"),
                        resultado.getString("rg"));
                listaClientes.add(cliente);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO_JDBC.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listaClientes;
    }

    @Override
    public void atualizar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

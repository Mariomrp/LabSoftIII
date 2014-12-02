package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import conexao.ConnectionFactory;
import java.sql.Statement;

public class ClienteDAOJDBC implements ClienteDAO {

    private Connection conexao;
    private PreparedStatement comando;

    public void iniciarConexao(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnectionPostgre();
        comando = conexao.prepareStatement(sql);
    }
    
    private void iniciarConexaoGeraId(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnectionPostgre();
        comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }

    public void fecharConexao() throws SQLException {
        comando.close();
        conexao.close();
    }

    //M�TODO INSERIR NO BANCO
    @Override
    public Cliente inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente(nome, email, saldo) VALUES (?, ?, ?) ";
        
        try {
            iniciarConexaoGeraId(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setDouble(3, cliente.getSaldo());
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            resultado.next();
            cliente.setMatriculaCliente(resultado.getInt(1));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (Exception ex) {
                Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }

    //M�TODO PARA ATUALIZAR DADOS DO CLIENTE
    @Override
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome=?, email=?, saldo=? WHERE matricula = ?";
        try {
            iniciarConexao(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setDouble(3, cliente.getSaldo());
            comando.setInt(4, cliente.getMatriculaCliente());
            comando.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //M�TODO PARA REMOVER O CLIENTE
    @Override
    public void remover(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE matricula = ?";
        try {
            iniciarConexao(sql);
            comando.setInt(1, cliente.getMatriculaCliente());
            comando.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //M�TODO PRA LISTAR OS CLIENTES CADASTRADOS
    @Override
    public List<Cliente> listarClientes() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> listaclientes = new ArrayList<>();
        try {
            iniciarConexao(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente(
                        resultado.getInt("matricula"),
                        resultado.getString("nome"),
                        resultado.getString("email"),
                        resultado.getDouble("saldo")
                );
                listaclientes.add(cliente);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaclientes;
    }

    @Override
    public Cliente buscarPorNome(String nomeCliente) {
        String sql = "SELECT nome FROM cliente where matricula = ?";
        Cliente cliente = null;
        try {
            iniciarConexao(sql);
            comando.setString(1, cliente.getNome());
            ResultSet resultado = comando.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }

}//fim da classe

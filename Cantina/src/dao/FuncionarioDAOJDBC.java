package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Funcionario;
import conexao.ConnectionFactory;
import java.sql.Statement;

public class FuncionarioDAOJDBC implements FuncionarioDAO {

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

    //M�TODO PARA INSERIR O FUNCIONARIO
    @Override
    public Funcionario inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario(nome, email) " + "VALUES (?, ?) ";
        try {
            iniciarConexaoGeraId(sql);
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getEmail());
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            resultado.next();
            funcionario.setMatriculaFuncionario(resultado.getInt(1));            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (Exception ex) {
                Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return funcionario;
    }

    //M�TODO PARA ATUALIZAR FUNCIONARIO DA BASE DE DADOS
    @Override
    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome=?, email=? "
                + "WHERE matricula=?";
        try {
            iniciarConexao(sql);
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getEmail());
            comando.setInt(3, funcionario.getMatriculaFuncionario());
            comando.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //M�TODO PARA REMOVER UM FUNCIONARIO DA BASE 
    @Override
    public void remover(Funcionario funcionario) {
        String sql = "DELETE FROM funcionario WHERE matricula=?";
        try {
            iniciarConexao(sql);
            comando.setInt(1, funcionario.getMatriculaFuncionario());
            comando.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //M�TODO PARA LISTAR OS FUNCIONARIOS CADASTRADOS
    @Override
    public List<Funcionario> listarFuncionario() {
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> listafuncionario = new ArrayList<>();
        try {
            iniciarConexao(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Funcionario funcionario = new Funcionario(
                        resultado.getInt("matriculaFuncionario"),
                        resultado.getString("nome"),
                        resultado.getString("email")
                );
                listafuncionario.add(funcionario);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listafuncionario;
    }

    @Override
    public Funcionario buscarPorNome(String nomeFuncionario) {
        String sql = "SELECT nome FROM funcionario where matricula = ?";
        Funcionario funcionario = null;
        try {
            iniciarConexao(sql);
            comando.setString(1, funcionario.getNome());
            ResultSet resultado = comando.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return funcionario;
    }



}//fim da classe

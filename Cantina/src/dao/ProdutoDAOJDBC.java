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
import model.Produto;
import conexao.ConnectionFactory;
import java.sql.Statement;

public class ProdutoDAOJDBC implements ProdutoDAO {

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

    //M�TODO PARA INSERIR PRODUTOS NA BASE
    @Override
    public Produto inserir(Produto produto) {
        String sql = "INSERT INTO produto(nome, tipo, preco) " + "VALUES (?, ?, ?) ";
        try {
            iniciarConexaoGeraId(sql);
            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getTipo());
            comando.setDouble(3, produto.getPreco());
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            resultado.next();
            produto.setCodigo(resultado.getInt(1));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (Exception ex) {
                Logger.getLogger(ProdutoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return produto;

    }

    //M�TODO PARA ATUALIZAR UM PRODUTO
    @Override
    public void autalizar(Produto produto) {
        String sql = "UPDATE produto SET nome=?, tipo=?, preco=? "
                + "WHERE codigo=?";
        try {
            iniciarConexao(sql);
            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getTipo());
            comando.setDouble(3, produto.getPreco());
            comando.setInt(4, produto.getCodigo());
            comando.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //M�TODO PARA REMOVER PRODUTO DA BASE
    @Override
    public void remover(Produto produto) {
        String sql = "DELETE FROM produto WHERE codigo=?";
        try {
            iniciarConexao(sql);
            comando.setInt(1, produto.getCodigo());
            comando.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //M�TODO PARA LISTAR PRODUTOS CADASTRADOS NA BASE
    @Override
    public List<Produto> listarProduto() {
        String sql = "SELECT * FROM produto";
        List<Produto> listaproduto = new ArrayList<>();
        try {
            iniciarConexao(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Produto produto = new Produto(
                        resultado.getInt("codigo"),
                        resultado.getString("nome"),
                        resultado.getString("tipo"),
                        resultado.getDouble("preco")
                );
                listaproduto.add(produto);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaproduto;
    }

}//fim da classe

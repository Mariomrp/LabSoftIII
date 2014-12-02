package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import conexao.ConnectionFactory;
import model.Venda;

public class VendaDAOJDBC implements VendaDAO {

    private Connection conexao;
    private PreparedStatement comando;

    public void iniciarConexao(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnectionPostgre();
        comando = conexao.prepareStatement(sql);
    }

    private void iniciaConexaoGeraId(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnectionPostgre();
        comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }

    public void fecharConexao() throws SQLException {
        comando.close();
        conexao.close();
    }

    //venda.setData(new java.util.java.sql.Date(resultado.getData().getTime()))
    //M�TODO PARA INSERIR VENDA NO BANCO
    @Override
    public Venda inserir(Venda venda) {
        String sql = "INSERT INTO venda(matriculaFuncionario, matriculaCliente, preco, data) " + "VALUES (?, ?, ?, ?) ";
        try {
            iniciaConexaoGeraId(sql);
            comando.setInt(1, venda.getFuncionario().getMatriculaFuncionario());
            comando.setInt(2, venda.getCliente().getMatriculaCliente());
            comando.setDouble(3, venda.getValor());
            comando.setDate(4, new java.sql.Date(venda.getData().getTime()));
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            resultado.next();
            venda.setCodigoVenda(resultado.getInt(1));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (Exception ex) {
                Logger.getLogger(VendaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return venda;
    }

    @Override
    public List<Venda> listarVendas() {
        String sql = "SELECT * FROM venda";
        List<Venda> listavendas = new ArrayList<>();
        try {
            iniciarConexao(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Cliente cli = new ClienteDAOJDBC().buscarPorId(resultado.getInt("matriculaCliente"));
                
                Venda venda = new Venda(
                        resultado.getInt("codigo"),
                        resultado.getInt(venda.getFuncionario().getMatriculaFuncionario("matricula")),
                        resultado.getInt(venda.getCliente().getMatriculaCliente("matricula")),
                        resultado.getDouble("preco"),
                        resultado.getDate("data")
                );
                listavendas.add(venda);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(VendaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listavendas;
    }

    @Override
    public List<Venda> vendasPorCliente(int matriculaCliente) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Venda> vendasPorFuncionario(int matriculaFuncionario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Venda> vendasPorMes(Date data) {
        // TODO Auto-generated method stub
        return null;
    }

    //M�TODO PARA ATUALIZAR A TABELA DE VENDA
    @Override
    public void atualizar(Venda venda) {
        String sql = "UPDATE venda SET valor=?, data=? "
                + "WHERE codigo=?";
        try {
            iniciarConexao(sql);
            comando.setDouble(1, venda.getValor());
            comando.setDate(2, new java.sql.Date(venda.getData().getTime()));
            comando.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(VendaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //M�TODO PARA REMOVER UMA VENDA DO BANCO
    @Override
    public void remover(Venda venda) {
        String sql = "DELETE FROM venda WHERE codigo=?";
        try {
            iniciarConexao(sql);
            comando.setInt(1, venda.getCodigoVenda());
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

}//fim da classe

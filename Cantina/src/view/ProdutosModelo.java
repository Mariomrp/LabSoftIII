package view;

import dao.ProdutoDAO;
import dao.ProdutoDAOJDBC;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produto;

/**
 *
 * @author 631220116
 */
class ProdutosModelo extends AbstractTableModel {
String header[];
    List<Produto> produtos;

    public ProdutosModelo() {
        produtos = new ArrayList<Produto>();
    }

    public ProdutosModelo(String[] header) {
        this.header = header;
        ProdutoDAO dao = new ProdutoDAOJDBC();
        this.produtos = dao.listarProduto();

    }

    public ProdutosModelo(String[] header, List<Produto> produtos) {
        this.header = header;
        this.produtos = produtos;

    }

    @Override
    public int getRowCount() {
        return (produtos.size());
    }

    @Override
    public int getColumnCount() {
        return (4);
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return (produtos.get(rowIndex).getCodigo());
        } if (columnIndex == 1) {
            return (produtos.get(rowIndex).getNome());
        } if (columnIndex == 2) {
            return (produtos.get(rowIndex).getTipo());
        } else {
            return (produtos.get(rowIndex).getPreco());
        }
    }

    public void adicionaProduto(Produto produto) {
        ProdutoDAO dao = new ProdutoDAOJDBC();
        produtos.add(dao.inserir(produto));
    }

    public void removeProduto(int linha) {
        ProdutoDAO dao = new ProdutoDAOJDBC();
        dao.remover(produtos.get(linha));
        produtos.remove(linha);
    }

    public Produto getProduto(int linha) {
        return (produtos.get(linha));
    }
}

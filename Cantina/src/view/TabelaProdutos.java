package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Produto;

/**
 *
 * @author 631220116
 */
public class TabelaProdutos extends JPanel {

    JTable tabelaProdutos;
    
    public TabelaProdutos() {
            String[] colunas = {"Matricula", "nome", "tipo", "preço"};

        ProdutosModelo modeloProdutos = new ProdutosModelo(colunas);
        tabelaProdutos = new JTable(modeloProdutos);
        tabelaProdutos.setPreferredScrollableViewportSize(new Dimension(500, 100));
        tabelaProdutos.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        
        add(scrollPane);
    }
    public JTable getTabela() {
        return tabelaProdutos;
    }

    public void adicionaProduto(Produto produto) {
        ProdutosModelo modeloProdutos = (ProdutosModelo) getTabela().getModel();
        modeloProdutos.adicionaProduto(produto);
        getTabela().updateUI();

    }

    public void removeProduto(int linha) {
        ProdutosModelo modeloProdutos = (ProdutosModelo) getTabela().getModel();
        System.out.println("Nome:" + modeloProdutos.getProduto(linha).getNome());
        modeloProdutos.removeProduto(linha);
        getTabela().updateUI();
    }

    public void removeProdutoSelecionado() {
        int linha = getTabela().getSelectedRow();
        if (linha >= 0) {
            removeProduto(linha);
        }
    }
}

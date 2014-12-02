package dao;

import java.util.List;

import model.Produto;

public interface ProdutoDAO {

    public Produto inserir(Produto produto);

    public void autalizar(Produto produto);

    public void remover(Produto produto);

    public List<Produto> listarProduto();

}//fim da classe

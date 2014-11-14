
package DAO;

import modelo.Produto;

/**
 *
 * @author 631220116
 */
public interface ProdutoDAO {
    
    public void inserir(Produto produto);

    public void deletar(Produto produto);

    public void atualizar(Produto produto);
    
}

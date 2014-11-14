package DAO;

import java.util.List;
import modelo.Pessoa;

/**
 *
 * @author 631220116
 */
public interface PessoaDAO {

    public void inserir(Pessoa pessoa);

    public void deletar(Pessoa pessoa);

    public void atualizar(Pessoa pessoa);
    
    public List<Pessoa> listarPessoa();
}

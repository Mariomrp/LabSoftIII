package DAO;

import java.util.List;
import modelo.Cliente;

/**
 *
 * @author 631220116
 */
public interface ClienteDAO {

    public void inserir(Cliente cliente);

    public void deletar(Cliente cliente);

    public void atualizar(Cliente cliente);
    
    public List<Cliente> listarCliente();
}

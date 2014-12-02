package dao;

import java.util.*;

import model.Cliente;

public interface ClienteDAO {

    public Cliente inserir(Cliente cliente);

    public void atualizar(Cliente cliente);

    public void remover(Cliente cliente);

    public List<Cliente> listarClientes();

    public Cliente buscarPorNome(String nomeCliente);

}

package dao;

import java.util.List;

import model.Funcionario;

public interface FuncionarioDAO {

    public Funcionario inserir(Funcionario funcionario);

    public void atualizar(Funcionario funcionario);

    public void remover(Funcionario funcionario);
    
    public List<Funcionario> listarFuncionario();

    public Funcionario buscarPorNome(String nomeFuncionario);

}//fim da classe

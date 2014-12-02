package dao;

import java.util.Date;
import java.util.List;

import model.Venda;

public interface VendaDAO {

    public Venda inserir(Venda venda);

    public void atualizar(Venda venda);

    public void remover(Venda venda);

    public List<Venda> listarVendas();

    public List<Venda> vendasPorCliente(int matriculaCliente);

    public List<Venda> vendasPorFuncionario(int matriculaFuncionario);

    public List<Venda> vendasPorMes(Date data);

}//fim da classe

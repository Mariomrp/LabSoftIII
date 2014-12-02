package model;

import java.io.Serializable;
import java.util.Date;

public class Venda implements Serializable {

    private int codigoVenda;
    Funcionario funcionario;
    Cliente cliente;
    private double valor;
    private Date data;

    public Venda(int codigoVenda, Funcionario funcionario, Cliente cliente, double valor, Date data) {
        this.codigoVenda = codigoVenda;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.valor = valor;
        this.data = data;
    }

    public Venda(Funcionario funcionario, Cliente cliente, double valor, Date data) {
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.valor = valor;
        this.data = data;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Venda [codigoVenda=" + codigoVenda + ", funcionario="
                + funcionario + ", cliente=" + cliente + ", valor=" + valor
                + ", data=" + data + "]";
    }

    public void add(Venda inserir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//fim da classe

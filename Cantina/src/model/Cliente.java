package model;

import java.io.Serializable;

public class Cliente implements Serializable {

    private int matriculaCliente;
    private String nome;
    private String email;
    private double saldo;

    public Cliente(int matriculaCliente, String nome, String email, double saldo) {
        this.matriculaCliente = matriculaCliente;
        this.nome = nome;
        this.email = email;
        this.saldo = saldo;
    }

    public Cliente(String nome, String email, double saldo) {
        this.nome = nome;
        this.email = email;
        this.saldo = saldo;
    }

    public int getMatriculaCliente() {
        return matriculaCliente;
    }

    public void setMatriculaCliente(int matriculaCliente) {
        this.matriculaCliente = matriculaCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente [matriculaCliente=" + matriculaCliente + ", nome="
                + nome + ", email=" + email + ", saldo=" + saldo + "]";
    }

}//fim da classe

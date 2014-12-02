package model;

import java.io.Serializable;

public class Funcionario implements Serializable {

    private int matriculaFuncionario;
    private String nome;
    private String email;

    public Funcionario(int matriculaFuncionario, String nome, String email) {
        this.matriculaFuncionario = matriculaFuncionario;
        this.nome = nome;
        this.email = email;
    }

    public Funcionario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public int getMatriculaFuncionario() {
        return matriculaFuncionario;
    }

    public void setMatriculaFuncionario(int matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
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

    @Override
    public String toString() {
        return "Funcionario [matriculaFuncionario=" + matriculaFuncionario
                + ", nome=" + nome + ", email=" + email + "]";
    }

}//fim da classe

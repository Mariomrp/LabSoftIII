package modelo;

/**
 *
 * @author 631220116
 */
public class Pessoa {

    private String nome, email;
    private int id, matricula, fone, senha;
    private boolean funcionario;

    public Pessoa(int id, String nome, int matricula, String email, int fone, int senha) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.fone = fone;
        this.senha = senha;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getFone() {
        return fone;
    }

    public void setFone(int fone) {
        this.fone = fone;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public boolean isFuncionario() {
        return funcionario;
    }

    public void setFuncionario(boolean funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", email=" + email + ", id=" + id + ", matricula=" + matricula + ", fone=" + fone + ", senha=" + senha + ", funcionario=" + funcionario + '}';
    }
}

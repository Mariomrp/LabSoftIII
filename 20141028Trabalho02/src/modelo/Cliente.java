package modelo;

/**
 *
 * @author 631220116
 */
public class Cliente {

    private String nome, email, telefone, cidade, endereco, cpf, rg;
    private int id, senha;
    private boolean funcionario;

    public Cliente(String nome, String email, String telefone, String cidade, String endereco, String cpf, String rg, int senha) {
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
    }
    
      public Cliente(int id, String nome, String email, String telefone, String cidade, String endereco, String cpf, String rg) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cidade=" + cidade + ", endereco=" + endereco + ", cpf=" + cpf + ", rg=" + rg + ", id=" + id + ", senha=" + senha + ", funcionario=" + funcionario + '}';
    }
    
}

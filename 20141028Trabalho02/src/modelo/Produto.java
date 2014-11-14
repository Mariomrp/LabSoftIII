
package modelo;

/**
 *
 * @author 631220116
 */
public class Produto {
    private String nome, tipo;
    private double preco;
    private int id, quantidade;
    
    public Produto (int id, String nome, String tipo, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", tipo=" + tipo + ", preco=" + preco + ", id=" + id + ", quantidade=" + quantidade + '}';
    }
    
}

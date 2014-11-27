
package modelo;

/**
 *
 * @author 631220116
 */
public class Produto {
    private String nome, categoria;
    private double valor;
    private int id, quantidade;
    
    public Produto (int id, String nome, String categoria, double valor, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", categoria=" + categoria + ", valor=" + valor + ", id=" + id + ", quantidade=" + quantidade + '}';
    }

}

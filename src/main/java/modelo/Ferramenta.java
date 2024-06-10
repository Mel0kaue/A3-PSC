package modelo;

/**
 *
 * @author kauem
 */
public class Ferramenta {

    private int id;
    private String Nome;
    private String Marca;
    private Double Custo;
    private int quantidade;

    public Ferramenta() {
        this.Nome = Nome;
        this.Marca = Marca;
        this.Custo = Custo;
        this.quantidade++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public Double getCusto() {
        return Custo;
    }

    public void setCusto(Double Custo) {
        this.Custo = Custo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int emprestar() {
        if (quantidade > 0) {
            quantidade--;
            System.out.println("emprestimo feito. Quantidade restant: " + quantidade);
            return quantidade;
        } else {
            System.out.println("esta ferramenta não consta mais no estoque. Já foi emprestada à alguém.");
            return 0;
        }
    }
}

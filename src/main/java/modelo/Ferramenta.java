package modelo;

/**
 * Classe que representa uma ferramenta.
 *
 */
public class Ferramenta {

    private int id;
    private String Nome;
    private String Marca;
    private Double Custo;
    private int quantidade;

    /**
     * Construtor padrão da classe Ferramenta.
     */
    public Ferramenta() {
        this.Nome = Nome;
        this.Marca = Marca;
        this.Custo = Custo;
        this.quantidade++;
    }

    /**
     * Obtém o ID da ferramenta.
     *
     * @return O ID da ferramenta.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID da ferramenta.
     *
     * @param id O ID da ferramenta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome da ferramenta.
     *
     * @return O nome da ferramenta.
     */
    public String getNome() {
        return Nome;
    }

    /**
     * Define o nome da ferramenta.
     *
     * @param Nome O nome da ferramenta.
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * Obtém a marca da ferramenta.
     *
     * @return A marca da ferramenta.
     */
    public String getMarca() {
        return Marca;
    }

    /**
     * Define a marca da ferramenta.
     *
     * @param Marca A marca da ferramenta.
     */
    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    /**
     * Obtém o custo da ferramenta.
     *
     * @return O custo da ferramenta.
     */
    public Double getCusto() {
        return Custo;
    }

    /**
     * Define o custo da ferramenta.
     *
     * @param Custo O custo da ferramenta.
     */
    public void setCusto(Double Custo) {
        this.Custo = Custo;
    }

    /**
     * Obtém a quantidade disponível da ferramenta.
     *
     * @return A quantidade disponível da ferramenta.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade disponível da ferramenta.
     *
     * @param quantidade A quantidade disponível da ferramenta.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Realiza o empréstimo da ferramenta.
     *
     * @return A quantidade restante após o empréstimo.
     */
    public int emprestar() {
        if (quantidade > 0) {
            quantidade--;
            System.out.println("Empréstimo feito. Quantidade restante: " + quantidade);
            return quantidade;
        } else {
            System.out.println("Esta ferramenta não consta mais no estoque. Já foi emprestada a alguém.");
            return 0;
        }
    }
}

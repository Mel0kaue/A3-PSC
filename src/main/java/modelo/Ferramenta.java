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
}

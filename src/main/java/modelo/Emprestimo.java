package modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Classe que representa um empréstimo.
 *
 */
public class Emprestimo {

    public int ID;
    public String amigoEsc;
    public String ferramentaEsc;
    public String status;
    public Date data;
    public int quantidade;

    /**
     * Construtor padrão da classe Emprestimo.
     */
    public Emprestimo() {
        this.amigoEsc = amigoEsc;
        this.ferramentaEsc = ferramentaEsc;
        this.status = "Ativo";
        this.quantidade = 1;
    }

    /**
     * Obtém o ID do empréstimo.
     *
     * @return O ID do empréstimo.
     */
    public int getID() {
        return ID;
    }

    /**
     * Define o ID do empréstimo.
     *
     * @param ID O ID do empréstimo.
     */
    public void setID(int ID) {
        this.ID = ID;
    }

     /**
     * Obtém o amigo envolvido no empréstimo. Esc(Escolhido)
     *
     * @return O nome do amigo envolvido no empréstimo.
     */
    public String getAmigoEsc() {
        return amigoEsc;
    }

     /**
     * Define o amigo envolvido no empréstimo.
     *
     * @param amigoEsc O nome do amigo envolvido no empréstimo.
     */
    public void setAmigoEsc(String amigoEsc) {
        this.amigoEsc = amigoEsc;
    }

    /**
     * Obtém a ferramenta envolvida no empréstimo.
     *
     * @return O nome da ferramenta envolvida no empréstimo.
     */
    public String getFerramentaEsc() {
        return ferramentaEsc;
    }

    /**
     * Define a ferramenta envolvida no empréstimo.
     *
     * @param ferramentaEsc O nome da ferramenta envolvida no empréstimo.
     */
    public void setFerramentaEsc(String ferramentaEsc) {
        this.ferramentaEsc = ferramentaEsc;
    }

     /**
     * Obtém o status do empréstimo.
     *
     * @return O status do empréstimo.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status do empréstimo.
     *
     * @param status O status do empréstimo.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Obtém a data do empréstimo.
     *
     * @return A data do empréstimo.
     */
    public Date getData() {
        return data;
    }

    /**
     * Define a data do empréstimo.
     *
     * @param data A data do empréstimo.
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Obtém a quantidade envolvida no empréstimo.
     *
     * @return A quantidade envolvida no empréstimo.
     */
    public int getQuantidade() {
        return quantidade;
    }

     /**
     * Define a quantidade envolvida no empréstimo.
     *
     * @param quantidade A quantidade envolvida no empréstimo.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}

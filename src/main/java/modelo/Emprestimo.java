package modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author kauem
 */
public class Emprestimo {
    
    public int ID;
    public String amigoEsc;
    public String ferramentaEsc;
    public String status;
    public Date data;
    public int quantidade;

    public Emprestimo() {
        this.amigoEsc = amigoEsc;
        this.ferramentaEsc = ferramentaEsc;
        this.status = "Ativo";
        this.quantidade = 1;
    }
    
    
    
    // Getters e setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAmigoEsc() {
        return amigoEsc;
    }

    public void setAmigoEsc(String amigoEsc) {
        this.amigoEsc = amigoEsc;
    }

    public String getFerramentaEsc() {
        return ferramentaEsc;
    }

    public void setFerramentaEsc(String ferramentaEsc) {
        this.ferramentaEsc = ferramentaEsc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    


    
    

    
}

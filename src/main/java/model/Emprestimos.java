package model;

import java.sql.Date;

/**
 *
 * @author kauem
 */
public class Emprestimos {
    
    public int ID;
    public String amigoEsc;
    public String ferramentaEsc;
    public Date dataEms;
    public Date dataDev;

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

    public Date getDataEms() {
        return dataEms;
    }

    public void setDataEms(Date dataEms) {
        this.dataEms = dataEms;
    }

    public Date getDataDev() {
        return dataDev;
    }

    public void setDataDev(Date dataDev) {
        this.dataDev = dataDev;
    }

    
}

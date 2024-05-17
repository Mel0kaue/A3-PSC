package model;

import dao.AmigosDAO;
import java.util.ArrayList;

public class Amigo {
    
    public String nome;
    public int telefone;
    public int IdAmigo;

    public Amigo() {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getIdAmigo() {
        return IdAmigo;
    }

    public void setIdAmigo(int IdAmigo) {
        this.IdAmigo = IdAmigo;
    }

    /*public ArrayList<Amigo> getMinhaLista() {
        return AmigosDAO.getMinhaLista();
    }*/

    
    
    
    
}

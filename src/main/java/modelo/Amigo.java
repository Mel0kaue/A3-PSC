package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

public class Amigo {

    public String nome;
    public String telefone;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdAmigo() {
        return IdAmigo;
    }

    public void setIdAmigo(int IdAmigo) {
        this.IdAmigo = IdAmigo;
    }

}

package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

/**
 * Classe que representa um amigo.
 *
 */
public class Amigo {

    public String nome;
    public String telefone;
    public int IdAmigo;

    /**
     * Construtor padrão da classe Amigo.
     */
    public Amigo() {
        this.nome = nome;
        this.telefone = telefone;
    }

    /**
     * Obtém o nome do amigo.
     *
     * @return O nome do amigo.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do amigo.
     *
     * @param nome O nome do amigo.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o telefone do amigo.
     *
     * @return O telefone do amigo.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do amigo.
     *
     * @param telefone O telefone do amigo.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém o ID do amigo.
     *
     * @return O ID do amigo.
     */
    public int getIdAmigo() {
        return IdAmigo;
    }

    /**
     * Define o ID do amigo.
     *
     * @param IdAmigo O ID do amigo.
     */
    public void setIdAmigo(int IdAmigo) {
        this.IdAmigo = IdAmigo;
    }

}

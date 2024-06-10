package dao;

import java.util.ArrayList;

/**
 * Interface genérica para operações básicas de acesso a dados (CRUD). Define
 * métodos para inserir, alterar, excluir e consultar objetos genéricos.
 *
 * @param <ObjetoGenerico> O tipo de objeto que será manipulado.
 */
public interface DAOGenerico<ObjetoGenerico> {

    /**
     * Insere um novo objeto no banco de dados.
     *
     * @param obj O objeto a ser inserido.
     */
    public void inserir(ObjetoGenerico obj);

    /**
     * Altera um objeto existente no banco de dados.
     *
     * @param obj O objeto a ser alterado.
     */
    public void alterar(ObjetoGenerico obj);

    /**
     * Exclui um objeto do banco de dados.
     */
    public void excluir();

    /**
     * Consulta e retorna uma lista de objetos do banco de dados.
     *
     * @return Lista de objetos consultados.
     */
    public ArrayList<ObjetoGenerico> consultar();

}

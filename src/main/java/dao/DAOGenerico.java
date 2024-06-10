package dao;

import java.util.ArrayList;

public interface DAOGenerico<ObjetoGenerico> {

    public void inserir(ObjetoGenerico obj);

    public void alterar(ObjetoGenerico obj);

    public void excluir();

    public ArrayList<ObjetoGenerico> consultar();

}

package dao;

import java.util.ArrayList;

public interface DaoGenerico<ObjetoGenerico> {
    
    public void inserir(ObjetoGenerico obj);
    
    public void alterar(ObjetoGenerico obj);
    
    public void excluir();
    
    public ArrayList<ObjetoGenerico> consultar();
    
}

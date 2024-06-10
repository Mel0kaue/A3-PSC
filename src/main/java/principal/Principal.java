package principal;

/**
 * Classe principal que inicia a aplicação.
 */
public class Principal {

    /**
     * Método principal que inicia a aplicação.
     * 
     * @param args Argumentos de linha de comando (não utilizados neste caso).
     */
    public static void main(String[] args) {
        // Cria uma instância da classe Principal da visão e a torna visível
        new visao.Principal().setVisible(true);
    }
}

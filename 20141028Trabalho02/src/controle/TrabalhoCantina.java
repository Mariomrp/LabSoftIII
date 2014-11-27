package controle;


import visao.JanTabelaClientes;

/**
 *
 * @author 631220116
 */
public class TrabalhoCantina {

    private static void createAndShowGUI() {
        JanTabelaClientes janelaclientes = new JanTabelaClientes();

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
}

package view;

import javax.swing.JOptionPane;

public class Main {
    
    private static void createAndShowGUI() {
        
        String escolha;

        Object[] opcoes = {"1", "2", "3", "4"};
        escolha = (String) JOptionPane.showInputDialog(null, "Menu\n1 para 'Tabela de Clientes' ou \n2 para 'Tabela de Produtos'\n3 para 'Tabela de Funcionarios'\n4 para 'Tabela de Vendas'", "Cantina!",
                                                       JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
        if (escolha == null) {
            JOptionPane.showMessageDialog(null, "Programa encerrado!!");
            System.exit(0);
        }
        if (Integer.valueOf(escolha) == 1) {
            JanTabelaClientes janelaclientes = new JanTabelaClientes();
        } if  (Integer.valueOf(escolha) == 2) {
            JanTabelaProdutos janelaprodutos = new JanTabelaProdutos();
        } if  (Integer.valueOf(escolha) == 3) {
            JanTabelaFuncionarios janelafuncionarios = new JanTabelaFuncionarios();
        } else {
            JanTabelaVendas janelavendas = new JanTabelaVendas();
        }
    }

    public static void main(String[] args) {

         javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }

}

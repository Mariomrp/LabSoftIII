package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Produto;

/**
 *
 * @author 631220116
 */
public class JanTabelaProdutos extends JFrame implements ActionListener {

    TabelaProdutos tabProdutos;
    JButton botaoAdicionar, botaoRemover;

    public JanTabelaProdutos() {
        super("Tabela de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        tabProdutos = new TabelaProdutos();
        getContentPane().add(tabProdutos, BorderLayout.CENTER);

        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout());
        botaoAdicionar = new JButton("Novo Produto");
        botaoRemover = new JButton("Remover Produto");
        botaoPanel.add(botaoAdicionar);
        botaoPanel.add(botaoRemover);

        botaoAdicionar.addActionListener(this);
        botaoRemover.addActionListener(this);

        getContentPane().add(botaoPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(botaoAdicionar)) {
            String nome = JOptionPane.showInputDialog("Nome:");
            String tipo = JOptionPane.showInputDialog("Tipo: ");
            Double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço: "));

            tabProdutos.adicionaProduto(new Produto(nome, tipo, preco));
        } else if (e.getSource().equals(botaoRemover)) {
            tabProdutos.removeProdutoSelecionado();
        }
    }
}

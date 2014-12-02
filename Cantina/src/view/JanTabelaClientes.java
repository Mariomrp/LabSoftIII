package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Cliente;

/**
 *
 * @author 631220116
 */
public class JanTabelaClientes extends JFrame implements ActionListener {

    TabelaClientes tabClientes;
    JButton botaoAdicionar, botaoRemover;

    public JanTabelaClientes() {
        super("Tabela de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        tabClientes = new TabelaClientes();
        getContentPane().add(tabClientes, BorderLayout.CENTER);

        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout());
        botaoAdicionar = new JButton("Novo Cliente");
        botaoRemover = new JButton("Remover Cliente");
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
            String email = JOptionPane.showInputDialog("Email: ");
            Double saldo = Double.parseDouble(JOptionPane.showInputDialog("Saldo: "));

            tabClientes.adicionaCliente(new Cliente(nome, email, saldo));
        } else if (e.getSource().equals(botaoRemover)) {
            tabClientes.removeClienteSelecionado();
        }
    }
}


package view;

import dao.ClienteDAO;
import dao.ClienteDAOJDBC;
import dao.FuncionarioDAO;
import dao.FuncionarioDAOJDBC;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Cliente;
import model.Funcionario;
import model.Venda;

/**
 *
 * @author 631220116
 */
public class JanTabelaVendas extends JFrame implements ActionListener {

    TabelaVendas tabVendas;
    JButton botaoAdicionar, botaoRemover;

    public JanTabelaVendas() {
        super("Tabela de Vendas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        tabVendas = new TabelaVendas();
        getContentPane().add(tabVendas, BorderLayout.CENTER);

        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout());
        botaoAdicionar = new JButton("Nova Venda");
        botaoRemover = new JButton("Remove Venda");
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
            String nomeFuncionario = JOptionPane.showInputDialog("Funcionario:");
            FuncionarioDAO funcDao = new FuncionarioDAOJDBC();
            Funcionario funcionario = funcDao.buscarPorNome(nomeFuncionario);
            
            String nomeCliente = JOptionPane.showInputDialog("Cliente: ");
            ClienteDAO cliDao = new ClienteDAOJDBC();
            Cliente cliente = cliDao.buscarPorNome(nomeCliente);

            Double valor = Double.parseDouble(JOptionPane.showInputDialog("valor: "));
            Date data = new Date();
            
            tabVendas.adicionaVenda(new Venda(funcionario, cliente, valor, data));
        } else if (e.getSource().equals(botaoRemover)) {
            tabVendas.removeVendaSelecionado();
        }
    }
}
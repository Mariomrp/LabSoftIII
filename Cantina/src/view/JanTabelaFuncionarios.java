/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Funcionario;

/**
 *
 * @author 631220116
 */
class JanTabelaFuncionarios extends JFrame implements ActionListener {

    TabelaFuncionarios tabFuncionarios;
    JButton botaoAdicionar, botaoRemover;

    public JanTabelaFuncionarios() {
        super("Tabela de Funcionarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        tabFuncionarios = new TabelaFuncionarios();
        getContentPane().add(tabFuncionarios, BorderLayout.CENTER);

        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout());
        botaoAdicionar = new JButton("Novo Funcionario");
        botaoRemover = new JButton("Remover Funcionario");
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

            tabFuncionarios.adicionaFuncionario(new Funcionario(nome, email));
        } else if (e.getSource().equals(botaoRemover)) {
            tabFuncionarios.removeFuncionarioSelecionado();
        }
    }
}
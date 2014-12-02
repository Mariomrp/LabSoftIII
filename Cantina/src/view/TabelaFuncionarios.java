package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Funcionario;

/**
 *
 * @author 631220116
 */
class TabelaFuncionarios extends JPanel {

    JTable tabelaFuncionarios;

    public TabelaFuncionarios() {
        String[] colunas = {"Matricula", "nome", "email"};

        FuncionariosModelo modeloFuncionarios = new FuncionariosModelo(colunas);
        tabelaFuncionarios = new JTable(modeloFuncionarios);
        tabelaFuncionarios.setPreferredScrollableViewportSize(new Dimension(500, 100));
        tabelaFuncionarios.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tabelaFuncionarios);

        add(scrollPane);
    }

    public JTable getTabela() {
        return tabelaFuncionarios;
    }

    public void adicionaFuncionario(Funcionario funcionario) {
        FuncionariosModelo modeloFuncionario = (FuncionariosModelo) getTabela().getModel();
        modeloFuncionario.adicionaFuncionario(funcionario);
        getTabela().updateUI();

    }

    public void removeFuncionario(int linha) {
        FuncionariosModelo modeloFuncionarios = (FuncionariosModelo) getTabela().getModel();
        System.out.println("Nome:" + modeloFuncionarios.getFuncionario(linha).getNome());
        modeloFuncionarios.removeFuncionario(linha);
        getTabela().updateUI();
    }

    public void removeFuncionarioSelecionado() {
        int linha = getTabela().getSelectedRow();
        if (linha >= 0) {
            removeFuncionario(linha);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Venda;

/**
 *
 * @author 631220116
 */
public class TabelaVendas extends JPanel {

    JTable tabelaVendas;

    public TabelaVendas() {
        String[] colunas = {"Código", "Funcionario", "cliente", "valor", "data"};

        VendasModelo modeloVendas = new VendasModelo(colunas);
        tabelaVendas = new JTable(modeloVendas);
        tabelaVendas.setPreferredScrollableViewportSize(new Dimension(500, 100));
        tabelaVendas.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tabelaVendas);
        
        add(scrollPane);
    }

    public JTable getTabela() {
        return tabelaVendas;
    }

    public void adicionaVenda(Venda venda) {
        VendasModelo modeloVendas = (VendasModelo) getTabela().getModel();
        modeloVendas.adicionaVenda(venda);
        getTabela().updateUI();

    }

    public void removeVenda(int linha) {
        VendasModelo modeloVendas = (VendasModelo) getTabela().getModel();
        System.out.println("Nome:" + modeloVendas.getVenda(linha).getCodigoVenda());
        modeloVendas.removeVendas(linha);
        getTabela().updateUI();
    }

    public void removeVendaSelecionado() {
        int linha = getTabela().getSelectedRow();
        if (linha >= 0) {
            removeVenda(linha);
        }
    }
}

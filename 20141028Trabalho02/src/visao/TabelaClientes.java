package visao;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import modelo.Cliente;

/**
 *
 * @author 631220116
 */
class TabelaClientes extends JPanel {

    JTable tabelaClientes;

    public TabelaClientes() {
        String[] colunas = {"IdCliente", "nome", "email", "telefone", "cidade", "endereco", "cpf", "rg"};

        ClientesModelo modeloClientes = new ClientesModelo(colunas);
        tabelaClientes = new JTable(modeloClientes);
        tabelaClientes.setPreferredScrollableViewportSize(new Dimension(500, 100));
        tabelaClientes.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tabelaClientes);
    }

    public JTable getTabela() {
        return tabelaClientes;
    }

    public void adicionaCliente(Cliente cliente) {
        ClientesModelo modeloClientes = (ClientesModelo) getTabela().getModel();
        modeloClientes.adicionaCliente(cliente);
        getTabela().updateUI();

    }

    public void removeCliente(int linha) {
        ClientesModelo modeloClientes = (ClientesModelo) getTabela().getModel();
        System.out.println("Nome:" + modeloClientes.getCliente(linha).getNome());
        modeloClientes.removeCliente(linha);
        getTabela().updateUI();
    }

    public void removeClienteSelecionado() {
        int linha = getTabela().getSelectedRow();
        if (linha >= 0) {
            removeCliente(linha);
        }
    }
}

package view;

import dao.ClienteDAO;
import dao.ClienteDAOJDBC;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 *
 * @author 631220116
 */
public class ClientesModelo extends AbstractTableModel {

    String header[];
    List<Cliente> clientes;

    public ClientesModelo() {
        clientes = new ArrayList<Cliente>();
    }

    public ClientesModelo(String[] header) {
        this.header = header;
        ClienteDAO dao = new ClienteDAOJDBC();
        this.clientes = dao.listarClientes();

    }

    public ClientesModelo(String[] header, List<Cliente> clientes) {
        this.header = header;
        this.clientes = clientes;

    }

    @Override
    public int getRowCount() {
        return (clientes.size());
    }

    @Override
    public int getColumnCount() {
        return (4);
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return (clientes.get(rowIndex).getMatriculaCliente());
        } if (columnIndex == 1) {
            return (clientes.get(rowIndex).getNome());
        } if (columnIndex == 2) {
            return (clientes.get(rowIndex).getEmail());
        } else {
            return (clientes.get(rowIndex).getSaldo());
        }
    }

    public void adicionaCliente(Cliente cliente) {
        ClienteDAO dao = new ClienteDAOJDBC();
        clientes.add(dao.inserir(cliente));
    }

    public void removeCliente(int linha) {
        ClienteDAO dao = new ClienteDAOJDBC();
        dao.remover(clientes.get(linha));
        clientes.remove(linha);
    }

    public Cliente getCliente(int linha) {
        return (clientes.get(linha));
    }
}

package visao;

import DAO.ClienteDAO;
import DAO.ClienteDAO_JDBC;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Cliente;

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
        ClienteDAO dao = new ClienteDAO_JDBC();
        this.clientes = dao.listarCliente();

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
        return (2);
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return (clientes.get(rowIndex).getNome());
        } else {
            return (clientes.get(rowIndex).getEmail());
        }
    }

    public void adicionaCliente(Cliente cliente) {
        ClienteDAO dao = new ClienteDAO_JDBC();
  //      clientes.add(dao.inserir(cliente));
    }

    public void removeCliente(int linha) {
        ClienteDAO dao = new ClienteDAO_JDBC();
        dao.deletar(clientes.get(linha));
        clientes.remove(linha);
    }

    public Cliente getCliente(int linha) {
        return (clientes.get(linha));
    }
}

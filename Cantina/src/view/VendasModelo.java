package view;

import dao.VendaDAO;
import dao.VendaDAOJDBC;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Venda;

/**
 *
 * @author 631220116
 */
public class VendasModelo extends AbstractTableModel {

    String header[];
    List<Venda> venda;

    public VendasModelo() {
        venda = new ArrayList<Venda>();
    }

    public VendasModelo(String[] header) {
        this.header = header;
        VendaDAO dao = new VendaDAOJDBC();
        this.venda = dao.listarVendas();

    }

    public VendasModelo(String[] header, List<Venda> venda) {
        this.header = header;
        this.venda = venda;

    }

    @Override
    public int getRowCount() {
        return (venda.size());
    }

    @Override
    public int getColumnCount() {
        return (5);
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return (venda.get(rowIndex).getCodigoVenda());
        } if (columnIndex == 1) {
            return (venda.get(rowIndex).getFuncionario().getMatriculaFuncionario());
        } if (columnIndex == 2) {
            return (venda.get(rowIndex).getCliente().getMatriculaCliente());
        } if (columnIndex == 3) {
            return (venda.get(rowIndex).getValor());
        } else {
            return (venda.get(rowIndex).getData());
        }
    }

    public void adicionaVenda(Venda venda) {
        VendaDAO dao = new VendaDAOJDBC();
        venda.add(dao.inserir(venda));
    }

    public void removeVendas(int linha) {
        VendaDAO dao = new VendaDAOJDBC();
        dao.remover(venda.get(linha));
        venda.remove(linha);
    }

    public Venda getVenda(int linha) {
        return (venda.get(linha));
    }
}
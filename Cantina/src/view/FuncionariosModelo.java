/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import dao.FuncionarioDAO;
import dao.FuncionarioDAOJDBC;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Funcionario;

/**
 *
 * @author 631220116
 */
public class FuncionariosModelo extends AbstractTableModel {

    String header[];
    List<Funcionario> funcionarios;

    public FuncionariosModelo() {
        funcionarios = new ArrayList<Funcionario>();
    }

    public FuncionariosModelo(String[] header) {
        this.header = header;
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        this.funcionarios = dao.listarFuncionario();

    }

    public FuncionariosModelo(String[] header, List<Funcionario> funcionario) {
        this.header = header;
        this.funcionarios = funcionario;

    }

    @Override
    public int getRowCount() {
        return (funcionarios.size());
    }

    @Override
    public int getColumnCount() {
        return (3);
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return (funcionarios.get(rowIndex).getMatriculaFuncionario());
        } if (columnIndex == 1) {
            return (funcionarios.get(rowIndex).getNome());
        } else {
            return (funcionarios.get(rowIndex).getEmail());
        }
    }

    public void adicionaFuncionario(Funcionario funcionario) {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        funcionarios.add(dao.inserir(funcionario));
    }

    public void removeFuncionario(int linha) {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        dao.remover(funcionarios.get(linha));
        funcionarios.remove(linha);
    }

    public Funcionario getFuncionario(int linha) {
        return (funcionarios.get(linha));
    }
}

package main.java.Controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main.java.Connection.ClientesDAO;
import main.java.Model.Clientes;

public class ClientesControl {

    private List<Clientes> clientes; // Lista de clientes
    private DefaultTableModel tableModel; // Modelo da tabela
    private JTable table; // Tabela de clientes

    // Construtor
    public ClientesControl(List<Clientes> clientes, DefaultTableModel tableModel, JTable table) {
        this.clientes = clientes;
        this.tableModel = tableModel;
        this.table = table;
    }

    

    // Método para atualizar a tabela de exibição com os dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        clientes = new ClientesDAO().listarTodos(); // Obtém os clientes atualizados do banco de dados

        for (Clientes cliente : clientes) {
            if (cliente.getNomeCliente().equals("") && cliente.getCpfCliente().equals("")) {
                JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente", "Informação Inválida", JOptionPane.ERROR_MESSAGE);
            } else {
                // Adiciona os dados de cada cliente como uma nova linha na tabela Swing
                tableModel.addRow(new Object[] { cliente.getNomeCliente(), cliente.getCpfCliente() });
            }
        }
    }

    // Método para cadastrar um novo cliente no banco de dados
    public void cadastrar(String nomeCliente, String cpfCliente) {
        new ClientesDAO().cadastrar(nomeCliente, cpfCliente); // Realiza o cadastro no banco de dados
    }

    // Método para atualizar os dados de um cliente no banco de dados
    public void atualizar(String nomeCliente, String cpfCliente) {
        new ClientesDAO().atualizar(nomeCliente, cpfCliente); // Realiza a atualização no banco de dados
    }

    // Método para apagar um cliente do banco de dados
    public void apagar(String cpfCliente) {
        new ClientesDAO().apagar(cpfCliente); // Remove o cliente do banco de dados
    }
}

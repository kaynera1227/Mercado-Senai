package main.java.Controller;

import java.awt.JobAttributes;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.java.Connection.ClientesDAO;
import main.java.Connection.EstoqueDAO;
import main.java.Model.Estoque;

public class EstoqueControl {
    // Atributos
    private List<Estoque> estoque;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public EstoqueControl(List<Estoque> estoque, DefaultTableModel tableModel, JTable table) {
        this.estoque = estoque;
        this.tableModel = tableModel;
        this.table = table;
    }

    boolean validarCodigo(String codigoProduto) {

        if (!codigoProduto.matches("-?\\d{1,5}")) {
            JOptionPane.showMessageDialog(null, "Código Inválido! Insira um Código de 1 a 5 Dígitos.", "Erro!",
                    JOptionPane.ERROR_MESSAGE);

            return false; // Retorna false se a Validação for incorreta
        }

        return true;
    }

    boolean validarValorProduto(String valorProduto) {
        if (!valorProduto.matches("\\d{1,4}(\\,\\d{2})?")) {
            JOptionPane.showMessageDialog(null, "Valor Inválido! Insira um Valor Válido", "Erro!",
                    JOptionPane.ERROR_MESSAGE);
            return false; // Retorna false se a validação for incorreta
        }
        return true;
    }
    


    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        estoque = new EstoqueDAO().listarTodos();
        // Obtém os estoqueo atualizados do banco de dados
        for (Estoque estoqueo : estoque) {

            if (estoqueo.getProduto().equals("") && estoqueo.getCodigo().equals("")
                    && estoqueo.getValorUnit().equals("")
                    && estoqueo.getEquantidade().equals("")) {
                JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente", "Informação Inválida", 1);
            } else {
                // Adiciona os dados de cada estoqueo como uma nova linha na tabela Swing
                tableModel.addRow(new Object[] { estoqueo.getProduto(), estoqueo.getCodigo(),

                        estoqueo.getValorUnit(), estoqueo.getEquantidade() });
            }

        }
    }

    // Método para cadastrar um novo estoqueo no banco de dados
    public void cadastrar(String produto, String codigo, String valorUnit, String equantidade) {
        try {
            if (!validarCodigo(codigo) || !validarValorProduto(valorUnit)) {
                return; // Retorna se falhar
            } else {
                new EstoqueDAO().cadastrar(produto, codigo, valorUnit, equantidade);
                // Chama o método de cadastro no banco de dados
                JOptionPane.showMessageDialog(null, "Novo Produto Cadastrado!");
                atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
            }
        } catch (Exception e) {

        }
    }

    // Método para atualizar os dados de um estoqueo no banco de dados
    public void atualizar(String produto, String codigo, String valorUnit, String equantidade) {
        new EstoqueDAO().atualizar(produto, codigo, valorUnit, equantidade);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização

    }

    // Método para apagar um estoqueo do banco de dados
    public void apagar(String codigo) {
        new EstoqueDAO().apagar(codigo);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }
}

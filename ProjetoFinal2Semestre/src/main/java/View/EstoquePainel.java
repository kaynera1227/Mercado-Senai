package main.java.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import main.java.Connection.EstoqueDAO;
import main.java.Controller.EstoqueControl;
import main.java.Model.Estoque;

public class EstoquePainel extends JPanel {
    // Atributos
    private JButton cadastrar, apagar, editar, atualizar;
    private JTextField estoqueProdutoField, estoqueCodigoField, estoqueValorUnitField, estoqueEquantidadeField;
    private List<Estoque> estoque;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor
    public EstoquePainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Produtos"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Produto:"));
        estoqueProdutoField = new JTextField(20);
        inputPanel.add(estoqueProdutoField);

        inputPanel.add(new JLabel("Codigo:"));
        estoqueCodigoField = new JTextField(20);
        inputPanel.add(estoqueCodigoField);

        inputPanel.add(new JLabel("Valor Unitário:"));
        estoqueValorUnitField = new JTextField(20);
        inputPanel.add(estoqueValorUnitField);

        inputPanel.add(new JLabel("Quantidade:"));
        estoqueEquantidadeField = new JTextField(20);
        inputPanel.add(estoqueEquantidadeField);
        add(inputPanel);

        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Salvar Edição"));
        botoes.add(apagar = new JButton("Salvar Exclusão"));
        botoes.add(atualizar = new JButton("Atualizar"));
        add(botoes);
        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Produto", "Codigo", "Valor Unitário", "Quantidade" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Criar a tabela se ela não existir
        new EstoqueDAO().criaTabela();
        // Atualizar a Tabela na Abertura da Janela
        atualizarTabela();

        // Tratamento de Eventos (Construtor)
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    estoqueProdutoField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    estoqueCodigoField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    estoqueValorUnitField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    estoqueEquantidadeField.setText((String) table.getValueAt(linhaSelecionada, 3));
                }
            }
        });

        EstoqueControl operacoes = new EstoqueControl(estoque, tableModel, table);
        // Configura o metodo "cadastrar" do objeto operacoes com Cpfes dos campos de
        // entrada

        cadastrar.addActionListener(e -> {

            operacoes.cadastrar(estoqueProdutoField.getText(), estoqueCodigoField.getText(),
                    estoqueValorUnitField.getText(),
                    estoqueEquantidadeField.getText());

            // Limpa os campos de entrada após a operação de exclusão
            estoqueProdutoField.setText("");
            estoqueCodigoField.setText("");
            estoqueValorUnitField.setText("");
            estoqueEquantidadeField.setText("");

        });

        // Configura a ação do botão editar
        editar.addActionListener(e -> {
            // Chama o metodo "editar" do objeto operacoes com os Cpfs dos campos de
            // entrada

            operacoes.atualizar(estoqueProdutoField.getText(), estoqueCodigoField.getText(),
                    estoqueValorUnitField.getText(),
                    estoqueEquantidadeField.getText());

            // Limpa os campos de entrada após a operação de exclusão
            estoqueProdutoField.setText("");
            estoqueCodigoField.setText("");
            estoqueValorUnitField.setText("");
            estoqueEquantidadeField.setText("");

        });

        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        apagar.addActionListener(e -> {

            operacoes.apagar(estoqueCodigoField.getText());

            // Limpa os campos de entrada após a operação de exclusão
            estoqueProdutoField.setText("");
            estoqueCodigoField.setText("");
            estoqueValorUnitField.setText("");
            estoqueEquantidadeField.setText("");

        });

        atualizar.addActionListener(e -> {
            operacoes.atualizar(estoqueProdutoField.getText(), estoqueCodigoField.getText(),
                    estoqueValorUnitField.getText(),
                    estoqueEquantidadeField.getText());
        });

    };

    // Métodos (Atualizar Tabela)
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        estoque = new EstoqueDAO().listarTodos();
        // Obtém os estoque atualizados do banco de dados
        for (Estoque estoqueo : estoque) {
            // Adiciona os dados de cada estoqueo como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { estoqueo.getProduto(), estoqueo.getCodigo(),

                    estoqueo.getValorUnit(), estoqueo.getEquantidade() });
        }
    }
}

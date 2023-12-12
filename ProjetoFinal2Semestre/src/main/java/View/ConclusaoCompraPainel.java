package main.java.View;

import java.awt.*;
import javax.swing.*;

public class ConclusaoCompraPainel extends JPanel {

    private JTextArea listaProdutosArea;
    private JTextField totalField;
    private JComboBox<String> opcoesPagamento;
    private JButton finalizarCompraBtn;
    private JButton imprimirCupomBtn;

    public ConclusaoCompraPainel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 5, 5, 2);
        gbc.anchor = GridBagConstraints.WEST;

        // Área para listar os produtos
        listaProdutosArea = new JTextArea(20, 30);
        listaProdutosArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listaProdutosArea);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);
        gbc.gridwidth = 1;

        // Campo para mostrar o total da compra
        totalField = new JTextField(10);
        totalField.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Total da Compra:"), gbc);
        gbc.gridx = 1;
        add(totalField, gbc);

        // Opções de pagamento
        String[] opcoesPagamentoArray = {"Dinheiro", "Cartão","Pix", "Outro"};
        opcoesPagamento = new JComboBox<>(opcoesPagamentoArray);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Opções de Pagamento:"), gbc);
        gbc.gridx = 1;
        add(opcoesPagamento, gbc);

        // Botão para finalizar a compra
        finalizarCompraBtn = new JButton("Finalizar Compra");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(finalizarCompraBtn, gbc);
        gbc.gridwidth = 1;

        // Botão para imprimir o cupom fiscal
        imprimirCupomBtn = new JButton("Imprimir Cupom Fiscal");
        gbc.gridx = 2;  // Definindo a nova posição X
        gbc.gridy = 3;  // Definindo a nova posição Y
        gbc.gridwidth = 2;
        add(imprimirCupomBtn, gbc);
        gbc.gridwidth = 1;
    }
}

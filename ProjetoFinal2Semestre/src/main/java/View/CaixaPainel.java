package main.java.View;

import java.awt.*;
import javax.swing.*;

public class CaixaPainel extends JPanel {

    private JTextField codigoProdutoField;
    private JTextField quantidadeField;
    private JList<String> listaProdutos;
    private DefaultListModel<String> listaModelo;
    private JButton adicionarProdutoBtn;
    private JButton removerProdutoBtn;
    private JLabel descontoLabel;
    private JTextField cpfClienteVipField;
    private JButton validarCpfBtn;

    public CaixaPainel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 5, 5, 2);
        gbc.anchor = GridBagConstraints.WEST;

        // Campo para inserir o código do produto
        codigoProdutoField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Código do Produto:"), gbc);
        gbc.gridx = 1;
        add(codigoProdutoField, gbc);

        // Campo para inserir a quantidade de unidades
        quantidadeField = new JTextField(2);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Quantidade:"), gbc);
        gbc.gridx = 1;
        add(quantidadeField, gbc);

        // Lista para adicionar os produtos
        listaModelo = new DefaultListModel<>();
        listaProdutos = new JList<>(listaModelo);
        listaProdutos.setVisibleRowCount(5);
        JScrollPane scrollPane = new JScrollPane(listaProdutos);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(350, 150));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);
        gbc.gridwidth = 1;

        // Botões para adicionar e remover produtos
        adicionarProdutoBtn = new JButton("Adicionar Produto");
        adicionarProdutoBtn.setBackground(Color.GREEN);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(adicionarProdutoBtn, gbc);

        removerProdutoBtn = new JButton("Remover Produto");
        removerProdutoBtn.setBackground(Color.RED);
        removerProdutoBtn.setForeground(Color.WHITE);
        gbc.gridx = 1;
        add(removerProdutoBtn, gbc);

        // Indicação visual de desconto para Cliente VIP
        descontoLabel = new JLabel("Cliente VIP");
        descontoLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        add(descontoLabel, gbc);

        // Campo para inserir o CPF do cliente VIP
        GridBagConstraints gbcCpf = new GridBagConstraints();
        gbcCpf.gridx = 0;
        gbcCpf.gridy = 5;
        gbcCpf.insets = new Insets(2, 5, 5, 0);
        gbcCpf.anchor = GridBagConstraints.WEST;
        add(new JLabel("CPF do Cliente VIP:"), gbcCpf);

        cpfClienteVipField = new JTextField(8);
        gbcCpf.gridx = 1;
        gbcCpf.gridwidth = 3;
        add(cpfClienteVipField, gbcCpf);

        // Botão "Validar" para o CPF
        validarCpfBtn = new JButton("Validar");
        GridBagConstraints gbcValidarCpf = new GridBagConstraints();
        gbcValidarCpf.gridx = 2;
        gbcValidarCpf.gridy = 5;
        gbcValidarCpf.insets = new Insets(2, 0, 5, 5);
        gbcValidarCpf.anchor = GridBagConstraints.WEST;
        add(validarCpfBtn, gbcValidarCpf);
    }

}

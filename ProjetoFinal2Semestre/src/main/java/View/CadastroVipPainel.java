package main.java.View;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

import main.java.Connection.ClientesDAO;
import main.java.Controller.ClientesControl;
import main.java.Model.Clientes;

public class CadastroVipPainel extends JPanel {
    private JLabel tituloCadastro;
    private JButton cadastroButton;
    private JLabel nomeLabel;
    private JTextField inserirNome;
    private JLabel cpfLabel;
    private JTextField inserirCpf;
    private List<Clientes> clientes; // Lista de clientes
    private JTable table;
    private DefaultTableModel tableModel;

    public CadastroVipPainel() {
        tituloCadastro = new JLabel("Cadastro de Cliente");
        nomeLabel = new JLabel("Nome:");
        inserirNome = new JTextField(15);
        cpfLabel = new JLabel("CPF:");
        inserirCpf = new JTextField(15);
        cadastroButton = new JButton("Cadastrar");

        cadastroButton.setPreferredSize(new Dimension(100, 40));
        inserirCpf.setPreferredSize(new Dimension(100, 30));
        inserirNome.setPreferredSize(new Dimension(100, 30));

        Font fonte = cpfLabel.getFont();
        cpfLabel.setFont(new Font(fonte.getName(), Font.BOLD, 15));
        nomeLabel.setFont(new Font(fonte.getName(), Font.BOLD, 15));

        Font fonte2 = tituloCadastro.getFont();
        tituloCadastro.setFont(new Font(fonte2.getName(), Font.BOLD, 20));

        cadastroButton.setBackground(Color.BLUE);
        cadastroButton.setForeground(Color.WHITE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 0, 10);

        add(tituloCadastro, gbc);

        gbc.gridy = 1;
        add(nomeLabel, gbc);

        gbc.gridy = 2;
        add(inserirNome, gbc);

        gbc.gridy = 3;
        add(cpfLabel, gbc);

        gbc.gridy = 4;
        add(inserirCpf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(cadastroButton, gbc);


        ClientesControl operacoes = new ClientesControl(clientes, tableModel, table); // Instância do controlador

        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.cadastrar(inserirNome.getText(), inserirCpf.getText());

                inserirNome.setText("");
                inserirCpf.setText("");

                String nome = inserirNome.getText();
                String cpf = inserirCpf.getText();

                JOptionPane.showMessageDialog(null, "Cliente VIP Cadastrado!\nNome: " + nome + "\nCPF: " + cpf);
            }
        });
    }
}

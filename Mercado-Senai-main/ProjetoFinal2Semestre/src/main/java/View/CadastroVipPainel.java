package main.java.View;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import main.java.Connection.ClientesDAO;
import main.java.Controller.ClientesControl;

public class CadastroVipPainel extends JPanel {
    private JLabel tituloCadastro;
    private JButton cadastroButton;
    private JLabel nomeLabel;
    private JTextField inserirNome;
    private JLabel cpfLabel;
    private JTextField inserirCpf;

    public CadastroVipPainel() {
        tituloCadastro = new JLabel("Cadastro de Cliente");
        nomeLabel = new JLabel("Nome:");
        inserirNome = new JTextField(15);
        cpfLabel = new JLabel("CPF:");
        inserirCpf = new JFormattedTextField(formatar ("###.###.###-##"));
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

        // Criar a Tabela se ela não existir
        new ClientesDAO().criaTabela();


        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.cadastrar(inserirNome.getText(), inserirCpf.getText());

                inserirNome.setText("");
                inserirCpf.setText("");
            }
        });

    }

    ClientesControl operacoes = new ClientesControl(); // Instância do controlador

    private MaskFormatter formatar(String mascara){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter(mascara);
        }catch(ParseException e){
            System.out.println("Formatacao com erro"+ e);
        }
        return mask;
    }

}

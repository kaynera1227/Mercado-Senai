package main.java.View;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {
    private JLabel tituloLogin;
    private JComboBox<String> selecionarCargo;
    private JButton login;
    private JLabel senha;
    private JPasswordField inserirSenha;

    public TelaInicial() {
        super("Tela Inicial"); // Definindo o título da janela

        tituloLogin = new JLabel("Realize seu Login");

        selecionarCargo = new JComboBox<>();
        selecionarCargo.addItem("Gerente");
        selecionarCargo.addItem("Gestor de Estoque");
        selecionarCargo.addItem("Caixa");

        senha = new JLabel("Senha:");
        inserirSenha = new JPasswordField();
        login = new JButton("Login");

        // Configurando o tamanho preferencial dos componentes
        selecionarCargo.setPreferredSize(new Dimension(200, 40)); // Ajustando o tamanho do JComboBox
        login.setPreferredSize(new Dimension(100, 30)); // Ajustando o tamanho do JButton
        inserirSenha.setPreferredSize(new Dimension(100, 30));

        // Definindo o tamanho da fonte para o JLabel "Senha"
        Font fonte = senha.getFont(); // Obtendo a fonte padrão do JLabel
        senha.setFont(new Font(fonte.getName(), Font.BOLD, 15));

        Font fonte2 = tituloLogin.getFont(); // Obtendo a fonte padrão do JLabel
        tituloLogin.setFont(new Font(fonte2.getName(), Font.BOLD, 20)); // Definindo o tamanho da fonte para 20 pontos

        // Mudando a cor de fundo e a cor do texto do JComboBox
        selecionarCargo.setForeground(Color.BLACK); // Mudando a cor do texto
        selecionarCargo.setBackground(Color.WHITE); // Mudando a cor de fundo

        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK); // Mudando a cor do texto

        // Usando o GridBagLayout para controlar o tamanho dos componentes
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

        add(tituloLogin, gbc);

        gbc.gridy = 1;
        add(selecionarCargo, gbc);

        gbc.gridy = 2;
        add(senha, gbc);

        gbc.gridy = 3;
        add(inserirSenha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(login, gbc);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o programa ao fechar a janela
        pack(); // Ajusta o tamanho da janela para os componentes
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    // método para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }

}

package main.java.View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaCaixa extends JFrame {
    // criação do tabbedPane para incluir as tabs
    private JTabbedPane jTPane;

    public JanelaCaixa() {
        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabs
        CaixaPainel tab1 = new CaixaPainel();
        jTPane.add("Caixa", tab1);
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CadastroVipPainel tab2 = new CadastroVipPainel();
        jTPane.add("Cadastro VIP", tab2);
        setBounds(100, 100, 906, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EstoquePainel tab3 = new EstoquePainel();
        jTPane.add("Estoque", tab3);
        setBounds(100, 100, 906, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // método para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
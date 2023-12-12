package main.java.View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class JanelaCaixa extends JFrame {
    private JTabbedPane jTPane;

    public JanelaCaixa() {
        jTPane = new JTabbedPane();
        add(jTPane);

        // Criando a aba "Caixa" e adicionando o painel correspondente
        CaixaPainel tab1 = new CaixaPainel();
        jTPane.add("Caixa", tab1);

        // Criando a aba "Cadastro VIP" e adicionando o painel correspondente
        CadastroVipPainel tab2 = new CadastroVipPainel();
        jTPane.add("Cadastro VIP", tab2);

        // Criando a aba "Conclusão de Compra" e adicionando o painel correspondente
        ConclusaoCompraPainel tab3 = new ConclusaoCompraPainel();
        jTPane.add("Conclusão de Compra", tab3);

        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JanelaCaixa janela = new JanelaCaixa();
            janela.run();
        });
    }
}

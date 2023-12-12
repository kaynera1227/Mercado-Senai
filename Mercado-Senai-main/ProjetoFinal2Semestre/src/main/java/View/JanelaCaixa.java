package main.java.View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class JanelaCaixa extends JFrame {
    private JTabbedPane jTPane;

    public JanelaCaixa() {
        jTPane = new JTabbedPane();
        add(jTPane);

        CaixaPainel tab1 = new CaixaPainel();
        jTPane.add("Caixa", tab1);

        CadastroVipPainel tab2 = new CadastroVipPainel();
        jTPane.add("Cadastro VIP", tab2);

        // Adicionando a aba "Conclusão da Compra"
        ConclusaoCompraPainel tab3 = new ConclusaoCompraPainel();
        jTPane.add("Conclusão da Compra", tab3);

                EstoquePainel tab4 = new EstoquePainel();
        jTPane.add("Estoque", tab4);

        setBounds(100, 100, 906, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JanelaCaixa janelaCaixa = new JanelaCaixa();
            janelaCaixa.run();
        });
    }
}

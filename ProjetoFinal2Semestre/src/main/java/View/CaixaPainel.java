package main.java.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class CaixaPainel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public CaixaPainel() {
        setLayout(new BorderLayout());

        JPanel panelTop = criarPainelTop();
        JScrollPane scrollPane = criarScrollPane();
        JPanel panelBotoes = criarPainelBotoes();
        JPanel panelClienteVIP = criarPainelClienteVIP();

        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.add(panelTop, BorderLayout.NORTH);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        add(panelCentral, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);
        add(panelClienteVIP, BorderLayout.EAST);
    }

    private JPanel criarPainelTop() {
        JPanel panelTop = new JPanel();
        // Seu código para o painel Top aqui
        panelTop.add(new JLabel("Código do Produto:"));
        panelTop.add(new JTextField(10));
        panelTop.add(new JLabel("Quantidade:"));
        panelTop.add(new JTextField(5));
        panelTop.add(new JButton("Adicionar"));
        panelTop.add(new JButton("Remover"));
        return panelTop;
    }

    private JScrollPane criarScrollPane() {
        JPanel panelLista = new JPanel();
        panelLista.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Produto", "Código", "Valor Unitário", "Quantidade"});
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(table);
        panelLista.add(scrollPane);

        // Tratamento de Eventos
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    // Aqui você pode realizar ações com base na linha selecionada
                    String produto = (String) table.getValueAt(linhaSelecionada, 0);
                    String codigo = (String) table.getValueAt(linhaSelecionada, 1);
                    String valorUnit = (String) table.getValueAt(linhaSelecionada, 2);
                    String quantidade = (String) table.getValueAt(linhaSelecionada, 3);                                                           
                }
            }
        });

        return scrollPane;
    }

    private JPanel criarPainelClienteVIP() {
        JPanel panelClienteVIP = new JPanel();
        panelClienteVIP.setLayout(new BoxLayout(panelClienteVIP, BoxLayout.Y_AXIS));

        JLabel labelClienteVIP = new JLabel("Cliente VIP:");
        labelClienteVIP.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField campoCPF = new JFormattedTextField(formatar("###.###.###-##"));
        campoCPF.setMaximumSize(new Dimension(150, 25));

        JButton botaoValidar = new JButton("Validar CPF");
        botaoValidar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelClienteVIP.add(Box.createVerticalStrut(20));
        panelClienteVIP.add(labelClienteVIP);
        panelClienteVIP.add(Box.createVerticalStrut(10));
        panelClienteVIP.add(campoCPF);
        panelClienteVIP.add(Box.createVerticalStrut(10));
        panelClienteVIP.add(botaoValidar);

        return panelClienteVIP;
    }

    private JPanel criarPainelBotoes() {
        JPanel panelBotoes = new JPanel();
        JButton botaoFinalizarCompra = new JButton("Finalizar Compra");
        panelBotoes.add(botaoFinalizarCompra);
        return panelBotoes;
    }

    private MaskFormatter formatar(String mascara) {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter(mascara);
        } catch (ParseException e) {
            System.out.println("Formatacao com erro" + e);
        }
        return mask;
    }

}

package main.java.Controller;

import javax.swing.JOptionPane;
import main.java.Connection.ClientesDAO;

public class ClientesControl {

    // Método para a Verificação do Nome
    public boolean validarNome(String nome) {

        // Regex para verificar se o nome contém caracteres especiais
        if (!nome.matches("^[\\p{L} .'-]+$")) {
            JOptionPane.showMessageDialog(null, "Nome Inválido!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }

        return true;
    }

    // Método para cadastrar um novo cliente no banco de dados
    public void cadastrar(String nomeCliente, String cpfCliente) {

        try {
            if (validarNome(nomeCliente)) {
                new ClientesDAO().cadastrar(nomeCliente, cpfCliente); // Realiza o cadastro no banco de dados
                JOptionPane.showMessageDialog(null, "Novo Cliente Cadastrado!");

            }

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Nome Inválido!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Método para atualizar os dados de um cliente no banco de dados
    public void atualizar(String nomeCliente, String cpfCliente) {
        new ClientesDAO().atualizar(nomeCliente, cpfCliente); // Realiza a atualização no banco de dados
    }

}

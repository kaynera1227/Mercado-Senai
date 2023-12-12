package main.java.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.Model.Clientes;
import main.java.Model.Vendas;

public class VendasDAO {
    private Connection connection;
    private List<Vendas> vendas;

    public VendasDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS vendas_mercado (PRODUTO VARCHAR(255), QUANTIDADE INT, CODIGO_PRODUTO VARCHAR(255), CPF_CLIENTE VARCHAR(255), PRIMARY KEY (PRODUTO, CPF_CLIENTE), FOREIGN KEY (CPF_CLIENTE) REFERENCES clientes_mercado(CPF))";

        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de vendas criada com sucesso.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de vendas: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public List<Vendas> listarTodas() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        vendas = new ArrayList<>();

        try {
            stmt = connection.prepareStatement("SELECT * FROM vendas_mercado");
            rs = stmt.executeQuery();

            while (rs.next()) {
                String produto = rs.getString("produto");
                int quantidade = rs.getInt("quantidade");
                String codigoProduto = rs.getString("codigo_produto");
                String cpfCliente = rs.getString("cpf_cliente");

                Clientes cliente = buscarClientePorCPF(cpfCliente);

                Vendas venda = new Vendas(produto, quantidade, codigoProduto, cliente);
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return vendas;
    }

    public void cadastrar(Vendas venda) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO vendas_mercado (produto, quantidade, codigo_produto, cpf_cliente) VALUES (?, ?, ?, ?)";

        try {         
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, venda.getProduto());
            stmt.setInt(2, venda.getQuantidade());
            stmt.setString(3, venda.getCodigoProduto());
            stmt.setString(4, venda.getCliente().getCpf());

            stmt.executeUpdate();
            System.out.println("Venda registrada com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao registrar venda no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    private Clientes buscarClientePorCPF(String cpfCliente) {
        // Implemente este método para buscar e retornar um cliente pelo CPF
        // Você pode criar um ClienteDAO ou implementar uma busca direta no banco de dados
        return null;
    }

    public void apagar(String produto, String cpfCliente) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM vendas_mercado WHERE produto = ? AND cpf_cliente = ?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto);
            stmt.setString(2, cpfCliente);

            stmt.executeUpdate();
            System.out.println("Venda apagada com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar venda no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}

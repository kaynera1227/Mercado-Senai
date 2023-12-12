package main.java.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.Model.Estoque;

public class EstoqueDAO {
    // Atributos
    private Connection connection;
    private List<Estoque> estoque;

    // Construtor
    public EstoqueDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // Métodos do CRUD
    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS estoque_mercado (PRODUTO VARCHAR(255), CODIGO VARCHAR(255) PRIMARY KEY, VALORUNIT VARCHAR(255), EQUANTIDADE VARCHAR(255))";

        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Estoque> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        estoque = new ArrayList<>();
        // Cria uma lista para armazenar os estoque recuperados do banco de dados
        try {
            stmt = connection.prepareStatement("SELECT * FROM estoque_mercado");
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto estoque com os valores do
                // registro

                Estoque estoqueo = new Estoque(
                        rs.getString("produto"),
                        rs.getString("codigo"),
                        rs.getString("valorUnit"),
                        rs.getString("equantidade"));
                estoque.add(estoqueo); // Adiciona o objeto estoque à lista de estoque
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return estoque; // Retorna a lista de estoque recuperados do banco de dados
    }

    // Cadastrar Carro no banco
    public void cadastrar(String produto, String codigo, String valorUnit, String equantidade) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO estoque_mercado (produto, codigo, valorUnit, equantidade) VALUES (?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto);
            stmt.setString(2, codigo);
            stmt.setString(3, valorUnit);
            stmt.setString(4, equantidade);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualizar dados no banco
    public void atualizar(String produto, String codigo, String valorUnit, String equantidade) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pelo código
        String sql = "UPDATE estoque_mercado SET produto = ?, valorUnit = ?, equantidade = ? WHERE codigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto);
            stmt.setString(2, valorUnit);
            stmt.setString(3, equantidade);
            stmt.setString(4, codigo);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
    

    // Apagar dados do banco
    public void apagar(String codigo) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pela codigo
        String sql = "DELETE FROM estoque_mercado WHERE codigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigo);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}

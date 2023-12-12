package main.java.Model;

public class Vendas {
    
    // Atributos
    private String produto;
    private int quantidade;  // Alterado para int
    private String codigoProduto;
    private Clientes cliente;  // Adicionado para associar a venda a um cliente
    
    public Vendas(String produto, int quantidade, String codigoProduto, Clientes cliente) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.codigoProduto = codigoProduto;
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
}

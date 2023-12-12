package main.java.Model;

public class Estoque {

    // Atributos
    private String produto;
    private String codigo;
    private String valorUnit;
    private String equantidade;

    // Construtor
    public Estoque(String produto, String codigo, String valorUnit, String equantidade) {
        this.produto = produto;
        this.codigo = codigo;
        this.valorUnit = valorUnit;
        this.equantidade = equantidade;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(String valorUnit) {
        this.valorUnit = valorUnit;
    }

    public String getEquantidade() {
        return equantidade;
    }

    public void setEquantidade(String equantidade) {
        this.equantidade = equantidade;
    }

}

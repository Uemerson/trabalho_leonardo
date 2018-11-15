package model;

/**
 *
 * @author taynan
 */
public class Produto {

    private int id_produto;
    private String nome_produto;
    private String marca;
    private String codigo_barra;
    private int quantidade_estoque;
    private float preco_compra;
    private float preco_venda;
    private Fornecedor fornecedor;
    private float margem;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getCodigoBarra() {
        return codigo_barra;
    }

    public void setCodigoBarra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }
    
    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public float getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(float preco_compra) {
        this.preco_compra = preco_compra;
    }

    public float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public float getMargem() {
        return margem;
    }

    public void setMargem(float margem) {
        this.margem = margem;
    }

}

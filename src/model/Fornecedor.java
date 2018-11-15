package model;

/**
 *
 * @author Tércio Ribeiro
 */
public class Fornecedor {
    
    private int id_fornecedor;
    private String razao_social;
    private String cidade;
    private Estado estado;
    private String cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String email;
    private String telefone;
    private String celular;
    private String cnpj;
    private String nome_fantasia;

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor= id_fornecedor;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public void setNomeFantasia(String nome_fantasia){
        this.nome_fantasia = nome_fantasia;
    }
    
    public String getNomeFantasia(){
        return this.nome_fantasia;
    }
    
    public String getRazaoSocial(){
        return this.razao_social;
    }
    
    public void setRazaoSocial(String razao_social){
        this.razao_social = razao_social;
    }
}

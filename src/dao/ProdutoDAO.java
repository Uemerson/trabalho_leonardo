/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author taynan
 */
public class ProdutoDAO {
    
    PreparedStatement pst;
        String sql;
        
     public void inserir(Produto produto) throws SQLException{
        sql = "INSERT produto (nome_produto, marca, quantidade_estoque, preco_compra, preco_venda,"
                + "fornecedor, margem)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
             pst = ConexaoDAO.getInstance().prepareStatement(sql);
        
            pst.setString(1, produto.getNome_produto());
            pst.setString(2, produto.getMarca());
            pst.setInt(3, produto.getQuantidade_estoque());
            pst.setFloat(4, produto.getPreco_compra());
            pst.setFloat(5, produto.getPreco_venda());
            pst.setString(6, produto.getFornecedor());
            pst.setString(7, produto.getMargem());
        
        
        pst.execute();
        
        pst.close();
        ConexaoDAO.closeInstance();
        
    }
    
    
    public void alterar(Produto produto) throws SQLException{
        
        sql = "UPDATE produto SET nome_produto = ?, marca = ?, quantidade_estoque = ?, preco_compra = ?,"
                    + "preco_venda = ?, fornecedor = ?, margem = ? WHERE id_produto = ?";
        pst = (PreparedStatement) ConexaoDAO.getInstance().prepareStatement(sql);
        pst.setString(1, produto.getNome_produto());
            pst.setString(2, produto.getMarca());
            pst.setInt(3, produto.getQuantidade_estoque());
            pst.setFloat(4, produto.getPreco_compra());
            pst.setFloat(5, produto.getPreco_venda());
            pst.setString(6, produto.getFornecedor());
            pst.setString(7, produto.getMargem());
            pst.setInt(8, produto.getId_produto());
            
            pst.execute();
            
            pst.close();
            ConexaoDAO.closeInstance();
        
    }
    
    public Produto buscar(Produto produto) throws SQLException{
        Produto retornoProduto = new Produto();
        
        String SQL = "SELECT id_produto, nome_produto, marca, quantidade_estoque, preco_compra,"
                +"preco_venda, fornecedor, margem FROM produto WHERE produto.id_produto = ?";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        pst.setInt(1, produto.getId_produto());
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()){
            
            retornoProduto.setId_produto(rs.getInt("id_produto"));
            retornoProduto.setNome_produto(rs.getString("nome_produto"));
            retornoProduto.setMarca(rs.getString("marca"));
            retornoProduto.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
            retornoProduto.setPreco_compra(rs.getFloat("preco_compra"));
            retornoProduto.setPreco_venda(rs.getFloat("preco_venda"));
            retornoProduto.setFornecedor(rs.getString("fornecedor"));
            retornoProduto.setMargem(rs.getString("margem"));
            
        }
        
        pst.close();
        rs.close();
        ConexaoDAO.closeInstance();
        
        return retornoProduto;
    }
    
    public void excluir(Produto produto) throws SQLException{
       sql = "DELETE FROM produto WHERE id_produto = ?";
         pst = ConexaoDAO.getInstance().prepareStatement(sql);
        pst.setInt(1, produto.getId_produto());
        
        pst.execute();
        pst.close();
        ConexaoDAO.closeInstance();
    }
    
    public ArrayList<Produto> listaProdutoPesquisar(Produto produto) throws SQLException{
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        
        String SQL = "SELECT produto.id_produto, produto.nome_produto, produto.marca, "
                + "produto.quantidade_estoque, produto.preco_compra, "
                + "produto.preco_venda, produto.fornecedor, produto.margem "
                + "FROM produto ";
                
        if (produto != null){
            if (produto.getId_produto()!= 0){
                SQL += "WHERE id_produto = ?";
            }else if (produto.getNome_produto()!= null){
                SQL += "WHERE nome_produto LIKE ?";
            }else if (produto.getMarca() != null){
                SQL += "WHERE marca LIKE ?";
            }else if (produto.getQuantidade_estoque()!= 0){
                SQL += "WHERE quantidade_estoque LIKE ?";
            }else if (produto.getPreco_compra()!= 0){
                SQL += "WHERE preco_compra LIKE ?";
            }else if (produto.getPreco_venda() != 0){
                SQL += "WHERE preco_venda LIKE ?";
            }else if (produto.getFornecedor()!= null){
                SQL += "WHERE fornecedor LIKE ?";
            }else if (produto.getMargem()!= null){
                SQL += "WHERE margem LIKE ?";
            }
        }
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        if (produto != null){
            if (produto.getId_produto()!= 0){
                pst.setInt(1, produto.getId_produto());
            }else if (produto.getNome_produto()!= null){
                pst.setString(1, produto.getNome_produto()+ "%");
            }else if (produto.getMarca() != null){
                pst.setString(1, produto.getMarca() + "%");
            }else if (produto.getQuantidade_estoque() != 0){
                pst.setString(1, produto.getQuantidade_estoque() + "%");
            }else if (produto.getPreco_compra() != 0){
                pst.setString(1, produto.getPreco_compra() + "%");
            }else if (produto.getPreco_venda() != 0){
                pst.setString(1, produto.getPreco_venda() + "%");
            }else if (produto.getFornecedor() != null){
                pst.setString(1, produto.getFornecedor() + "%");
            }else if (produto.getMargem() != null){
                pst.setString(1, produto.getMargem() + "%");
            }
        }
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
            Produto produtoRetornado = new Produto();
            produtoRetornado.setId_produto(rs.getInt("id_produto"));
            produtoRetornado.setNome_produto(rs.getString("nome_produto"));
            produtoRetornado.setMarca(rs.getString("marca"));
            produtoRetornado.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
            produtoRetornado.setPreco_compra(rs.getFloat("preco_compra"));
            produtoRetornado.setPreco_venda(rs.getFloat("preco_venda"));
            produtoRetornado.setFornecedor(rs.getString("fornecedor"));
            produtoRetornado.setMargem(rs.getString("margem"));
            
            listaProduto.add(produtoRetornado);
        }
        
        pst.close();
        rs.close();
        ConexaoDAO.closeInstance();
        
        return listaProduto;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Produto;

/**
 *
 * @author taynan
 */
public class ProdutoDAO {
    
    PreparedStatement pst;
        String sql;
    
    
    public void alterar(Produto produto) throws SQLException{
        
        sql = "UPDATE produto SET nome_peca = ?, marca = ?, quantidae_estoque = ?, preco_compra = ?,"
                    + "preco_venda = ?, fornecedor = ?, margem = ? WHERE id_produto = ?";
        pst = (PreparedStatement) ConexaoDAO.getInstance().prepareStatement(sql);
        pst.setString(1, produto.getNome_peca());
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
    
}

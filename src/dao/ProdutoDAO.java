package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Fornecedor;
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
                + "id_fornecedor, margem, codigo_barra)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        pst = ConexaoDAO.getInstance().prepareStatement(sql);

        pst.setString(1, produto.getNome_produto());
        pst.setString(2, produto.getMarca());
        pst.setInt(3, produto.getQuantidade_estoque());
        pst.setFloat(4, produto.getPreco_compra());
        pst.setFloat(5, produto.getPreco_venda());
        pst.setInt(6, produto.getFornecedor().getId_fornecedor());
        pst.setFloat(7, produto.getMargem());
        pst.setString(8, produto.getCodigoBarra());
        
        pst.execute();
        
        pst.close();
        ConexaoDAO.closeInstance();
        
    }
    
    
    public void alterar(Produto produto) throws SQLException{
        
        sql = "UPDATE produto SET nome_produto = ?, marca = ?, quantidade_estoque = ?, preco_compra = ?,"
                    + "preco_venda = ?, id_fornecedor = ?, margem = ?, codigo_barra = ? WHERE id_produto = ?";
        pst = (PreparedStatement) ConexaoDAO.getInstance().prepareStatement(sql);
        pst.setString(1, produto.getNome_produto());
        pst.setString(2, produto.getMarca());
        pst.setInt(3, produto.getQuantidade_estoque());
        pst.setFloat(4, produto.getPreco_compra());
        pst.setFloat(5, produto.getPreco_venda());
        pst.setInt(6, produto.getFornecedor().getId_fornecedor());
        pst.setFloat(7, produto.getMargem());
        pst.setString(8, produto.getCodigoBarra());
        pst.setInt(9, produto.getId_produto());

        pst.execute();

        pst.close();
        ConexaoDAO.closeInstance();
        
    }
    
    public Produto buscar(Produto produto) throws SQLException{
        Produto retornoProduto = new Produto();
        
        String SQL = "SELECT produto.id_produto, produto.nome_produto, produto.codigo_barra, produto.marca, "
                + "produto.quantidade_estoque, produto.preco_compra, produto.preco_venda, produto.id_fornecedor, "
                + "produto.margem, fornecedor.razao_social FROM produto "
                + "INNER JOIN fornecedor ON fornecedor.id_fornecedor = produto.id_fornecedor WHERE produto.id_produto = ?";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        pst.setInt(1, produto.getId_produto());
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()){
            
            retornoProduto.setId_produto(rs.getInt("id_produto"));
            retornoProduto.setNome_produto(rs.getString("nome_produto"));
            retornoProduto.setCodigoBarra(rs.getString("codigo_barra"));
            retornoProduto.setMarca(rs.getString("marca"));
            retornoProduto.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
            retornoProduto.setPreco_compra(rs.getFloat("preco_compra"));
            retornoProduto.setPreco_venda(rs.getFloat("preco_venda"));
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId_fornecedor(rs.getInt("id_fornecedor"));
            fornecedor.setRazaoSocial(rs.getString("razao_social"));
            
            retornoProduto.setFornecedor(fornecedor);
            retornoProduto.setMargem(rs.getFloat("margem"));
            retornoProduto.setCodigoBarra(rs.getString("codigo_barra"));
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
        
        String SQL = "SELECT produto.id_produto, produto.id_fornecedor, produto.nome_produto, produto.marca, "
                + "produto.quantidade_estoque, produto.preco_compra, "
                + "produto.preco_venda, fornecedor.razao_social, produto.margem, produto.codigo_barra "
                + "FROM produto "
                + "INNER JOIN fornecedor ON produto.id_fornecedor = fornecedor.id_fornecedor ";
                
        if (produto != null){
            if (produto.getId_produto()!= 0){
                SQL += "WHERE id_produto = ?";
            }else if (produto.getNome_produto() != null){
                SQL += "WHERE nome_produto LIKE ?";
            }else if (produto.getCodigoBarra() != null){
                SQL += "WHERE codigo_barra LIKE ?";
            }else if (produto.getMarca() != null){
                SQL += "WHERE marca LIKE ?";
            }else if (produto.getPreco_compra()!= 0){
                SQL += "WHERE preco_compra = ?";
            }else if (produto.getPreco_venda() != 0){
                SQL += "WHERE preco_venda = ?";
            }else if (produto.getFornecedor() != null){
                SQL += "WHERE fornecedor.razao_social LIKE ?";
            }else if (produto.getMargem() != 0){
                SQL += "WHERE margem = ?";
            }
        }
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        if (produto != null){
            if (produto.getId_produto()!= 0){
                pst.setInt(1, produto.getId_produto());
            }else if (produto.getNome_produto()!= null){
                pst.setString(1, produto.getNome_produto()+ "%");
            }else if (produto.getCodigoBarra() != null){
                pst.setString(1, produto.getCodigoBarra() + "%");
            }else if (produto.getMarca() != null){
                pst.setString(1, produto.getMarca() + "%");
            }else if (produto.getPreco_compra() != 0){
                pst.setFloat(1, produto.getPreco_compra());
            }else if (produto.getPreco_venda() != 0){
                pst.setFloat(1, produto.getPreco_venda());
            }else if (produto.getFornecedor() != null){
                pst.setString(1, produto.getFornecedor().getRazaoSocial() + "%");
            }else if (produto.getMargem() != 0){
                pst.setFloat(1, produto.getMargem());
            }
        }
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
            Produto produtoRetornado = new Produto();
            produtoRetornado.setId_produto(rs.getInt("id_produto"));
            produtoRetornado.setNome_produto(rs.getString("nome_produto"));
            produtoRetornado.setCodigoBarra(rs.getString("codigo_barra"));
            produtoRetornado.setMarca(rs.getString("marca"));
            produtoRetornado.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
            produtoRetornado.setPreco_compra(rs.getFloat("preco_compra"));
            produtoRetornado.setPreco_venda(rs.getFloat("preco_venda"));
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId_fornecedor(rs.getInt("id_fornecedor"));
            fornecedor.setRazaoSocial(rs.getString("razao_social"));
            
            produtoRetornado.setFornecedor(fornecedor);
            produtoRetornado.setMargem(rs.getFloat("margem"));
            produtoRetornado.setCodigoBarra(rs.getString("codigo_barra"));
            
            listaProduto.add(produtoRetornado);
        }
        
        pst.close();
        rs.close();
        ConexaoDAO.closeInstance();
        
        return listaProduto;
    }
    
    
}

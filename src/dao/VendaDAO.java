package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ItemVenda;
import model.Venda;

/**
 *
 * @author UEMERSON
 */
public class VendaDAO {
    public void inserir(Venda venda) throws SQLException{
        int idVenda = 0;
        String SQL = "INSERT INTO venda (id_funcionario, id_cliente, venda_total, desconto, data_venda) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
        
        pst.setInt(1, venda.getVendedor().getId_funcionario());
        pst.setInt(2, venda.getCliente().getId_cliente());
        pst.setFloat(3, venda.getVenda_total());
        pst.setFloat(4, venda.getDesconto());
        pst.setTimestamp(5, new java.sql.Timestamp(venda.getData_venda().getTime()));
        pst.execute();
        
        ResultSet rs = pst.getGeneratedKeys();
        
        
        while (rs.next()){
            idVenda = rs.getInt(1);
        }
        
        pst.close();
        rs.close();
        ConexaoDAO.closeInstance();
        
        inserirItensVenda(idVenda, venda.getItensVenda());
    }
    
    public void inserirItensVenda(int idVenda, ArrayList<ItemVenda> itensVenda) throws SQLException{
        for (ItemVenda itemVenda : itensVenda){
            String SQL = "INSERT INTO itens_de_venda (id_venda, id_produto, quantidade, preco_unidade, preco_total) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
            pst.setInt(1, idVenda);
            pst.setInt(2, itemVenda.getProduto().getId_produto());
            pst.setFloat(3, itemVenda.getQuantidade());
            pst.setFloat(4, itemVenda.getProduto().getPreco_venda());
            pst.setFloat(5, itemVenda.getTotalVenda());
            pst.execute();
            
            pst.close();
        
        }
        
        ConexaoDAO.closeInstance();
    }
}

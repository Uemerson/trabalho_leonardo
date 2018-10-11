/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;

/**
 *
 * @author Tércio Ribeiro
 */
public class ClienteDAO {
    
    PreparedStatement pst;
    String sql;
    
    
    public void alterar(Cliente cliente) throws SQLException{
        
        sql = "UPDATE cliente SET nome_completo = ?, id_estado = ?, cep = ?, cidade = ? , endereco = ?,"
                    + "numero = ?, complemento = ?, bairro = ?, email = ?, telefone = ?, celular = ?, "
                    + "data_nascimento = ?, rg = ?, cpf = ? WHERE id_cliente = ?";
        pst = (PreparedStatement) ConexaoDAO.getInstance().prepareStatement(sql);
        pst.setString(1, cliente.getNome_completo());
            pst.setInt(2, cliente.getEstado().getId_estado());
            pst.setString(3, cliente.getCep());
            pst.setString(4, cliente.getCidade());
            pst.setString(5, cliente.getEndereco());
            pst.setString(6, cliente.getNumero());
            pst.setString(7, cliente.getComplemento());
            pst.setString(8, cliente.getBairro());
            pst.setString(9, cliente.getEmail());
            pst.setString(10, cliente.getTelefone());
            pst.setString(11, cliente.getCelular());
            pst.setDate(12, new java.sql.Date(cliente.getData_nascimento().getTime()));
            pst.setString(13, cliente.getRg());
            pst.setString(14, cliente.getCpf());
            pst.setInt(15, cliente.getId_cliente());
            
            pst.execute();
            
            pst.close();
            ConexaoDAO.closeInstance();
        
    }
    
}

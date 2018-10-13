/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import model.Estado;

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
    
    public Cliente buscar(Cliente cliente) throws SQLException{
        Cliente retorno = new Cliente();
        
        String SQL = "SELECT cliente.id_funcionario, cliente.nome_completo, estado.id_estado, estado.sigla, "
                + "estado.descricao, cliente.cep, cliente.cidade, cliente.endereco, cliente.numero, "
                + "cliente.complemento, cliente.bairro, cliente.email, cliente.telefone, "
                + "cliente.celular, cliente.data_nascimento, cliente.rg, cliente.cpf, "
                + "FROM cliente"
                + "INNER JOIN estado ON estado.id_estado = cliente.id_estado ";
                
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()){
            retorno.setId_cliente(rs.getInt("id_cliente"));
            retorno.setNome_completo(rs.getString("nome_completo"));
            
            Estado estado = new Estado();
            estado.setId_estado(rs.getInt("id_estado"));
            estado.setSigla(rs.getString("sigla"));
            estado.setDescricao(rs.getString("descricao"));
            retorno.setEstado(estado);
            
            retorno.setCep(rs.getString("cep"));
            retorno.setCidade(rs.getString("cidade"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setNumero(rs.getString("numero"));
            retorno.setComplemento(rs.getString("complemento"));
            retorno.setBairro(rs.getString("bairro"));
            retorno.setEmail(rs.getString("email"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setCelular(rs.getString("celular"));
            retorno.setData_nascimento(rs.getDate("data_nascimento"));
            retorno.setRg(rs.getString("rg"));
            retorno.setCpf(rs.getString("cpf"));
            
            
            }
        
        rs.close();
        pst.close();
        ConexaoDAO.closeInstance();
        
        return retorno;
    }
    
}

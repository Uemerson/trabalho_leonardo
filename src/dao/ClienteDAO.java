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
import model.Cliente;
import model.Estado;

/**
 *
 * @author Tércio Ribeiro
 */
public class ClienteDAO {
    
    PreparedStatement pst;
    String sql;
    
    public void inserir(Cliente cliente) throws SQLException{
        String SQL = "INSERT cliente (nome_completo, id_estado, cep, cidade, endereco"
                + ", numero, complemento, bairro, email, telefone, celular, data_nascimento"
                + ", rg, cpf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
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
        
        
        pst.execute();
        
        pst.close();
        ConexaoDAO.closeInstance();
        
    }
    
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
        
        String SQL = "SELECT cliente.id_cliente, cliente.nome_completo, estado.id_estado, estado.sigla, "
                + "estado.descricao, cliente.cep, cliente.cidade, cliente.endereco, cliente.numero, "
                + "cliente.complemento, cliente.bairro, cliente.email, cliente.telefone, "
                + "cliente.celular, cliente.data_nascimento, cliente.rg, cliente.cpf "
                + "FROM cliente "
                + "INNER JOIN estado ON estado.id_estado = cliente.id_estado "
                + "WHERE cliente.id_cliente = ?";
                
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        pst.setInt(1, cliente.getId_cliente());
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
    
    public void excluir(Cliente cliente) throws SQLException{
        String SQL = "DELETE FROM cliente WHERE id_cliente = ?";
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        pst.setInt(1, cliente.getId_cliente());
        
        pst.execute();
        pst.close();
        ConexaoDAO.closeInstance();
    }
    
    public ArrayList<Cliente> listaClientePesquisar(Cliente cliente) throws SQLException{
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        
        String SQL = "SELECT cliente.id_cliente, cliente.nome_completo, cliente.cep, "
                + "cliente.cidade, cliente.endereco, "
                + "cliente.bairro, cliente.rg, cliente.cpf "
                + "FROM cliente ";
                
        if (cliente != null){
            if (cliente.getId_cliente() != 0){
                SQL += "WHERE id_cliente = ?";
            }else if (cliente.getNome_completo() != null){
                SQL += "WHERE nome_completo LIKE ?";
            }else if (cliente.getCpf() != null){
                SQL += "WHERE cpf LIKE ?";
            }else if (cliente.getRg() != null){
                SQL += "WHERE rg LIKE ?";
            }else if (cliente.getCep() != null){
                SQL += "WHERE cep LIKE ?";
            }else if (cliente.getCidade() != null){
                SQL += "WHERE cidade LIKE ?";
            }else if (cliente.getEndereco() != null){
                SQL += "WHERE endereco LIKE ?";
            }else if (cliente.getBairro() != null){
                SQL += "WHERE bairro LIKE ?";
            }
        }
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        if (cliente != null){
            if (cliente.getId_cliente() != 0){
                pst.setInt(1, cliente.getId_cliente());
            }else if (cliente.getNome_completo() != null){
                pst.setString(1, cliente.getNome_completo() + "%");
            }else if (cliente.getCpf() != null){
                pst.setString(1, cliente.getCpf() + "%");
            }else if (cliente.getRg() != null){
                pst.setString(1, cliente.getRg() + "%");
            }else if (cliente.getCep() != null){
                pst.setString(1, cliente.getCep() + "%");
            }else if (cliente.getCidade() != null){
                pst.setString(1, cliente.getCidade() + "%");
            }else if (cliente.getEndereco() != null){
                pst.setString(1, cliente.getEndereco() + "%");
            }else if (cliente.getBairro() != null){
                pst.setString(1, cliente.getBairro() + "%");
            }
        }
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
            Cliente clienteRetornado = new Cliente();
            clienteRetornado.setId_cliente(rs.getInt("id_cliente"));
            clienteRetornado.setNome_completo(rs.getString("nome_completo"));
            clienteRetornado.setCep(rs.getString("cep"));
            clienteRetornado.setCidade(rs.getString("cidade"));
            clienteRetornado.setEndereco(rs.getString("endereco"));
            clienteRetornado.setBairro(rs.getString("bairro"));
            clienteRetornado.setRg(rs.getString("rg"));
            clienteRetornado.setCpf(rs.getString("cpf"));
            listaCliente.add(clienteRetornado);
        }
        
        pst.close();
        rs.close();
        ConexaoDAO.closeInstance();
        
        return listaCliente;
    }
    
    public boolean verificaCpfDuplicado(Cliente cliente) throws SQLException{
        String SQL = "SELECT cliente.id_cliente FROM cliente WHERE cliente.cpf = ?";
        
        //Editando cadastro
        if (cliente.getId_cliente() != 0){
            SQL += " AND id_cliente != ?";
        }
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        if (cliente.getId_cliente() != 0){
            pst.setString(1, cliente.getCpf());
            pst.setInt(2, cliente.getId_cliente());
        }else{
            pst.setString(1, cliente.getCpf());
        }
        
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()){
            rs.close();
            pst.close();
            ConexaoDAO.closeInstance();

            return true;                                                        //Existe CPF já cadastrado
        }
        
        rs.close();
        pst.close();
        ConexaoDAO.closeInstance();
        
        return false;
    }
}


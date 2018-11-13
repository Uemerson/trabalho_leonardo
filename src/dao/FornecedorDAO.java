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
import model.Estado;
import model.Fornecedor;

/**
 *
 * @author Tércio Ribeiro
 */
public class FornecedorDAO {
    
    PreparedStatement pst;
    String sql;
    
    public void inserir(Fornecedor fornecedor) throws SQLException{
        String SQL = "INSERT fornecedor (nome_completo, id_estado, cep, cidade, endereco"
                + ", numero, complemento, bairro, email, telefone, celular"
                + ", cnpj) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        pst.setString(1, fornecedor.getNome_completo());
        pst.setInt(2, fornecedor.getEstado().getId_estado());
        pst.setString(3, fornecedor.getCep());
        pst.setString(4, fornecedor.getCidade());
        pst.setString(5, fornecedor.getEndereco());
        pst.setString(6, fornecedor.getNumero());
        pst.setString(7, fornecedor.getComplemento());
        pst.setString(8, fornecedor.getBairro());
        pst.setString(9, fornecedor.getEmail());
        pst.setString(10, fornecedor.getTelefone());
        pst.setString(11, fornecedor.getCelular());
        pst.setString(14, fornecedor.getCnpj());
        
        
        pst.execute();
        
        pst.close();
        ConexaoDAO.closeInstance();
        
    }
    
    public void alterar(Fornecedor fornecedor) throws SQLException{
        
        sql = "UPDATE cliente SET nome_completo = ?, id_estado = ?, cep = ?, cidade = ? , endereco = ?,"
                    + "numero = ?, complemento = ?, bairro = ?, email = ?, telefone = ?, celular = ?, "
                    + "cnpj = ? WHERE id_fornecedor = ?";
        pst = (PreparedStatement) ConexaoDAO.getInstance().prepareStatement(sql);
        pst.setString(1, fornecedor.getNome_completo());
            pst.setInt(2, fornecedor.getEstado().getId_estado());
            pst.setString(3, fornecedor.getCep());
            pst.setString(4, fornecedor.getCidade());
            pst.setString(5, fornecedor.getEndereco());
            pst.setString(6, fornecedor.getNumero());
            pst.setString(7, fornecedor.getComplemento());
            pst.setString(8, fornecedor.getBairro());
            pst.setString(9, fornecedor.getEmail());
            pst.setString(10, fornecedor.getTelefone());
            pst.setString(11, fornecedor.getCelular());
            pst.setString(14, fornecedor.getCnpj());
            pst.setInt(15, fornecedor.getId_fornecedor());
            
            pst.execute();
            
            pst.close();
            ConexaoDAO.closeInstance();
        
    }
    
    public Fornecedor buscar(Fornecedor fornecedor) throws SQLException{
        Fornecedor retorno = new Fornecedor();
        
        String SQL = "SELECT fornecedor.id_fornecedor, fornecedor.nome_completo, estado.id_estado, estado.sigla, "
                + "estado.descricao, fornecedor.cep, fornecedor.cidade, fornecedor.endereco, fornecedor.numero, "
                + "fornecedor.complemento, fornecedor.bairro, fornecedor.email, fornecedor.telefone, "
                + "fornecedor.celular, fornecedor.cnpj"
                + "FROM fornecedor "
                + "INNER JOIN estado ON estado.id_estado = fornecedor.id_estado "
                + "WHERE fornecedor.id_fornecedor = ?";
                
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        pst.setInt(1, fornecedor.getId_fornecedor());
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()){
            retorno.setId_fornecedor(rs.getInt("id_fornecedor"));
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
            retorno.setCnpj(rs.getString("cnpj"));
            
        }
        
        rs.close();
        pst.close();
        ConexaoDAO.closeInstance();
        
        return retorno;
    }
    
    public void excluir(Fornecedor fornecedor) throws SQLException{
        String SQL = "DELETE FROM fornecedor WHERE id_fornecedor = ?";
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        pst.setInt(1, fornecedor.getId_fornecedor());
        
        pst.execute();
        pst.close();
        ConexaoDAO.closeInstance();
    }
    
    public ArrayList<Fornecedor> listaFornecedorPesquisar(Fornecedor fornecedor) throws SQLException{
        ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
        
        String SQL = "SELECT fornecedor.id_fornecedor, fornecedor.nome_completo, fornecedor.cep, "
                + "fornecedor.cidade, fornecedor.endereco, "
                + "fornecedor.bairro, cliente.cnpj"
                + "FROM fornecedor ";
                
        if (fornecedor != null){
            if (fornecedor.getId_fornecedor() != 0){
                SQL += "WHERE id_fornecedor = ?";
            }else if (fornecedor.getNome_completo() != null){
                SQL += "WHERE nome_completo LIKE ?";
            }else if (fornecedor.getCnpj() != null){
                SQL += "WHERE cpf LIKE ?";
            }else if (fornecedor.getCep() != null){
                SQL += "WHERE cep LIKE ?";
            }else if (fornecedor.getCidade() != null){
                SQL += "WHERE cidade LIKE ?";
            }else if (fornecedor.getEndereco() != null){
                SQL += "WHERE endereco LIKE ?";
            }else if (fornecedor.getBairro() != null){
                SQL += "WHERE bairro LIKE ?";
            }
        }
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        if (fornecedor != null){
            if (fornecedor.getId_fornecedor() != 0){
                pst.setInt(1, fornecedor.getId_fornecedor());
            }else if (fornecedor.getNome_completo() != null){
                pst.setString(1, fornecedor.getNome_completo() + "%");
            }else if (fornecedor.getCnpj() != null){
                pst.setString(1, fornecedor.getCnpj() + "%");
            }else if (fornecedor.getCep() != null){
                pst.setString(1, fornecedor.getCep() + "%");
            }else if (fornecedor.getCidade() != null){
                pst.setString(1, fornecedor.getCidade() + "%");
            }else if (fornecedor.getEndereco() != null){
                pst.setString(1, fornecedor.getEndereco() + "%");
            }else if (fornecedor.getBairro() != null){
                pst.setString(1, fornecedor.getBairro() + "%");
            }
        }
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
            Fornecedor fornecedorRetornado = new Fornecedor();
            fornecedorRetornado.setId_fornecedor(rs.getInt("id_fornecedor"));
            fornecedorRetornado.setNome_completo(rs.getString("nome_completo"));
            fornecedorRetornado.setCep(rs.getString("cep"));
            fornecedorRetornado.setCidade(rs.getString("cidade"));
            fornecedorRetornado.setEndereco(rs.getString("endereco"));
            fornecedorRetornado.setBairro(rs.getString("bairro"));
            fornecedorRetornado.setCnpj(rs.getString("cnpj"));
            listaFornecedor.add(fornecedorRetornado);
        }
        
        pst.close();
        rs.close();
        ConexaoDAO.closeInstance();
        
        return listaFornecedor;
    }
    
    public boolean verificaCnpjDuplicado(Fornecedor fornecedor) throws SQLException{
        String SQL = "SELECT fornecedor.id_fornecedor FROM fornecedor WHERE fornecedor.cnpj = ?";
        
        //Editando cadastro
        if (fornecedor.getId_fornecedor() != 0){
            SQL += " AND id_fornecedor != ?";
        }
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        if (fornecedor.getId_fornecedor() != 0){
            pst.setString(1, fornecedor.getCnpj());
            pst.setInt(2, fornecedor.getId_fornecedor());
        }else{
            pst.setString(1, fornecedor.getCnpj());
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


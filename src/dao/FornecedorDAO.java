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
        String SQL = "INSERT fornecedor (razao_social, id_estado, cep, cidade, endereco"
                + ", numero, complemento, bairro, email, telefone, celular"
                + ", cnpj, nome_fantasia)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        pst.setString(1, fornecedor.getRazaoSocial());
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
        pst.setString(12, fornecedor.getCnpj());
        pst.setString(13, fornecedor.getNomeFantasia());
        
        pst.execute();
        
        pst.close();
        ConexaoDAO.closeInstance();
        
    }
    
    public void alterar(Fornecedor fornecedor) throws SQLException{
        
        sql = "UPDATE fornecedor SET nome_fantasia = ?, razao_social = ?, id_estado = ?, cep = ?, cidade = ? , endereco = ?,"
                    + "numero = ?, complemento = ?, bairro = ?, email = ?, telefone = ?, celular = ?, "
                    + "cnpj = ? WHERE id_fornecedor = ?";
        pst = (PreparedStatement) ConexaoDAO.getInstance().prepareStatement(sql);
        pst.setString(1, fornecedor.getRazaoSocial());
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
        pst.setString(12, fornecedor.getCnpj());
        pst.setString(13, fornecedor.getNomeFantasia());
        pst.setInt(14, fornecedor.getId_fornecedor());

        pst.execute();

        pst.close();
        ConexaoDAO.closeInstance();
        
    }
    
    public Fornecedor buscar(Fornecedor fornecedor) throws SQLException{
        Fornecedor retorno = new Fornecedor();
        
        String SQL = "SELECT fornecedor.id_fornecedor, fornecedor.nome_fantasia, fornecedor.razao_social,"
                + "estado.id_estado, estado.sigla, "
                + "estado.descricao, fornecedor.cep, fornecedor.cidade, fornecedor.endereco, fornecedor.numero, "
                + "fornecedor.complemento, fornecedor.bairro, fornecedor.email, fornecedor.telefone, "
                + "fornecedor.celular, fornecedor.cnpj "
                + "FROM fornecedor "
                + "INNER JOIN estado ON estado.id_estado = fornecedor.id_estado "
                + "WHERE fornecedor.id_fornecedor = ?";
                
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        pst.setInt(1, fornecedor.getId_fornecedor());
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()){
            retorno.setId_fornecedor(rs.getInt("id_fornecedor"));
            retorno.setNomeFantasia(rs.getString("nome_fantasia"));
            retorno.setRazaoSocial(rs.getString("razao_social"));
            
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
        
        String SQL = "SELECT fornecedor.id_fornecedor,fornecedor.nome_fantasia, fornecedor.razao_social, fornecedor.cep,"
                + "fornecedor.cidade, fornecedor.endereco,"
                + "fornecedor.bairro, fornecedor.cnpj "
                + "FROM fornecedor ";
                
        if (fornecedor != null){
            if (fornecedor.getId_fornecedor() != 0){
                SQL += "WHERE id_fornecedor = ?";
            }else if (fornecedor.getNomeFantasia()!= null){
                SQL += "WHERE nome_fantasia LIKE ?";
            }else if (fornecedor.getRazaoSocial() != null){
                SQL += "WHERE razao_social LIKE ?";
            }else if (fornecedor.getCnpj() != null){
                SQL += "WHERE cnpj LIKE ?";
            }else if (fornecedor.getCep() != null){
                SQL += "WHERE cep LIKE ?";
            }else if (fornecedor.getCidade() != null){
                SQL += "WHERE cidade LIKE ?";
            }else if (fornecedor.getEndereco() != null){
                SQL += "WHERE endereco LIKE ?";
            }else if (fornecedor.getBairro() != null){
                SQL += "WHERE bairro LIKE ?";
            }else if (fornecedor.getCnpj() != null){
                SQL += "WHERE cnpj LIKE ?";
            }
        }
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        if (fornecedor != null){
            if (fornecedor.getId_fornecedor() != 0){
                pst.setInt(1, fornecedor.getId_fornecedor());
            }else if (fornecedor.getNomeFantasia()!= null){
                pst.setString(1, fornecedor.getNomeFantasia() + "%");
            }else if (fornecedor.getRazaoSocial()!= null){
                pst.setString(1, fornecedor.getRazaoSocial() + "%");
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
            fornecedorRetornado.setNomeFantasia(rs.getString("nome_fantasia"));
            fornecedorRetornado.setRazaoSocial(rs.getString("razao_social"));
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

    public ArrayList<Fornecedor> listaFornecedor() throws SQLException{
        ArrayList<Fornecedor> retorno = new ArrayList<>();
        
        String SQL = "SELECT * FROM fornecedor";
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
            Fornecedor fornecedor = new Fornecedor();
            
            fornecedor.setId_fornecedor(rs.getInt("id_fornecedor"));
            fornecedor.setNomeFantasia(rs.getString("nome_fantasia"));
            fornecedor.setRazaoSocial(rs.getString("razao_social"));
            
            
            Estado estado = new Estado();
            estado.setId_estado(rs.getInt("id_estado"));
            
            fornecedor.setEstado(estado);
            fornecedor.setCep(rs.getString("cep"));
            fornecedor.setCidade(rs.getString("cidade"));
            fornecedor.setEndereco(rs.getString("endereco"));
            fornecedor.setNumero(rs.getString("numero"));
            fornecedor.setComplemento(rs.getString("complemento"));
            fornecedor.setBairro(rs.getString("bairro"));
            fornecedor.setEmail(rs.getString("email"));
            fornecedor.setTelefone(rs.getString("telefone"));
            fornecedor.setCelular(rs.getString("celular"));
            fornecedor.setCnpj(rs.getString("cnpj"));
            
            retorno.add(fornecedor);
        }
        
        pst.close();
        rs.close();
        ConexaoDAO.closeInstance();
        
        return retorno;
    }
    
}


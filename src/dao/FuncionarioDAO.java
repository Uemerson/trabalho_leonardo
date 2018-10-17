package dao;

import controller.GerarHash;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cargo;
import model.Estado;
import model.Funcionario;

/**
 *
 * @author UEMERSON
 */
public class FuncionarioDAO {
    
    public void inserir(Funcionario funcionario) throws SQLException{
        String SQL = "INSERT funcionario (nome_completo, id_estado, cep, cidade, endereco"
                + ", numero, complemento, bairro, email, telefone, celular, data_nascimento"
                + ", rg, cpf, login, senha, data_contratado, data_demissao, salario, id_cargo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        pst.setString(1, funcionario.getNome_completo());
        pst.setInt(2, funcionario.getEstado().getId_estado());
        pst.setString(3, funcionario.getCep());
        pst.setString(4, funcionario.getCidade());
        pst.setString(5, funcionario.getEndereco());
        pst.setString(6, funcionario.getNumero());
        pst.setString(7, funcionario.getComplemento());
        pst.setString(8, funcionario.getBairro());
        pst.setString(9, funcionario.getEmail());
        pst.setString(10, funcionario.getTelefone());
        pst.setString(11, funcionario.getCelular());
        pst.setDate(12, new java.sql.Date(funcionario.getData_nascimento().getTime()));
        pst.setString(13, funcionario.getRg());
        pst.setString(14, funcionario.getCpf());
        pst.setString(15, funcionario.getLogin());
        pst.setString(16, funcionario.getSenha());
        pst.setDate(17, new java.sql.Date(funcionario.getData_contratado().getTime()));
        pst.setDate(18, new java.sql.Date(funcionario.getData_demissao().getTime()));
        pst.setFloat(19, funcionario.getSalario());
        pst.setInt(20, funcionario.getCargo().getId_cargo());
        
        pst.execute();
        
        pst.close();
        ConexaoDAO.closeInstance();
        
    }
    
    public void alterar(Funcionario funcionario) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        String SQL;
        
        if (funcionario.getSenha() != null){
            SQL = "UPDATE funcionario SET nome_completo = ?, id_estado = ?, cep = ?, cidade = ? , endereco = ?,"
                    + "numero = ?, complemento = ?, bairro = ?, email = ?, telefone = ?, celular = ?, "
                    + "data_nascimento = ?, rg = ?, cpf = ?, login = ?, senha = ?, data_contratado = ?, "
                    + "data_demissao = ?, salario = ?, id_cargo = ? "
                    + "WHERE id_funcionario = ?";
            
            PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
            
            pst.setString(1, funcionario.getNome_completo());
            pst.setInt(2, funcionario.getEstado().getId_estado());
            pst.setString(3, funcionario.getCep());
            pst.setString(4, funcionario.getCidade());
            pst.setString(5, funcionario.getEndereco());
            pst.setString(6, funcionario.getNumero());
            pst.setString(7, funcionario.getComplemento());
            pst.setString(8, funcionario.getBairro());
            pst.setString(9, funcionario.getEmail());
            pst.setString(10, funcionario.getTelefone());
            pst.setString(11, funcionario.getCelular());
            pst.setDate(12, new java.sql.Date(funcionario.getData_nascimento().getTime()));
            pst.setString(13, funcionario.getRg());
            pst.setString(14, funcionario.getCpf());
            pst.setString(15, funcionario.getLogin());
            pst.setString(16, GerarHash.hash256(funcionario.getSenha()));
            pst.setDate(17, new java.sql.Date(funcionario.getData_contratado().getTime()));
            pst.setDate(18, (funcionario.getData_demissao() != null) ? new java.sql.Date(funcionario.getData_demissao().getTime()) : null);
            pst.setFloat(19, funcionario.getSalario());
            pst.setInt(20, funcionario.getCargo().getId_cargo());
            pst.setInt(21, funcionario.getId_funcionario());
            
            pst.execute();
            
            pst.close();
            ConexaoDAO.closeInstance();
            
        }else{
            SQL = "UPDATE funcionario SET nome_completo = ?, id_estado = ?, cep = ?, cidade = ? , endereco = ?,"
                    + "numero = ?, complemento = ?, bairro = ?, email = ?, telefone = ?, celular = ?, "
                    + "data_nascimento = ?, rg = ?, cpf = ?, login = ?, data_contratado = ?, "
                    + "data_demissao = ?, salario = ?, id_cargo = ? "
                    + "WHERE id_funcionario = ?";
            
            PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
            
            pst.setString(1, funcionario.getNome_completo());
            pst.setInt(2, funcionario.getEstado().getId_estado());
            pst.setString(3, funcionario.getCep());
            pst.setString(4, funcionario.getCidade());
            pst.setString(5, funcionario.getEndereco());
            pst.setString(6, funcionario.getNumero());
            pst.setString(7, funcionario.getComplemento());
            pst.setString(8, funcionario.getBairro());
            pst.setString(9, funcionario.getEmail());
            pst.setString(10, funcionario.getTelefone());
            pst.setString(11, funcionario.getCelular());
            pst.setDate(12, new java.sql.Date(funcionario.getData_nascimento().getTime()));
            pst.setString(13, funcionario.getRg());
            pst.setString(14, funcionario.getCpf());
            pst.setString(15, funcionario.getLogin());
            pst.setDate(16, new java.sql.Date(funcionario.getData_contratado().getTime()));
            pst.setDate(17, (funcionario.getData_demissao() != null) ? new java.sql.Date(funcionario.getData_demissao().getTime()) : null);
            pst.setFloat(18, funcionario.getSalario());
            pst.setInt(19, funcionario.getCargo().getId_cargo());
            pst.setInt(20, funcionario.getId_funcionario());
            
            pst.execute();
            
            pst.close();
            ConexaoDAO.closeInstance();
        }
    }
    
    public Funcionario buscar(Funcionario funcionario) throws SQLException{
        Funcionario retorno = new Funcionario();
        
        String SQL = "SELECT funcionario.id_funcionario, funcionario.nome_completo, estado.id_estado, estado.sigla, "
                + "estado.descricao, funcionario.cep, funcionario.cidade, funcionario.endereco, funcionario.numero, "
                + "funcionario.complemento, funcionario.bairro, funcionario.email, funcionario.telefone, "
                + "funcionario.celular, funcionario.data_nascimento, funcionario.rg, funcionario.cpf, "
                + "funcionario.login, funcionario.senha, funcionario.data_contratado, funcionario.data_demissao, "
                + "funcionario.salario, cargo.id_cargo, cargo.nome_cargo "
                + "FROM funcionario"
                + "INNER JOIN estado ON estado.id_estado = funcionario.id_estado "
                + "INNER JOIN cargo ON cargo.id_cargo = funcionario.id_cargo ";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()){
            retorno.setId_funcionario(rs.getInt("id_funcionario"));
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
            retorno.setLogin(rs.getString("login"));
            retorno.setSenha(rs.getString("senha"));
            retorno.setData_contratado(rs.getDate("data_contratado"));
            retorno.setData_demissao(rs.getDate("data_demissao"));
            retorno.setSalario(rs.getFloat("salario"));
            
            Cargo cargo = new Cargo();
            cargo.setId_cargo(rs.getInt("id_cargo"));
            cargo.setNome_cargo(rs.getString("nome_cargo"));
            
            retorno.setCargo(cargo);
        }
        
        rs.close();
        pst.close();
        ConexaoDAO.closeInstance();
        
        return retorno;
    }
    
    public boolean verificaCpfDuplicado(Funcionario funcionario) throws SQLException{
        String SQL = "SELECT funcionario.id_funcionario FROM funcionario WHERE funcionario.cpf = ?";
        
        //Editando cadastro
        if (funcionario.getId_funcionario() != 0){
            SQL += " AND id_funcionario != ?";
        }
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        if (funcionario.getId_funcionario() != 0){
            pst.setString(1, funcionario.getCpf());
            pst.setInt(2, funcionario.getId_funcionario());
        }else{
            pst.setString(1, funcionario.getCpf());
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
    
    public ArrayList<Funcionario> listaFuncionarioPesquisar(Funcionario funcionario) throws SQLException{
        ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        String SQL = "SELECT funcionario.id_funcionario, funcionario.nome_completo, funcionario.cep, "
                + "funcionario.cidade, funcionario.endereco, "
                + "funcionario.bairro, funcionario.rg, funcionario.cpf "
                + "FROM funcionario ";
                
        if (funcionario != null){
            if (funcionario.getId_funcionario() != 0){
                SQL += "WHERE id_funcionario = ?";
            }else if (funcionario.getNome_completo() != null){
                SQL += "WHERE nome_completo LIKE ?";
            }else if (funcionario.getCpf() != null){
                SQL += "WHERE cpf LIKE ?";
            }else if (funcionario.getRg() != null){
                SQL += "WHERE rg LIKE ?";
            }else if (funcionario.getCep() != null){
                SQL += "WHERE cep LIKE ?";
            }else if (funcionario.getCidade() != null){
                SQL += "WHERE cidade LIKE ?";
            }else if (funcionario.getEndereco() != null){
                SQL += "WHERE endereco LIKE ?";
            }else if (funcionario.getBairro() != null){
                SQL += "WHERE bairro LIKE ?";
            }
        }
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        if (funcionario != null){
            if (funcionario.getId_funcionario() != 0){
                pst.setInt(1, funcionario.getId_funcionario());
            }else if (funcionario.getNome_completo() != null){
                pst.setString(1, funcionario.getNome_completo() + "%");
            }else if (funcionario.getCpf() != null){
                pst.setString(1, funcionario.getCpf() + "%");
            }else if (funcionario.getRg() != null){
                pst.setString(1, funcionario.getRg() + "%");
            }else if (funcionario.getCep() != null){
                pst.setString(1, funcionario.getCep() + "%");
            }else if (funcionario.getCidade() != null){
                pst.setString(1, funcionario.getCidade() + "%");
            }else if (funcionario.getEndereco() != null){
                pst.setString(1, funcionario.getEndereco() + "%");
            }else if (funcionario.getBairro() != null){
                pst.setString(1, funcionario.getBairro() + "%");
            }
        }
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
            Funcionario funcionarioRetornado = new Funcionario();
            funcionarioRetornado.setId_funcionario(rs.getInt("id_funcionario"));
            funcionarioRetornado.setNome_completo(rs.getString("nome_completo"));
            funcionarioRetornado.setCep(rs.getString("cep"));
            funcionarioRetornado.setCidade(rs.getString("cidade"));
            funcionarioRetornado.setEndereco(rs.getString("endereco"));
            funcionarioRetornado.setBairro(rs.getString("bairro"));
            funcionarioRetornado.setRg(rs.getString("rg"));
            funcionarioRetornado.setCpf(rs.getString("cpf"));
            listaFuncionario.add(funcionarioRetornado);
        }
        
        pst.close();
        rs.close();
        ConexaoDAO.closeInstance();
        
        return listaFuncionario;
    }
    
}

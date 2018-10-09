package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Funcionario;

/**
 *
 * @author UEMERSON
 */
public class FuncionarioDAO {
    
    public void alterar(Funcionario funcionario) throws SQLException{
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
            pst.setString(16, funcionario.getSenha());
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
    
}

package dao;

import model.Funcionario;

/**
 *
 * @author UEMERSON
 */
public class FuncionarioDAO {
    
    public void alterar(Funcionario funcionario){
        String SQL;
        
        if (funcionario.getSenha() != null){
            SQL = "UPDATE funcionario SET nome_completo = ?, id_estado = ?, cep = ?, cidade = ? , endereco = ?,"
                    + "numero = ?, complemento = ?, bairro = ?, email = ?, telefone = ?, celular = ?, "
                    + "data_nascimento = ?, rg = ?, cpf = ?, login = ?, senha = ?, data_contratado = ?, "
                    + "data_demissao = ?, salario = ?, id_cargo = ? "
                    + "WHERE id_funcionario = ?";
        }else{
            SQL = "UPDATE funcionario SET nome_completo = ?, id_estado = ?, cep = ?, cidade = ? , endereco = ?,"
                    + "numero = ?, complemento = ?, bairro = ?, email = ?, telefone = ?, celular = ?, "
                    + "data_nascimento = ?, rg = ?, cpf = ?, login = ?, data_contratado = ?, "
                    + "data_demissao = ?, salario = ?, id_cargo = ? "
                    + "WHERE id_funcionario = ?";
        }
    }
    
}

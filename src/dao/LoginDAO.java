/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Funcionario;

/**
 *
 * @author gustavo
 */
public class LoginDAO {
    PreparedStatement pst;
    String sql;
    
    public Funcionario buscalogin (String login, String senha) throws SQLException{
        sql = "Select * from funcionario where login COLLATE utf8_bin =? and senha COLLATE utf8_bin =?";
        Funcionario funcionario = null;
        pst = ConexaoDAO.getInstance().prepareStatemente (sql);
        pst.setString (1, login);
        pst.setString (2, senha); 
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()){
            Funcionario = new funcionario (rs.getInt("codigo"), rs.getString("login"), rs. getString("senha"), rs.getString("tipo" ));
            
        
        return null;
        
    }
    
}

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cargo;

/**
 *
 * @author UEMERSON
 */
public class CargoDAO {
    public Cargo buscar(Cargo cargo) throws SQLException{
        String SQL = "SELECT id_cargo, nome_cargo FROM cargo WHERE cargo.id_cargo = ?";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        pst.setInt(1, cargo.getId_cargo());
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()){
            Cargo cargoRetorno = new Cargo();
            
            cargoRetorno.setId_cargo(rs.getInt("id_cargo"));
            cargoRetorno.setNome_cargo(rs.getString("nome_cargo"));
        }
        
        pst.close();
        rs.close();
        ConexaoDAO.closeInstance();
        
        return null;
    }
    
    public void inserir(Cargo cargo) throws SQLException{
        String SQL = "INSERT INTO cargo(nome_cargo) VALUES (?)";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        pst.setString(1, cargo.getNome_cargo());
        pst.execute();
        
        pst.close();
        ConexaoDAO.closeInstance();
    }

    public void excluir(Cargo cargo) throws SQLException{
        String SQL = "DELETE FROM cargo WHERE cargo.id_cargo = ?";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        pst.setInt(1, cargo.getId_cargo());
        pst.execute();
        pst.close();
        ConexaoDAO.closeInstance();
    }
    
    public void atualizar(Cargo cargo) throws SQLException{
        String SQL = "UPDATE cargo SET nome_cargo = ? WHERE id_cargo = ?";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        pst.setString(1, cargo.getNome_cargo());
        pst.setInt(2, cargo.getId_cargo());
        
        pst.close();
        ConexaoDAO.closeInstance();
    }
}

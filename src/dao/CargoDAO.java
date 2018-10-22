package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            
            pst.close();
            rs.close();
            ConexaoDAO.closeInstance();
            
            return cargoRetorno;
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
    
    public void alterar(Cargo cargo) throws SQLException{
        String SQL = "UPDATE cargo SET nome_cargo = ? WHERE id_cargo = ?";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        pst.setString(1, cargo.getNome_cargo());
        pst.setInt(2, cargo.getId_cargo());
        pst.execute();
        
        pst.close();
        ConexaoDAO.closeInstance();
    }

    public ArrayList<Cargo> listaCargo() throws SQLException{
        ArrayList<Cargo> retorno = new ArrayList<>();
        
        String SQL = "SELECT * FROM cargo ORDER BY nome_cargo ASC";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
            Cargo cargo = new Cargo();
            
            cargo.setId_cargo(rs.getInt("id_cargo"));
            cargo.setNome_cargo(rs.getString("nome_cargo"));
            retorno.add(cargo);
        }
        
        pst.close();
        rs.close();
        ConexaoDAO.closeInstance();
        
        return retorno;
    }

    public ArrayList<Cargo> listaCargoPesquisar(Cargo cargo) throws SQLException{
        ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
        
        String SQL = "SELECT cargo.id_cargo, cargo.nome_cargo "
                + "FROM cargo ORDER BY id_cargo ASC ";
                
        if (cargo != null){
            if (cargo.getId_cargo() != 0){
                SQL += "WHERE id_cargo = ?";
            }else if (cargo.getNome_cargo() != null){
                SQL += "WHERE nome_cargo LIKE ?";
            }
        }
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        
        if (cargo != null){
            if (cargo.getId_cargo() != 0){
                pst.setInt(1, cargo.getId_cargo());
            }else if (cargo.getNome_cargo() != null){
                pst.setString(1, cargo.getNome_cargo() + "%");
            }
        }
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
            Cargo cargoRetornado = new Cargo();
            cargoRetornado.setId_cargo(rs.getInt("id_cargo"));
            cargoRetornado.setNome_cargo(rs.getString("nome_cargo"));
            listaCargo.add(cargoRetornado);
        }
        
        pst.close();
        rs.close();
        ConexaoDAO.closeInstance();
        
        return listaCargo;
    }
}

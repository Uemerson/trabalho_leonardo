package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Estado;

/**
 *
 * @author UEMERSON
 */
public class EstadoDAO {
    public ArrayList<Estado> listaEstado() throws SQLException{
        
        ArrayList<Estado> retorno = new ArrayList<>();
        String SQL = "SELECT * FROM estado";
        
        PreparedStatement pst = ConexaoDAO.getInstance().prepareStatement(SQL);
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
            Estado estado = new Estado();
            
            estado.setId_estado(rs.getInt("id_estado"));
            estado.setDescricao(rs.getString("descricao"));
            estado.setSigla(rs.getString("sigla"));
            
            retorno.add(estado);
        }
        
        pst.close();
        rs.close();
        ConexaoDAO.closeInstance();
        
        return retorno;
    }
}

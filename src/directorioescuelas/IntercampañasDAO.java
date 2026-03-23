/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorioescuelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class IntercampañasDAO {
    
    public DefaultTableModel
    mostrarAsignaciones(){
        
    DefaultTableModel modelo = new
    DefaultTableModel();
    modelo.addColumn("id_campaña");
    modelo.addColumn("id_escuela");
    modelo.addColumn("Campaña");
    modelo.addColumn("Escuela");
    
    String sql = " SELECT ca.id_campaña, esc.id_escuela, ca.Nombre, esc.Nombre " + " FROM Escuela_campañas ecam " +
     " INNER JOIN Campañas ca ON ecam.id_campaña = ca.id_campaña " + 
     " INNER JOIN Escuela esc ON ecam.id_escuela = esc.id_escuela ";
    try {
        CConexion cc = new
        CConexion();
        Connection con =
        cc.establecerConexion();
        
        PreparedStatement ps =
        con.prepareStatement(sql);
        ResultSet rs =
        ps.executeQuery();
        
        while (rs.next()) {
            modelo.addRow(new Object[] {
            
            rs.getInt(1),
            rs.getInt(2),
            rs.getString(3),
            rs.getString(4)
                    });
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    return modelo;
    }
    
    public void eliminarAsignacion(int idCampaña, int idEscuela) {
        
        String sql = " DELETE FROM Escuela_campañas " + " WHERE id_campaña = ? AND id_escuela = ? ";
        
        try {
            CConexion cc = new 
            CConexion();
            Connection con = 
            cc.establecerConexion();
            PreparedStatement ps =
            con.prepareStatement(sql);
            ps.setInt(1, idCampaña);
            ps.setInt(2, idEscuela);
            
            ps.executeUpdate();
            
        } catch  (Exception e){
         JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());   
        }
    }
    
}

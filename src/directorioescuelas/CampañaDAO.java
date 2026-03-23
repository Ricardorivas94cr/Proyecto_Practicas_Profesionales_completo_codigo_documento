/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorioescuelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CampañaDAO {
    
public DefaultComboBoxModel<Campaña>
 cargarCampañas() {
     
     DefaultComboBoxModel<Campaña>
     modelo = new DefaultComboBoxModel<>();
     
     String sql = "SELECT id_campaña, Nombre FROM Campañas";
     
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
             modelo.addElement(
                     new Campaña(
         rs.getInt("id_campaña"),
         rs.getString("Nombre")
                     )
             );
         }
         } catch (Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage());
     }
     return modelo;
 }
}

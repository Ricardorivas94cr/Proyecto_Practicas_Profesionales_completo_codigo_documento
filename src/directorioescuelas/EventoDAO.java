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
public class EventoDAO {
    
 public DefaultComboBoxModel<Evento>
 cargarEventos() {
     
     DefaultComboBoxModel<Evento>
     modelo = new DefaultComboBoxModel<>();
     
     String sql = "SELECT id_evento, Nombre FROM Eventos_civicos";
     
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
                     new Evento(
         rs.getInt("id_evento"),
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

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
public class EscuelacampDAO {
  
  public DefaultTableModel
    buscarEscuelas(String texto) {
        
        DefaultTableModel modelo = new
        DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        
        String sql = " SELECT id_escuela,Nombre " + " FROM Escuela " + " WHERE Nombre LIKE ? COLLATE NOCASE ";
        
        try {
         CConexion cc = new
         CConexion();
         Connection con =
         cc.establecerConexion();
         PreparedStatement ps =
         con.prepareStatement(sql);
         ps.setString(1, "%" + texto.trim() + "%");
             
         ResultSet rs =
         ps.executeQuery();
         
         while (rs.next()){
             modelo.addRow(new Object[]{
             rs.getInt("id_escuela"),
             rs.getString("Nombre")
                     });
             
         }
         } catch (Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        if (texto == null || texto.trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "Escribe un nombre para buscar");
         }
        return modelo;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorioescuelas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CCampañas {
    
    
     public void MostrarCampañas(JTable TablaCampañas){

        CConexion objetoconexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        modelo.addColumn("Fecha inicio");
        modelo.addColumn("Fecha fin");
        modelo.addColumn("Nivel");
        
        TablaCampañas.setModel(modelo);
        
        sql= "SELECT * FROM Campañas";
        
        String[] datos = new String[6];
        Statement st;
        try {
            st= objetoconexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
            
                datos [0]= rs.getString(1);
                datos [1]= rs.getString(2);
                datos [2]= rs.getString(3);
                datos [3]= rs.getString(4);
                datos [4]= rs.getString(5);
                datos [5]= rs.getString(6);
                modelo.addRow(datos);
                
            }
            
            TablaCampañas.setModel(modelo);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar,"+ e.toString());
        }
        finally {
        objetoconexion.cerrarConexion();
        }
            
        }
     
     public void InsertarCampaña(JTextField Nombre, JTextField Descripcion, JTextField Fecha_inicio, JTextField Fecha_fin, JTextField Nivel){
        
         CConexion objetoConexion = new CConexion();
         
         String consulta = "insert into Campañas(Nombre,Descripcion,Fecha_inicio,Fecha_fin,Nivel) values (?,?,?,?,?);";
         
         try {
         PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(consulta);
         ps.setString(1, Nombre.getText());
         ps.setString(2, Descripcion.getText());
         ps.setString(3, Fecha_inicio.getText());
         ps.setString(4, Fecha_fin.getText());
         ps.setString(5, Nivel.getText());
         
         ps.execute();
         
         JOptionPane.showMessageDialog(null,"Se guardó Correctamente");
         } catch (Exception e){
         JOptionPane.showMessageDialog(null," No se guardó Correctamente"+ e.toString());
         }
         finally {
         objetoConexion.cerrarConexion();
         }
      
}

    public void SeleccionarCampaña(JTable tablacampañas,JTextField id_campaña,JTextField Nombre, JTextField Descripcion, JTextField Fecha_inicio, JTextField Fecha_fin, JTextField Nivel){
      
      
      try {
        int fila = tablacampañas.getSelectedRow();
        
        if (fila >=0){
        
            id_campaña.setText(tablacampañas.getValueAt(fila, 0).toString());
            Nombre.setText(tablacampañas.getValueAt(fila, 1).toString());
            Descripcion.setText(tablacampañas.getValueAt(fila, 2).toString());
            Fecha_inicio.setText(tablacampañas.getValueAt(fila, 3).toString());
            Fecha_fin.setText(tablacampañas.getValueAt(fila, 4).toString());
            Nivel.setText(tablacampañas.getValueAt(fila, 5).toString());
        }
        else {
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar");
        }
      } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de selección:"+ e.toString());
      }
      }
    
    public void EditarCampaña(JTextField id_campaña, JTextField Nombre, JTextField Descripcion, JTextField Fecha_inicio, JTextField Fecha_fin, JTextField Nivel){
        
         CConexion objetoConexion = new CConexion();
         
         String consulta = "UPDATE Campañas SET Nombre=?,Descripcion=?,Fecha_inicio=?,Fecha_fin=?,Nivel=? WHERE id_campaña=?;";
         
         try {
         PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(consulta);
         ps.setString(1, Nombre.getText());
         ps.setString(2, Descripcion.getText());
         ps.setString(3, Fecha_inicio.getText());
         ps.setString(4, Fecha_fin.getText());
         ps.setString(5, Nivel.getText());
         ps.setString(6, id_campaña.getText());
         
         ps.execute();
         
         JOptionPane.showMessageDialog(null,"Se edito Correctamente");
         } catch (Exception e){
         JOptionPane.showMessageDialog(null," No se edito Correctamente"+ e.toString());
         }
         finally {
         objetoConexion.cerrarConexion();
         }
      
}
    
    public void EliminarCampaña(JTextField id_campaña){
        
         CConexion objetoConexion = new CConexion();
         
         String consulta = "DELETE FROM Campañas WHERE id_campaña=?;";
         
         try {
         PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(consulta);
         ps.setString(1, id_campaña.getText());
         
         ps.execute();
         
         JOptionPane.showMessageDialog(null,"Se eliminó Correctamente");
         } catch (Exception e){
         JOptionPane.showMessageDialog(null," No se eliminó Correctamente"+ e.toString());
         }
         finally {
         objetoConexion.cerrarConexion();
         }
      
}
    
    public void LimpiarCampos(JTextField id_campaña, JTextField Nombre, JTextField Descripcion, JTextField Fecha_inicio, JTextField Fecha_fin, JTextField Nivel){
        
        id_campaña.setText("");
        Nombre.setText("");
        Descripcion.setText("");
        Fecha_inicio.setText("");
        Fecha_fin.setText("");
        Nivel.setText("");
        }
    
}

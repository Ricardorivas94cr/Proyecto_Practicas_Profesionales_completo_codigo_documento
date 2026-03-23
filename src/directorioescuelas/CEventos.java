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

public class CEventos {
    
     public void MostrarEventos(JTable TablaEventos){

        CConexion objetoconexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        modelo.addColumn("ID_Evento");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        modelo.addColumn("Fecha");
        
        TablaEventos.setModel(modelo);
        
        sql= "SELECT * FROM Eventos_civicos";
        
        String[] datos = new String[4];
        Statement st;
        try {
            st= objetoconexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
            
                datos [0]= rs.getString(1);
                datos [1]= rs.getString(2);
                datos [2]= rs.getString(3);
                datos [3]= rs.getString(4);
                modelo.addRow(datos);
                
            }
            
            TablaEventos.setModel(modelo);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar,"+ e.toString());
        }
        finally {
        objetoconexion.cerrarConexion();
        }
            
        }
     
     public void InsertarEvento(JTextField Nombre, JTextField Descripcion, JTextField Fecha){
        
         CConexion objetoConexion = new CConexion();
         
         String consulta = "insert into Eventos_civicos(Nombre,Descripcion,Fecha) values (?,?,?);";
         
         try {
         PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(consulta);
         ps.setString(1, Nombre.getText());
         ps.setString(2, Descripcion.getText());
         ps.setString(3, Fecha.getText());
         
         ps.execute();
         
         JOptionPane.showMessageDialog(null,"Se guardó Correctamente");
         } catch (Exception e){
         JOptionPane.showMessageDialog(null," No se guardó Correctamente"+ e.toString());
         }
         finally {
         objetoConexion.cerrarConexion();
         }
      
}
     
      public void SeleccionarEvento(JTable tablaeventos,JTextField id,JTextField Nombre, JTextField Descripcion, JTextField Fecha){
      
      
      try {
        int fila = tablaeventos.getSelectedRow();
        
        if (fila >=0){
        
            id.setText(tablaeventos.getValueAt(fila, 0).toString());
            Nombre.setText(tablaeventos.getValueAt(fila, 1).toString());
            Descripcion.setText(tablaeventos.getValueAt(fila, 2).toString());
            Fecha.setText(tablaeventos.getValueAt(fila, 3).toString());
        }
        else {
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar");
        }
      } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de selección:"+ e.toString());
      }
      }
      
       public void EditarEvento(JTextField id_eventos, JTextField Nombre, JTextField Descripcion, JTextField Fecha){
        
         CConexion objetoConexion = new CConexion();
         
         String consulta = "UPDATE Eventos_civicos SET Nombre=?,Descripcion=?,Fecha=? WHERE id_evento=?;";
         
         try {
         PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(consulta);
         ps.setString(1, Nombre.getText());
         ps.setString(2, Descripcion.getText());
         ps.setString(3, Fecha.getText());
         ps.setString(4, id_eventos.getText());
             
         ps.execute();
         
         JOptionPane.showMessageDialog(null,"Se edito Correctamente");
         } catch (Exception e){
         JOptionPane.showMessageDialog(null," No se edito Correctamente"+ e.toString());
         }
         finally {
         objetoConexion.cerrarConexion();
         }
      
}
       
        public void EliminarEvento(JTextField id_evento){
        
         CConexion objetoConexion = new CConexion();
         
         String consulta = "DELETE FROM Eventos_civicos WHERE id_evento=?;";
         
         try {
         PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(consulta);
         ps.setString(1, id_evento.getText());
         
         ps.execute();
         
         JOptionPane.showMessageDialog(null,"Se eliminó Correctamente");
         } catch (Exception e){
         JOptionPane.showMessageDialog(null," No se eliminó Correctamente"+ e.toString());
         }
         finally {
         objetoConexion.cerrarConexion();
         }
      
}
        
        public void LimpiarCampos(JTextField id_evento, JTextField Nombre, JTextField Descripcion, JTextField Fecha){
        
        id_evento.setText("");
        Nombre.setText("");
        Descripcion.setText("");
        Fecha.setText("");
        }
    
        
}

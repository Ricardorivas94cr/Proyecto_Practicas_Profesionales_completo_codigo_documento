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


public class CEscuelas {
    
    public void MostrarEscuelas(JTable TablaEscuelas){

        CConexion objetoconexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Dirección");
        modelo.addColumn("Télefono");
        modelo.addColumn("Matrícula");
        modelo.addColumn("Nivel");
        modelo.addColumn("Zona");
        
        TablaEscuelas.setModel(modelo);
        
        sql= "SELECT * FROM Escuela";
        
        String[] datos = new String[7];
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
                datos [6]= rs.getString(7);
                
                modelo.addRow(datos);
                
            }
            
            TablaEscuelas.setModel(modelo);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar,"+ e.toString());
        }
        finally {
        objetoconexion.cerrarConexion();
        }
            
        }
      public void InsertarEscuela(JTextField Nombre, JTextField Dirección, JTextField Teléfono, JTextField Matrícula, JTextField Nivel, JTextField Zona){
        
         CConexion objetoConexion = new CConexion();
         
         String consulta = "insert into Escuela(Nombre,Dirección,Télefono,Matrícula,Nivel,Zona) values (?,?,?,?,?,?);";
         
         try {
         PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(consulta);
         ps.setString(1, Nombre.getText());
         ps.setString(2, Dirección.getText());
         ps.setString(3, Teléfono.getText());
         ps.setString(4, Matrícula.getText());
         ps.setString(5, Nivel.getText());
         ps.setString(6, Zona.getText());
         
         ps.execute();
         
         JOptionPane.showMessageDialog(null,"Se guardó Correctamente");
         } catch (Exception e){
         JOptionPane.showMessageDialog(null," No se guardó Correctamente"+ e.toString());
         }
         finally {
         objetoConexion.cerrarConexion();
         }
      
}
    
      
      public void SeleccionarEscuela(JTable tablaescuelas,JTextField id,JTextField Nombre, JTextField Dirección, JTextField Teléfono, JTextField Matrícula, JTextField Nivel, JTextField Zona){
      
      
      try {
        int fila = tablaescuelas.getSelectedRow();
        
        if (fila >=0){
        
            id.setText(tablaescuelas.getValueAt(fila, 0).toString());
            Nombre.setText(tablaescuelas.getValueAt(fila, 1).toString());
            Dirección.setText(tablaescuelas.getValueAt(fila, 2).toString());
            Teléfono.setText(tablaescuelas.getValueAt(fila, 3).toString());
            Matrícula.setText(tablaescuelas.getValueAt(fila, 4).toString());
            Nivel.setText(tablaescuelas.getValueAt(fila, 5).toString());
            Zona.setText(tablaescuelas.getValueAt(fila, 6).toString());
        }
        else {
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar");
        }
      } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de selección:"+ e.toString());
      }
      }
      
       public void EditarEscuela(JTextField id_escuela, JTextField Nombre, JTextField Dirección, JTextField Teléfono, JTextField Matrícula, JTextField Nivel, JTextField Zona){
        
         CConexion objetoConexion = new CConexion();
         
         String consulta = "UPDATE Escuela SET Nombre=?,Dirección=?,Télefono=?,Matrícula=?,Nivel=?,Zona=? WHERE id_escuela=?;";
         
         try {
         PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(consulta);
         ps.setString(1, Nombre.getText());
         ps.setString(2, Dirección.getText());
         ps.setString(3, Teléfono.getText());
         ps.setString(4, Matrícula.getText());
         ps.setString(5, Nivel.getText());
         ps.setString(6, Zona.getText());
         ps.setString(7, id_escuela.getText());
         
         ps.execute();
         
         JOptionPane.showMessageDialog(null,"Se edito Correctamente");
         } catch (Exception e){
         JOptionPane.showMessageDialog(null," No se edito Correctamente"+ e.toString());
         }
         finally {
         objetoConexion.cerrarConexion();
         }
      
}
       
        public void EliminarEscuela(JTextField id_escuela){
        
         CConexion objetoConexion = new CConexion();
         
         String consulta = "DELETE FROM Escuela WHERE id_escuela=?;";
         
         try {
         PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(consulta);
         ps.setString(1, id_escuela.getText());
         
         ps.execute();
         
         JOptionPane.showMessageDialog(null,"Se eliminó Correctamente");
         } catch (Exception e){
         JOptionPane.showMessageDialog(null," No se eliminó Correctamente"+ e.toString());
         }
         finally {
         objetoConexion.cerrarConexion();
         }
      
}
        
        public void LimpiarCampos(JTextField id_escuela, JTextField Nombre, JTextField Dirección, JTextField Teléfono, JTextField Matrícula, JTextField Nivel, JTextField Zona){
        
        id_escuela.setText("");
        Nombre.setText("");
        Dirección.setText("");
        Teléfono.setText("");
        Matrícula.setText("");
        Nivel.setText("");
        Zona.setText("");
        }
}

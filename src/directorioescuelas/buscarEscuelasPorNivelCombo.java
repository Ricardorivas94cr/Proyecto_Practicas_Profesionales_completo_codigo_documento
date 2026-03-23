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
public class buscarEscuelasPorNivelCombo {

public DefaultTableModel buscarPorNivel(String nivel){

DefaultTableModel modelo = new
DefaultTableModel();
modelo.addColumn("ID");
modelo.addColumn("Nombre");
modelo.addColumn("Direccion");
modelo.addColumn("Telefono");
modelo.addColumn("Matricula");
modelo.addColumn("Nivel");
modelo.addColumn("Zona");

try {
CConexion cc = new CConexion();
Connection con =
cc.establecerConexion();

String sql;
PreparedStatement ps;
if (nivel.equals("Todos")){
sql = " SELECT id_escuela, Nombre, Dirección, Télefono, Matrícula, Nivel, Zona FROM Escuela ";
ps = con.prepareStatement(sql);
}
else {
sql = " SELECT id_escuela, Nombre, Dirección, Télefono, Matrícula, Nivel, Zona FROM Escuela WHERE Nivel = ? ";
ps =
con.prepareStatement(sql);
ps.setString(1, nivel);
}

ResultSet rs = ps.executeQuery();

while (rs.next()){
Object[] fila = new 
Object[7];

fila[0] =
rs.getInt("id_escuela");
fila[1] =
rs.getString("Nombre");
fila[2] =
rs.getString("Dirección");
fila[3] =
rs.getString("Télefono");
fila[4] =
rs.getString("Matrícula");
fila[5] =
rs.getString("Nivel");
fila[6] =
rs.getString("Zona");
modelo.addRow(fila);
}
} catch (Exception e){
JOptionPane.showMessageDialog(null,"Error al buscar; " + e.getMessage());
}
return modelo;
}
}

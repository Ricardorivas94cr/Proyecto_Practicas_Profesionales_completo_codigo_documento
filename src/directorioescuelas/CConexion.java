
package directorioescuelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class CConexion {
    
    Connection conectar = null;
    
    String bd = "Directorio_Escuelas.db";
    
    String cadena = "jdbc:sqlite:"+ System.getProperty("user.dir")+"/"+bd;
    
    public Connection establecerConexion(){
        
        Connection conectar = null;
        
        try {
         
        Class.forName("org.sqlite.JDBC");
        conectar = DriverManager.getConnection(cadena);
        try (Statement stmt = conectar.createStatement()){
        stmt.execute("PRAGMA foreign_keys = ON");
        
        }
        //JOptionPane.showMessageDialog(null, " Se conectó correctamente");
        } catch (Exception e){
        JOptionPane.showMessageDialog(null, " No se conectó correctamente, error:"+ e.toString());    
        }
        
        return conectar;
        
        }
    
    public void cerrarConexion(){
        
        try {
            
            if (conectar != null){
                conectar.close();
               JOptionPane.showMessageDialog(null, " Se cerró la conexión correctamente"); 
            }
        } catch (Exception e){
         JOptionPane.showMessageDialog(null, " No se cerró correctamente, error:"+ e.toString());   
        }
    }

        
}

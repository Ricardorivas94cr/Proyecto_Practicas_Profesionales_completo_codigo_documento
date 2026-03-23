

package directorioescuelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class InterEventosDAO {
    
    public DefaultTableModel
    mostrarAsignaciones(){
        
    DefaultTableModel modelo = new
    DefaultTableModel();
    modelo.addColumn("id_evento");
    modelo.addColumn("id_escuela");
    modelo.addColumn("Evento");
    modelo.addColumn("Escuela");
    
    String sql = " SELECT ev.id_evento, es.id_escuela, ev.Nombre, es.Nombre " + " FROM Escuela_eventos ee " +
     " INNER JOIN Eventos_civicos ev ON ee.id_evento = ev.id_evento " + 
     " INNER JOIN Escuela es ON ee.id_escuela = es.id_escuela ";
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
    
    public void eliminarAsignacion(int idEvento, int idEscuela) {
        
        String sql = " DELETE FROM Escuela_eventos " + " WHERE id_evento = ? AND id_escuela = ? ";
        
        try {
            CConexion cc = new 
            CConexion();
            Connection con = 
            cc.establecerConexion();
            PreparedStatement ps =
            con.prepareStatement(sql);
            ps.setInt(1, idEvento);
            ps.setInt(2, idEscuela);
            
            ps.executeUpdate();
            
        } catch  (Exception e){
         JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());   
        }
    }
}

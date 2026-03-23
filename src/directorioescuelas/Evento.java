
package directorioescuelas;


public class Evento {
   
    private int idEvento;
    private String nombreEvento;
    
    public Evento(int idEvento, String nombreEvento){
    this.idEvento = idEvento;
    this.nombreEvento = nombreEvento;
    }
    
    public int getIdEvento(){
    return idEvento;
    }
    
    @Override
    public String toString(){
    return nombreEvento;
    }
}

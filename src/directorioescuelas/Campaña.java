/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorioescuelas;

/**
 *
 * @author Administrador
 */
public class Campaña {
    
    private int idCampaña;
    private String nombreCampaña;
    
    public Campaña(int idCampaña, String nombreCampaña){
    this.idCampaña = idCampaña;
    this.nombreCampaña = nombreCampaña;
    }
    
    public int getIdCampaña(){
    return idCampaña;
    }
    
    @Override
    public String toString(){
    return nombreCampaña;
    }
}

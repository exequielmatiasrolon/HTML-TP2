/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;


public class MedioPago implements Serializable{
        
    Usuario Usuario;
    String NroTarjeta;
    String NombreTitular;
    String Fehavenc;
    int CodSeguridad;  
    
    
     public int GetCodSeguridad() {
        return CodSeguridad;
    }

    public void SetCodigoSeguridad(int CodSeguridad) {
        this.CodSeguridad = CodSeguridad;
    }
    
    public Usuario GetUsuario(){
        return Usuario;
    }
    
    public void SetUsuario(Usuario usuario){
        this.Usuario= Usuario;
    }
    
    public String GetNroTarjeta(){
        return NroTarjeta;
    }
    public void SetNroTarjeta(String NroTarjeta){
        this.NroTarjeta=NroTarjeta;
    }
    
    public String getFechavenc(){
        return Fehavenc;
    }
    public void  setFechaVenc(String FechaVenc){
        this.Fehavenc=FechaVenc;
    }
    
      public String getNombreTitular(){
        return NombreTitular;
    }
    public void  setNombreTitular(String NombreTitular){
        this.NombreTitular=NombreTitular;
    }
     
    
    
}

 
    


    
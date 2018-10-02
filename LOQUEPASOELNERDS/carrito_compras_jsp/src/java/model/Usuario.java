/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

/**
 *
 * @author cgallardo
 */
public class Usuario implements Serializable{
    private int id;
    private int dni;
    private String nombre;
    private String email;

    public int getId() {
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getDni(){
        return dni;
    }
    
    public void setDni(Integer dni){
        this.dni = dni;
    }
    
}

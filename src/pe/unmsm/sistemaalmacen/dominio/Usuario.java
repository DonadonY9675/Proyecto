/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.dominio;

/**
 *
 * @author Josecarlos
 */
public class Usuario {
    private String nombre;
    private String contrasenia;
    private boolean esAdmin;

    public Usuario(String nombre, String contrasenia, boolean esAdmin) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.esAdmin = esAdmin;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String toString(){
        return "Nombre: "+nombre+" Es admin: "+esAdmin;
    }
}

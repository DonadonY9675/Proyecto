/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.dominio;

import java.sql.Blob;

/**
 *
 * @author Miguel
 */
public class Configuracion {

    //BORRAR CUANDO DEJE DE SER NECESARIO
    private String logo;
    
    private String nombreEmpresa;
    private String RUC;
    private String direccion;
    private double IGV;
    private Blob imagen;

    public Configuracion(String logo, String nombreEmpresa, String RUC, String direccion, double IGV, Blob imagen) {
        this.logo = logo;
        this.nombreEmpresa = nombreEmpresa;
        this.RUC = RUC;
        this.direccion = direccion;
        this.IGV = IGV;
        this.imagen = imagen;
    }

    public Configuracion(String logo, String nombreEmpresa, String RUC, String direccion, double IGV) {
        this.logo = logo;
        this.nombreEmpresa = nombreEmpresa;
        this.RUC = RUC;
        this.direccion = direccion;
        this.IGV = IGV;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getIGV() {
        return IGV;
    }

    public void setIGV(double IGV) {
        this.IGV = IGV;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    
}

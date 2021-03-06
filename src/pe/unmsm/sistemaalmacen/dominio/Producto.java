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
public class Producto {

    private int codigo;
    private String nombre;
    private String marca;
    private String modelo;
    private Categoria cat;
    private String unidadDeMedida;
    private String ubicacion;
    private float cantidadMinima;
    private float existencia;
    private float precioUnitario;
    private Blob imagen;
    //private  imagen;

    public Producto(int codigo) {
        this.codigo = codigo;
    }

    public Producto(int codigo, String nombre, String marca, String modelo,
            String unidadDeMedida, String ubicacion,
            float cantidadMinima, float existencia, float precioUnitario) {
        
        this(codigo,nombre,marca,modelo,null,unidadDeMedida,ubicacion,
                cantidadMinima,existencia,precioUnitario,null);
    }

    public Producto(int codigo, String nombre, String marca, String modelo,
            Categoria cat, String unidadDeMedida, String ubicacion,
            float cantidadMinima,float existencia, float precioUnitario,
            Blob imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.cat = cat;
        this.unidadDeMedida = unidadDeMedida;
        this.ubicacion = ubicacion;
        this.cantidadMinima = cantidadMinima;
        this.existencia = existencia;
        this.precioUnitario = precioUnitario;
        this.imagen = imagen;
    }

    public Producto(int codigo, String nombre, String marca, String modelo, Categoria cat, String unidadDeMedida, String ubicacion, float cantidadMinima, float existencia, float precioUnitario) {
        this(codigo,nombre,marca,modelo,cat,unidadDeMedida,ubicacion,
                cantidadMinima,existencia,precioUnitario,null);
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(float cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public float getExistencia() {
        return existencia;
    }

    public void setExistencia(float existencia) {
        this.existencia = existencia;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", marca=" + marca + ", modelo=" + modelo+", cateloria=" + cat + ", unidadDeMedida=" + unidadDeMedida + ", ubicacion=" + ubicacion + ", cantidadMinima=" + cantidadMinima + ", existencia=" + existencia + ", precioUnitario=" + precioUnitario + '}';
    }
    
}

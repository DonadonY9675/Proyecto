/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;


public class ListaDoble<T> {

    NodoDoble<T> cabecera;

   

    class NodoDoble<T> {
        NodoDoble<T> sig;
        NodoDoble<T> ant;
        T dato;

        public NodoDoble(T dato) {
            this.dato = dato;
        }

    }
    
    public ListaDoble() {
        this.cabecera = null;
    }
    
    public NodoDoble<T> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoDoble<T> cabecera) {
        this.cabecera = cabecera;
    }
    
    public void insertarAlInicio(T nuevo) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(nuevo);
        nuevoNodo.sig = cabecera;
        if (cabecera != null) {
            cabecera.ant = nuevoNodo;
        }
        cabecera = nuevoNodo;
    }

    @Override
    public String toString() {
        String cadena = "";
        NodoDoble<T> aux = cabecera;
        while (aux != null) {
            cadena += aux.dato + ", ";
            aux = aux.sig;
        }
        return cadena;
    }
    
    public void eliminar (int pos) {
        
    }

     public void insertarAlFinal(T nuevo) {
        
    }
     
     public T buscar(int pos){
         T nuevo=null;
         
         return nuevo;
     }
}

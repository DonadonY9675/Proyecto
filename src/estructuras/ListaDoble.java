
package estructuras;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author
 */
public class ListaDoble<T> implements Iterable<T> {

    private NodoDoble<T> cabecera;
    private NodoDoble<T> ultimo;
    Comparator<T> comparador;
    
    @Override
    public Iterator<T> iterator() {
        return new MiIteradorAscendente();
    }

    private class NodoDoble<T> {

        T dato;
        NodoDoble<T> sig, ant;

        NodoDoble(T dato) {
            this.dato = dato;
            sig = null;
            ant = null;
        }
    }

    public NodoDoble<T> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoDoble<T> cabecera) {
        this.cabecera = cabecera;
    }

    public Comparator<T> getComparador() {
        return comparador;
    }

    public void setComparador(Comparator<T> comparador) {
        this.comparador = comparador;
    }
    
    private class MiIteradorAscendente implements Iterator<T> {

        NodoDoble<T> aux;

        public MiIteradorAscendente() {
            aux = cabecera;
        }

        @Override
        public boolean hasNext() {
            return aux != null;
        }

        @Override
        public T next() {
            T datoG = aux.dato;
            aux = aux.sig;
            return datoG;
        }

    }
    
    /*
        Recorre la lista comenzando del ultimo elemento y finalizando en el primero
    */
    private class MiIteradorDescendente implements Iterator<T> {

        NodoDoble<T> aux;

        public MiIteradorDescendente() {
            aux = ultimo;
        }

        @Override
        public boolean hasNext() {
            return aux != null;
        }

        @Override
        public T next() {
            T datoG = aux.dato;
            aux = aux.ant;
            return datoG;
        }
        
    }
    
    public void insertarAlInicio(T nuevo) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(nuevo);
        nuevoNodo.sig = cabecera;

        if (cabecera != null) {
            cabecera.ant = nuevoNodo;
        }else{
            ultimo = nuevoNodo;
        }
        cabecera = nuevoNodo;
    }
    
    public void insertarAlFinal(T nuevo){
        NodoDoble<T> nuevoNodo = new NodoDoble<>(nuevo);
        nuevoNodo.ant = ultimo;

        if (cabecera != null) {
            ultimo.sig = nuevoNodo;
        }else{
            cabecera = nuevoNodo;
        }
        ultimo = nuevoNodo;
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

    private void intercambiar(NodoDoble<T> i, NodoDoble<T> j) {

        T aux = i.dato;
        i.dato = j.dato;
        j.dato = aux;
    }

    /*
    Metodo que ordena la lista doble usando el metodo QuickSort
    */
    public void ordenar() {
        reducirQuick(cabecera,ultimo);
    }
    
    private void reducirQuick(NodoDoble inicio, NodoDoble fin){
        NodoDoble izq = inicio;
        NodoDoble der = fin;
        NodoDoble pivote = inicio;
        
        
        while(izq!=der){
            while(izq!=pivote && comparador.compare((T) izq.dato,(T) pivote.dato)<0){
                izq = izq.sig;
            }
            while(der!=pivote && comparador.compare((T) izq.dato,(T) pivote.dato)>0){
                der=der.ant;
            }
            intercambiar(izq,der);
            
            if(pivote==izq){
                pivote=der;
            }else if(pivote==der){
                pivote=izq;
            }
        }
        
        if(inicio!=pivote){
            reducirQuick(inicio, pivote.ant);
        }
        if(fin!=pivote){
            reducirQuick(pivote.sig, fin);
        }
    }
    
    public T buscar(int identificador){
        return null;
    }
    
    public void eliminar(int identificador){
        
    }
}

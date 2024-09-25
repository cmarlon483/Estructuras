package fes.aragon.dinamico;

public class Nodo <E> {

    private E dato ;
    private Nodo siguiente;

    public Nodo(E dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Nodo(E dato) {
        this(dato,null);
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

package fes.aragon.dinamico;

public class Nodo <E> {

    private E Dato ;
    private Nodo siguiente;

    public Nodo() {
        Dato = dato;
        this.siguiente = siguiente;
    }

    public E getDato() {
        return Dato;
    }

    public void setDato(E dato) {
        Dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

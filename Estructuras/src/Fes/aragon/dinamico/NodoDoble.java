package Fes.aragon.dinamico;

public class NodoDoble <E>{
    private E dato ;
    private NodoDoble adelante;
    private NodoDoble anterior;

    public NodoDoble (E dato, NodoDoble adelante, NodoDoble anterior) {
        this.dato = dato;
        this.adelante = adelante;
        this.anterior = anterior;
    }
    public NodoDoble(E dato) {this(dato, null, null);}

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return adelante;
    }

    public void setSiguiente(NodoDoble adelante) {
        this.adelante = adelante;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}

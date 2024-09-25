package fes.aragon.dinamico;

public class NodoDoble <E>{
    private E dato ;
    private NodoDoble adelante;
    private NodoDoble atras;

    public NodoDoble (E dato, NodoDoble adelante, NodoDoble atras) {
        this.dato = dato;
        this.adelante = adelante;
        this.atras = atras;
    }
    public NodoDoble(E dato) {this(dato, null, null);}

    public E getdato() {
        return dato;
    }

    public void setdato(E dato) {
        dato = dato;
    }

    public NodoDoble getadelante() {
        return adelante;
    }

    public void setAdelante(NodoDoble adelante) {
        this.adelante = adelante;
    }

    public NodoDoble getatras() {
        return atras;
    }

    public void setatras(NodoDoble atras) {
        this.atras = atras;
    }
}


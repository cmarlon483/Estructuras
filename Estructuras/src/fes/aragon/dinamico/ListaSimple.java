package fes.aragon.dinamico;

public class ListaSimple {
    Nodo Cabeza= new Nodo();
    Nodo Cola= new Nodo();

    public ListaSimple() {
        Cabeza = null;
        Cola = null;
    }
    public void InsertarNodo{
        Nodo nuevo= new Nodo();
        if (Cabeza==null){
            Cabeza=nuevo;
            Cabeza.getSiguiente()=null;
            Cola=nuevo;
        }else {
            Cola.getSiguiente()=nuevo;
            nuevo.getSiguiente()=null;
            Cola=nuevo;
        }

    }
}

package fes.aragon.dinamico;

public class ListaDoble <E>{
    private NodoDoble <E> cabeza;
    private NodoDoble <E> cola;
    private int longitud=0;


    //Insertar un Elemento en la cabeza de una lista doble

    public ListaDoble isenrtarCabezalista(dato){
        nuevo = new NodoDoble(dato);
        nuevo.adelante = cabeza;
        if (cabeza != null){
            cabeza.atras= nuevo;
            cabeza=nuevo;
            return this;
        }
    }

    //Insertar despues de un nodo

    public ListaDoble insertarDespuesNodo(nodo anterior, elemento entrada){
        nodo nuevo;
        nuevo = new nodo(entrada);
        nuevo.adelante = anterior.adelante;
        if (anterior.adelante != null);
        anterior.adelante.atras = nuevo;
        anterior.adelante = nuevo;
        nuevo.atras = anterior;
        return this;
    }
    //Eliminar elemento de una lista doblemente enlazada
    public void eliminar(elemento entrada){
        NodoDoble actual;
        boolean encontrado = false;
        actual = cabeza;
        // Bulce de busqueda
        while ((actual != null) && (!encontrado)){
            //la comparacion se realiza con el metodo equals
            encontrado = (actual.dato == entrada);
            if (!encontrado)
                actual = actual.adelante;
        }
        //Enlace de nodo anterior con el siguiente
        if (actual != null){
            //Distinge entre nodo, cabeza o el resto de la lista
            if (actual==cabeza){
                cabeza=actual.adelante;
                if (actual.adelante() != null);
                actual.adelante.atras = null;
            }
            else if (actual.adelante != null){
                actual.atras.adelante = actual.adelante;
                actual.adelante.atras = actual.atras;
            }
            else //ultimo nodo
            actual.atras.adelante = null;
            actual = null;
        }
    }
}

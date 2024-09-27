package Fes.aragon.dinamico;

import Fes.aragon.excepcion.IndiceFueraDeRango;

public class ListaDoble <E> {

    protected NodoDoble<E> cabeza;
    protected NodoDoble<E> cola;
    protected int longitud = 0;


    public void agregarEnCabeza(E dato){
        if(cabeza == null){
            cola = new NodoDoble<E>( dato, null, null);
            cabeza = cola;
        } else{
            NodoDoble<E> nuevo = new NodoDoble<E>(dato, cabeza, null);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }
        longitud++;
    }

    public void agregarEnCola(E dato){
        if(cabeza == null){
            cabeza = new NodoDoble<E>( dato, null, null);
            cola = cabeza;
        } else{
            NodoDoble<E> nuevo = new NodoDoble<E>(dato, cola, null);
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
        longitud++;
    }

    public void eliminarEnCabeza(){
        cabeza = cabeza.getSiguiente();
        longitud--;
    }

    public void eliminarEnCola(){
        if(longitud == 1){
            cola = cabeza = null;
        }else{
            NodoDoble <E> tmp = null;
                tmp = indiceActual(longitud - 2);
            tmp.setSiguiente(null);
            cola = tmp;
        }
        longitud --;
    }

    public void eliminarEnIndice(int i){
            if(indiceActual(i).equals(cabeza)){
                cabeza = cabeza.getSiguiente();
                cola.setSiguiente(cabeza);
                cabeza.setAnterior(cola);

            } else if (indiceActual(i).equals(cola)) {
                cola = cola.getAnterior();
                cabeza.setAnterior(cola);
                cola.setSiguiente(cabeza);
            }else{
                indiceActual(i).getAnterior().setSiguiente(indiceActual(i).getSiguiente());
                indiceActual(i).getSiguiente().setAnterior(indiceActual(i).getAnterior());
            }
        longitud--;
    }

    public E obtenerNodoDoble(int i){
            return indiceActual(i).getDato();
    }

    public int estaEnLista(E dato){
        int indice = 0;
        for (NodoDoble<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
            if(tmp.getDato().equals(dato)){
                return indice;
            }
            indice ++;
        }
        return -1;
    }

    public void insertarEnIndice(E dato, int i){
        if(indiceActual(i)==null){
            System.out.println("indice fuera de rango");
        }else {
            NodoDoble<E> tempNodo =new NodoDoble<>(dato,indiceActual(i), indiceActual(i).getAnterior());
            indiceActual(i).setAnterior(tempNodo); indiceActual(i-1).setSiguiente(tempNodo);
            longitud++;
        }
    }

    public void asignar1(E dato, int i){
            indiceActual(i).setDato(dato);
    }

    public void asignar(E dato, E nuevoDato, boolean b){
        if(b == true){
            int indice = 0;
            for (NodoDoble<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
                if(tmp.getDato().equals(dato)){
                    tmp.setDato(nuevoDato);
                }
                indice ++;
            }
        }else{
            int indice = 0;
            if(estaEnLista(dato) != -1){
                indice = estaEnLista(dato);
                asignar1(nuevoDato,indice);
            }

        }
    }

    public Boolean esVacia(){
        return longitud == 0;
    }

    public int getLongitud() {
        return longitud;
    }

    public void imprimirLista() {
        int contador = 0;
        NodoDoble<E> tmp = cabeza;
        if (tmp.getSiguiente() != null) {
            while (contador < longitud ) {
                System.out.println(tmp.getDato());
                tmp = tmp.getSiguiente();
                contador++;
            }
        }else{
            while (contador < longitud) {
                System.out.println(tmp.getDato());
                tmp = tmp.getAnterior();
                contador++;
            }
        }

    }

    protected NodoDoble<E> indiceActual(int i)  {
            NodoDoble aux = cabeza;
            for (int actual = 0; actual < i; actual++){
                aux = aux.getSiguiente();
            }
            return  aux;
        }
}



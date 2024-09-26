package fes.aragon.dinamico;
import fes.aragon.excepcion.IndiceFueraDeRango;

public class ListaSimple <E> {
    private Nodo cabeza;
    private Nodo cola;
    private int longitud= 0;

    //Obtener un indice a cada nodo

    protected Nodo indice(int i){
        Nodo aux = cabeza;
        for (int actual = 0; actual < i; actual++){
            aux = aux.getSiguiente();
        }
        return  aux;
    }

    //Constructor
    public ListaSimple(Nodo cabeza, Nodo cola, int longitud) {
        cabeza = cabeza;
        cola = cola;
        this.longitud = longitud;
    }

    //Metodo para obtener la longitud de la  lista

    public int getlongitud(){
        return this.longitud;
    }

    //Metodo que devuelve true si la lista es vacia, si no un falso

    public boolean esVacia(){
        return cabeza==null;
    }

    //Metodo para eliminar nodo de la cabeza

    public void eliminarCabeza(){
        if(longitud==1){
            cabeza=cola=null;
        }else {
            cabeza=cabeza.getSiguiente();
        }
    }

    //Metodo para eliminar el nodo de la cola

    public void EliminarEnCola(){
        if(longitud==1){
            cabeza=cola=null;
        }else {
           Nodo<E> ante = indice(longitud-2);
           ante.setSiguiente(null);
           cola=ante;
           longitud--;
        }
    }

    //Metodo que devuelve el valor de indice i
    public E obtenerNodo(int i) throws IndiceFueraDeRango {
        Nodo<E> actual = cabeza;
        int contador = 0;

        // Recorremos la lista hasta el índice deseado
        while (actual != null && contador < i) {
            actual = actual.getSiguiente();
            contador++;
        }

        // Si 'actual' es null, el índice es inválido
        if (actual == null) {
            throw new IndiceFueraDeRango ("Índice fuera de los límites.");
        }

        return actual.getDato();
    }

    //Metodo que devuelve el indice i si esta el elemento en la lista en dato x,
    // en caso contrario un -1
    public int estaEnLista (E dato) {
        Nodo<E> actual = cabeza;
        int indice = 0;

        // Se recorre la lista hasta encontrar el elemento o llegar al final
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return indice; // Retorna el índice si se encuentra el elemento
            }
            actual = actual.getSiguiente();
            indice++;
        }
        // Si el elemento no se encuentra, se retorna -1
        return -1;
    

    }

    //Metodo que Elimina el nodo de acuerdo al índice,
    // devuelve un true si lo elimino en caso contrario devuelve un false
    public boolean eliminarEnIndice (int i){
        if (i < 0 || cabeza == null) {
            return false; // Índice inválido o lista vacía
        }

        // Si el índice es 0, se elimina la cabeza de la lista y se le asigna al siguiente nodo
        if (i == 0) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        Nodo<E> actual = cabeza;
        int contador = 0;

        // Se recorre la lista hasta encontrar el nodo anterior al que queremos eliminar
        while (actual != null && contador < i - 1) {
            actual = actual.getSiguiente();
            contador++;
        }

        // Si el nodo siguiente es null, significa que el índice es mayor que el tamaño de la lista
        if (actual == null || actual.getSiguiente() == null) {
            return false;
        }

        // El nodo siguiente es el que queremos eliminar, así que lo saltamos
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        return true;

    }

    //Metodo que inserta el dato en el indice indicado
    public boolean insertarEnIndice (int i, E dato){
        if (i < 0) {
            return false; // Índice inválido
        }

        // Si el índice es 0, insertamos al inicio de la lista
        if (i == 0) {
            Nodo<E> nuevoNodo = new Nodo<>(dato);
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
            return true;
        }

        Nodo<E> actual = cabeza;
        int contador = 0;

        // Se recorre la lista hasta encontrar el nodo en índice i-1
        while (actual != null && contador < i - 1) {
            actual = actual.getSiguiente();
            contador++;
        }

        // Si llegamos al final de la lista antes de llegar al índice, retornamos false
        if (actual == null) {
            return false;
        }

        // Insertamos el nuevo nodo en la posición indicada
        Nodo<E> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);

        return true;

    }

    //Metodo que cambia el dato en el Indice indicado
    public boolean asignar(int i, E nuevoDato){
        if (i < 0 || cabeza == null) {
            return false; // Índice inválido o lista vacía
        }

        Nodo<E> actual = cabeza;
        int contador = 0;

        // Se recorrre la lista hasta llegar al índice indicado
        while (actual != null && contador < i) {
            actual = actual.getSiguiente();
            contador++;
        }

        // Si se llega al final de la lista antes de llegar al índice, se retorna false
        if (actual == null) {
            return false;
        }

        // Se asigna el nuevo valor al nodo en la posición indicado
        actual.setDato(nuevoDato);
        return true;

    }

    //Metodo que cambia en la primera ocurrencia el dato con el nuevo dato,
    // si el boolean es true,
    // cambiara todos los datos de la lista simple,
    // si es falso solo cambia el primero que se encuentre
    public boolean asignarR(E datoActual, E nuevoDato, boolean cambiarTodos){
        if (cabeza == null) {
            return false; // Lista vacía
        }

        Nodo<E> actual = cabeza;
        boolean encontrado = false;

        // Recorremos la lista buscando el dato actual
        while (actual != null) {
            if (actual.getDato().equals(datoActual)) {
                actual.setDato(nuevoDato); // Se cambia el dato
                encontrado = true;

                if (!cambiarTodos) {
                    return true; // Si no queremos cambiar todos, salimos tras cambiar el primero
                }
            }
            actual = actual.getSiguiente();
        }

        return encontrado; // Retorna true si encontró al menos una ocurrencia
    }


}

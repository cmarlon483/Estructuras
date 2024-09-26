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
    //@return true si la lista está vacía (cabeza es null), false en caso contrario.

    public boolean esVacia(){
        return cabeza==null;
    }

    //Metodo para eliminar nodo de la cabeza
    //Nota: Este método no reduce la longitud de la lista. Debe controlarse fuera de este método.
    public void eliminarCabeza(){
        if(longitud==1){
            cabeza=cola=null;
        }else {
            cabeza=cabeza.getSiguiente();
        }
    }

    //Metodo para eliminar el nodo de la cola
    //@param i El índice del nodo que se desea obtener (comienza en 0).
    //@return El dato almacenado en el nodo en la posición 'i'.
    // @throws IndiceFueraDeRango Si el índice está fuera de los límites de la lista.

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
    /*@param i El índice del nodo que se desea obtener (comienza en 0).
    @return El dato almacenado en el nodo en la posición 'i'.
    @throws IndiceFueraDeRango Si el índice está fuera de los límites de la lista.
    */
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
    /*
    @param dato El elemento que se desea buscar en la lista.
    @return El índice del elemento si se encuentra en la lista; -1 si no está presente.
    */
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
    /*
    @param i El índice del nodo que se desea eliminar (comienza en 0).
    @return true si se elimina el nodo correctamente; false si el índice es inválido o no se encuentra el nodo.
    */
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
    /*
    @param i El índice donde se desea insertar el nuevo nodo (comienza en 0).
    @param dato El dato que se desea almacenar en el nuevo nodo.
    @return true si se inserta el nodo correctamente; false si el índice es inválido.
    */
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
    /*
    @param i El índice del nodo cuyo dato se desea modificar (comienza en 0).
    @param nuevoDato El nuevo dato que se desea asignar al nodo.
    @return true si se asigna el nuevo dato correctamente; false si el índice es inválido.
    */
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
    /*@param datoActual El dato que se desea modificar en los nodos.
    @param nuevoDato El nuevo dato que se asignará en lugar del datoActual.
    @param cambiarTodos Indica si se deben cambiar todas las ocurrencias (true) o solo la primera (false).
    @return true si al menos una ocurrencia fue modificada; false si la lista está vacía.
    
    */
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

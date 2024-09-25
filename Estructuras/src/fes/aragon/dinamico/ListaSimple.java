package fes.aragon.dinamico;


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

    public E obtenerNodo(int indice){
        E dato = (E) indice(indice).getDato();
        return dato;
    }

    //Metodo que devuelve el indice i si esta el elemento en la lista en dato x,
    // en caso contrario un -1
    public E estaEnLista(int indice) {

    }

    //Metodo que Elimina el nodo de acuerdo al índice,
    // devuelve un true si lo elimino en caso contrario devuelve un false
    public void eliminarEnIndice(){

    }

    //Metodo que inserta el dato en el indice indicado
    public void InsertarEnIndice(){

    }

    //Metodo que cambia el dato en el Indice indicado
    public void asignar(){

    }

    //Metodo que cambia en la primera ocurrencia el dato con el nuevo dato,
    // si el boolean es true,
    // cambiara todos los datos de la lista simple,
    // si es falso solo cambia el primero que se encuentre
    public void asignarR(){

    }
}

package fes.aragon.estatico;

import fes.aragon.excepcion.IndiceFueraDeRango;

//Clase que tiene funciones para ocupar arreglos de tipo Integer
public class Arreglo<E> {
    private int indice= 0;
    private final Object[] l;

    public Arreglo(int numeroElementos) {
        this.l = new Object[numeroElementos];
    }

    /* 1- Método que inserta un valor de tipo Integer consecutivo
    @param x es el parametro que se recibe para agregar a  la lista
    @throws IndiceFueraDeRango excepcion que pasa cuando nos salimos fuera del indice
    */

    public void insertar(E x) throws IndiceFueraDeRango{
        if(indice < l.length){
            l[indice] = x;
            indice++;
        } else {
            throw new IndiceFueraDeRango("Indice fuera de rango");
        }
    }

    /* 2- Metodo que localiza un valor en la lista, retornan el indice
    * @param x valor Integer que se busca en la lista
    * @return se retorna -l si no esta el vlaor de la lista, en caso contrario se retorna el indice
    * */

    public Integer localiza(E x){
        for (int i =0; i < l.length; i++){
            if(l[i].equals(x)){
                return i;
            }
        }
        return -1;
    }

    /* 3- Metodo que recupera un elemento en el indice indicado
    *
    * @param p entero que indica el indice del elemento a devolver
    * @return E que se retorna, tomando la posicion siguiente que se da como parametro
    * @throws IndiceFueraDeRango excepcion que s earrpja cuando el indice p esta fuera de los rangos del arreglo
    *
    /* */

    public E recupera(int p) throws Exception /*throws IndiceFueraDeRango*/{
        if(p > l.length || p < 0){
            throw new Exception("Indice fuera del rango");
        } else {
            @SuppressWarnings("unchecked")
            final E e = (E)l[p];
            return e;
        }
    }

    /* 4- Metodo que elimina un elemento en el indice indicado
    *
    * @param p entero que indica el indice del elemento a devolver
    * @throws IndiceFueraDeRango excepcion que s earrpja cuando el indice p esta fuera de los rangos del arreglo
    * */

    public void suprime(int p) throws IndiceFueraDeRango{
        if(p > l.length || p < 0){
            throw new IndiceFueraDeRango("Indice fuera del rango");
        } else {
            l[p] = null;
        }
    }

    /* 5- Método que devuelve el valor siguiente del indice indicado
     *
     * @param p entero que indica el indice del elemento a devolver
     * @return E que es el valor en la siguiente posición al índice dado
     * @throws IndiceFueraDeRango excepción que se arroja cuando el índice p está fuera de los rangos del arreglo
     */

    public E siguiente(int p) throws IndiceFueraDeRango {
        if (p > l.length || p < 0) {
            throw new IndiceFueraDeRango("Indice fuera del rango");
        } else {
            @SuppressWarnings("unchecked")
            final E e = (E) l[p + 1];
            return e;
        }
    }

    /* 6- Método que devuelve el valor anterior del indice indicado
     *
     * @param p entero que indica el indice del elemento a devolver
     * @return E que es el valor en la posición anterior al índice dado
     * @throws IndiceFueraDeRango excepción que se arroja cuando el índice p está fuera de los rangos del arreglo
     */

    public E anterior(int p) throws IndiceFueraDeRango {
        if (p > l.length || p < 0) {
            throw new IndiceFueraDeRango("Indice fuera del rango");
        } else {
            @SuppressWarnings("unchecked")
            final E e = (E) l[p - 1];
            return e;
        }
    }


    /* 7- Método que limpia el arreglo */
    public void limpiar() {
        for (int i = 0; i < l.length; i++) {
            l[i] = null;
        }
        indice = 0;  // Reiniciar el índice
    }

    /* 8- Método que devuelve el primer elemento del arreglo */
    public E primero() throws Exception {
        if (l.length == 0 || l[0] == null) {
            throw new Exception("El arreglo está vacío");
        }
        @SuppressWarnings("unchecked")
        final E e = (E) l[0];
        return e;
    }

    /* 9- Método que imprime los elementos del arreglo */
    public void imprimir() {
        for (int i = 0; i < l.length; i++) {
            if (l[i] != null) {
                System.out.println(l[i]);
            }
        }
    }

    /* 10- Método que asigna un valor en el indice indicado */
    public void asignar(int p, E valor) throws Exception {
        if (p >= l.length || p < 0) {
            throw new Exception("Indice fuera del rango");
        } else {
            l[p] = valor;
        }
    }
}

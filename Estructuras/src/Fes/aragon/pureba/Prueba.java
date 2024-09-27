package Fes.aragon.pureba;

import Fes.aragon.dinamico.ListaDoble;
import Fes.aragon.dinamico.ListaSimple;
import Fes.aragon.excepcion.IndiceFueraDeRango;

public class Prueba {
    public static void main(String[] args) throws IndiceFueraDeRango {
        ListaSimple<Integer> listaSimple=new ListaSimple<>();

        listaSimple.agregarEnCabeza(45);
        listaSimple.agregarEnCabeza(15);
        listaSimple.agregarEnCabeza(45);
        listaSimple.agregarEnCabeza(74);
        listaSimple.agregarEnCabeza(32);
        listaSimple.agregarEnCola(54);


        listaSimple.imprimirLista();
        System.out.println("_____________");
        listaSimple.asignarR(45,98,true);
        listaSimple.imprimirLista();
    }
}

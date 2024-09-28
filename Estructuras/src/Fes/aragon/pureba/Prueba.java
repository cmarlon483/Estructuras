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


       //Test 1
//        listaSimple.imprimirLista();
//        System.out.println("_____________");
//        for (int i = 0; i < listaSimple.getlongitud(); i++) {
//            if(listaSimple.obtenerNodo(i)%2==0){
//                    listaSimple.eliminarEnIndice(i);
//                    i--;
//            }
//        }
//        listaSimple.imprimirLista();

        //test 2
        for (int i = 0; i< listaSimple.getlongitud(); i++){
            if (listaSimple.obtenerNodo(i)%2 != 0){
                listaSimple.asignar(listaSimple.obtenerNodo(i)*50,i);
            }
        }
        listaSimple.imprimirLista();

        //test 3
        System.out.println("-------------");
        System.out.println("TEST 3");
        for (int i= 0; i< listaSimple.getlongitud(); i++){
            if (listaSimple.obtenerNodo(i)%2 == 0){
                listaSimple.asignar(100, i);
            }
        }
        listaSimple.imprimirLista();

        //test 4
        System.out.println("-------------");
        System.out.println("TEST 4");

        for (int i= 0; i< listaSimple.getlongitud(); i++){
            if (listaSimple.obtenerNodo(i)%2 != 0){
                listaSimple.asignar(50,i);
            }
        }
        listaSimple.imprimirLista();

        //test 5
        System.out.println("-------------");
        System.out.println("TEST 5");

        for (int i = 0; i < listaSimple.getlongitud(); i++){
            if (listaSimple.obtenerNodo(i) == 100){
                listaSimple.eliminarEnIndice(i);
                i--;
            }
        }
        listaSimple.imprimirLista();
   }
}

package fes.aragon.dinamico;

import fes.aragon.estatico.Arreglo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Operacion {
    public static void main(String[] args){
        try {
            File file = new File(System.getProperty("user.dir") + "/src/fes/aragon/archivo/Salida");
            FileReader reader = new FileReader(file);
            BufferedReader buff = new BufferedReader(reader);

            //ARREGLOS
            Arreglo<String> arregloDatos = new Arreglo<>(302);
            Arreglo<Integer> arregloNumeros = new Arreglo<>(302);

            //VARIABLES DE APOYO
            int numeroOperacion = 0;
            double sumatoria = 0;

            //INSERTAMOS LOS DATOS EN UN ARREGLO
            for (int i = 0; i < 300; i++) {
                arregloDatos.insertar(buff.readLine());
                arregloDatos.siguiente(i);
            }
            System.out.println("Los datos del archivo son: ");
            arregloDatos.imprimir();

            System.out.println();
            //TRANSFORMAMOS EL ARREGLO A INTEGERS
            for (int i = 0; i < 300; i++) {
                    arregloNumeros.insertar(Integer.parseInt(arregloDatos.recupera(i)));
            }

            //NUMERO MAYOR (300)
            for (int i = 0; i < 300; i++) {
                if (numeroOperacion < arregloNumeros.recupera(i)) {
                        numeroOperacion = arregloNumeros.recupera(i);
                }
            }
            System.out.println("El numero mayor es: " + numeroOperacion);

            //NUMERO MENOR (2)
            for (int i = 0; i < 300; i++) {
                if (numeroOperacion > arregloNumeros.recupera(i)) {
                    numeroOperacion = arregloNumeros.recupera(i);
                }
            }
            System.out.println("El numero menor es: " + numeroOperacion);

            //SUMA DE NUMEROS
            for (int i = 0; i < 300; i++) {
                sumatoria += arregloNumeros.recupera(i);
            }
            System.out.println("La suma de los numeros es: " + sumatoria);

            //PROMEDIO
            sumatoria = sumatoria / 300;
            System.out.println("El promedio es: " + sumatoria);

            buff.close();
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
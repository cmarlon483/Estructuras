package fes.aragon.dinamico;

import fes.aragon.estatico.Arreglo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class OperacionDos {
    public static void main(String[] args){
        try {
            File file = new File(System.getProperty("user.dir") + "/src/fes/aragon/archivo/Datos");
            FileReader reader = new FileReader(file);
            BufferedReader buff = new BufferedReader(reader);

            //ARREGLOS
            Arreglo<String> arregloDatos = new Arreglo<>(300);
            Arreglo<Integer> arregloNumeros = new Arreglo<>(300);

            //VARIABLES DE APOYO
            String[] arregloApoyo;
            String linea;
            int numeroOperacion = 0;
            double sumatoria = 0;

            //INSERTAMOS LOS DATOS EN UN ARREGLO
            linea = buff.readLine();
            if (linea != null){ //HACEMOS LA LECTURA DEL ARCHIVO
                arregloApoyo = linea.split(",");
                for (String valor : arregloApoyo){
                    arregloDatos.insertar(valor);
                   // arregloDatos.siguiente(Integer.parseInt(valor));
                }
                System.out.println("Los datos del archivo son: ");
                arregloDatos.imprimir(); //IMPRIMIMOS SUS DATOS
            }else {
                System.out.println("null");
            }

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

            //SUMA DE NUMEROS (45 880)
            for (int i = 0; i < 300; i++) {
                sumatoria += arregloNumeros.recupera(i);
            }
            System.out.println("La suma de los numeros es: " + sumatoria);

            //PROMEDIO (152.933333)
            sumatoria = sumatoria / 300;
            System.out.println("El promedio es: " + sumatoria);

            buff.close();
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
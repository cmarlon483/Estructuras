package fes.aragon.dinamico;

import fes.aragon.estatico.Arreglo;
import fes.aragon.excepcion.IndiceFueraDeRango;

import java.io.*;

public class Lectura {
    public static void main(String[] args){
        try {
            File file = new File(System.getProperty("user.dir") + "/src/fes/aragon/archivo/Salida");
            FileReader reader = new FileReader(file);
            BufferedReader buff = new BufferedReader(reader);

            Arreglo<String> arreglo = new Arreglo<>(302);
            //String datos;

            try {
                for (int i = 0; i < 300; i++) {
                    arreglo.insertar(buff.readLine());
                    //arreglo.recupera(i);
                    arreglo.siguiente(i);
                    arreglo.imprimir();
                    arreglo.limpiar();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            buff.close();
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
package fes.aragon.archivo;

import java.io.*;

public class Formato {
    public static void main(String[] args) {
        File entrada = new File(System.getProperty("user.dir") + "/src/fes/aragon/archivo/Datos");
        File salida = new File(System.getProperty("user.dir") + "/src/fes/aragon/archivo/Salida");
        String linea;
        try {
            FileReader readerInput = new FileReader(entrada);
            FileWriter writerOutput = new FileWriter(salida);
            BufferedReader buffReader = new BufferedReader(readerInput);
            BufferedWriter buffWriter = new BufferedWriter(writerOutput);

            linea = buffReader.readLine();
            if (linea != null) {
                String[] valores = linea.split(",");
                for (String valor : valores) {
                    buffWriter.write(valor);
                    buffWriter.newLine();
                }
            }

            System.out.println("Archivo cambiado y guardado en " + salida);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
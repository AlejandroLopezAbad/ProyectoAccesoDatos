package Meteo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LectorCSV {
    public static final String SEPARADOR = ";";
    //public static final char COMILLAS = '"';

    public void leerFichero(String uri) {
        BufferedReader bufferLectura = null;
        try {
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader(uri));

            // Leer una linea del archivo
            String linea = bufferLectura.readLine();
            String csvfiltrado= "";
            while (linea != null) {
                //hay que cambiar luego por la variable
                if(linea.matches(".*28005002.*")) {
                    csvfiltrado=csvfiltrado+linea+"\n";
                    // Sepapar la linea leída con el separador definido previamente
                    String[] campos = linea.split(SEPARADOR);
                   // campos[4]   con esto guardo las columnas que quiero que se mapeen par aguardar los datos
                }


              //  System.out.println(Arrays.toString(campos));
              //  System.out.println(Arrays.toString(campos));

                // Volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
            System.out.println(csvfiltrado);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cierro el buffer de lectura
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}




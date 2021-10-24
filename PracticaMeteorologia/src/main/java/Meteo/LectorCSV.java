package Meteo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {

    RegistroMunicipios registro = new RegistroMunicipios();

    Municipio muni = new Municipio();

    public List<Municipio> leerFichero(String uri, String CodigoMunicipio) {
        BufferedReader bufferLectura = null;
        try {
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader(uri));

            // Leer una linea del archivo
            String linea = bufferLectura.readLine();
            String csvfiltrado = "";

            for (int i = 0; i < linea.length(); i++) {

                if (linea.matches("28;" + CodigoMunicipio + ".*")) {
                    csvfiltrado = csvfiltrado + linea + "\n";

                }
                linea = bufferLectura.readLine();
                muni.setCodigoMunicipio(csvfiltrado);
                registro.listaMunicipios.add(muni);
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
        return registro.listaMunicipios;
    }

}




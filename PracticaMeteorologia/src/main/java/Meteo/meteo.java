package Meteo;

import java.io.File;


public class meteo {

    public static void main(String[] args) {
        String INPUT_CSV_datos_mes = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Datos" + File.separator + "calidad_aire_datos_mes.csv";
        String INPUT_CSV_datos_meteo_mes = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Datos" + File.separator + "calidad_aire_datos_meteo_mes.csv";
        String INPUT_CSV_estaciones = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Datos" + File.separator + "calidad_aire_estaciones.csv";
        String INPUT_CSV_zonas = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Datos" + File.separator + "calidad_aire_zonas.csv";

        System.out.println(INPUT_CSV_datos_mes);
        System.out.println(INPUT_CSV_datos_meteo_mes);
        System.out.println(INPUT_CSV_estaciones);
        System.out.println(INPUT_CSV_zonas);

        LectorCSV lector = new LectorCSV();
        lector.leerFichero(INPUT_CSV_estaciones);


    }
}



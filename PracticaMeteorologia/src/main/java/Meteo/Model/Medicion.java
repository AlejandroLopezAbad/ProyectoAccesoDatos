package Meteo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * Clase medicion en la cual ibamos a fusionar los datos de los otros dos xml junto con las mediciones de MAX MIN y MED para crear el otro XML
 */
public class Medicion {
    private String provincia;
    private String municipio;
    private String estacion;
    private int magnitud;
    private String puntoMuestreo;
    private int anio;
    private int mes;
    private int dia;
    private List<Double> mediciones;


}

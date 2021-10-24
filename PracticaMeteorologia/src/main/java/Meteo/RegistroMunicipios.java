package Meteo;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RegistroMunicipios {
    List<Municipio> listaMunicipios = new ArrayList<>();


    List<Municipio> registrar(String uri) {
        return listaMunicipios.stream().map(s -> uri.split(";")).map(splitted -> {
            String estacion = splitted[2];
            String magnitud = splitted[3];
            String puntoMuestreo = splitted[4];
            return new Municipio(estacion, magnitud, puntoMuestreo);
        }).collect(Collectors.toList());
    }





}

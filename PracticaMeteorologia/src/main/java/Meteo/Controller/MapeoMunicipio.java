package Meteo.Controller;

import java.util.HashMap;

/**
 * Clase mapeo que sirve para enlazar los codigos con los municipios
 */
public class MapeoMunicipio {
    public HashMap<String, String> mapearCiudadCodigo() {
        HashMap<String, String> mapeo = new HashMap<>();
        mapeo.put("alcaladehenares", "28005002");
        mapeo.put("alcobendas", "28006004");
        mapeo.put("alcorcón", "28007004");
        mapeo.put("algete", "28009001");
        mapeo.put("aranjuez", "28013002");
        mapeo.put("argandadelrey", "28014002");
        mapeo.put("elatazar", "28016001");
        mapeo.put("colmenarviejo", "28045002");
        mapeo.put("colladovillalba", "28047002");
        mapeo.put("coslada", "28049003");
        mapeo.put("fuenlabrada", "28058004");
        mapeo.put("getafe", "28065014");
        mapeo.put("guadalixdelasierra", "28067001");
        mapeo.put("leganes", "28074007");
        mapeo.put("majadahonda", "28080003");
        mapeo.put("mostoles", "28092005");
        mapeo.put("oruscodetajuna", "28102001");
        mapeo.put("puertodecotos", "28120001");
        mapeo.put("rivasvaciamadrid", "28123002");
        mapeo.put("sanmartindevaldeiglesias", "28133002");
        mapeo.put("torrejondeardoz", "28148004");
        mapeo.put("valdemoro", "28161001");
        mapeo.put("villadelprado", "28171001");
        mapeo.put("villarejodesalvanes", "28180001");
        return mapeo;
    }

}

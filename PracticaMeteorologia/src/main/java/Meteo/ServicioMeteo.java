package Meteo;

import java.util.ArrayList;
import java.util.List;

public class ServicioMeteo {

    private List<Municipio> listaDatos;

    public ServicioMeteo() {
        listaDatos = new ArrayList<>();
    }

    public List<Municipio> getListaDatos() {
        return listaDatos;
    }



}

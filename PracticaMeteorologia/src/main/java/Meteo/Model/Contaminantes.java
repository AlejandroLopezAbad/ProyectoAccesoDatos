package Meteo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "contaminantes")
@XmlType(propOrder = {
        "provincia",
        "municipio",
        "estacion",
        "magnitud",
        "puntoMuestreo",
        "ano",
        "mes",
        "dia",
        "h1","h2","h3","h4","h5","h6","h7","h8","h9","h10","h11","h12","h13","h14","h15","h16","h17","h18","h19","h20","h21","h22","h23","h24",
        "v1","v2","v3","v4","v5","v6","v7","v8","v9","v10","v11","v12","v13","v14","v15","v16","v17","v18","v19","v20","v21","v22","v23","v24"

})

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contaminantes {
    private int provincia,municipio,estacion,magnitud;
    private String puntoMuestreo;
    private int ano,mes,dia;
    private double h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12,h13,h14,h15,h16,h17,h18,h19,h20,h21,h22,h23,h24;
    private String v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22,v23,v24;

    public Contaminantes(int provincia, int municipio, int estacion, int magnitud, String puntoMuestreo, int año, int mes, int dia, double h1, String v1, double h2, String v2, double h3, String v3, double h4, String v4, double h5, String v5, double h6, String v6, double h7, String v7, double h8, String v8, double h9, String v9, double h10, String v10, double h11, String v11, double h12, String v12, double h13, String v13, double h14, String v14, double h15, String v15, double h16, String v16, double h17, String v17, double h18, String v18, double h19, String v19, double h20, String v20, double h21, String v21, double h22, String v22, double h23, String v23, double h24, String v24) {
    }

    @Override
    public String toString() {
        return "contaminantes{" +
                "provincia=" + provincia +
                ", municipio=" + municipio +
                ", estacion=" + estacion +
                ", magnitud=" + magnitud +
                ", puntoMuestreo='" + puntoMuestreo + '\'' +
                ", ano=" + ano +
                ", mes=" + mes +
                ", dia=" + dia +
                ", h1=" + h1 +
                ", h2=" + h2 +
                ", h3=" + h3 +
                ", h4=" + h4 +
                ", h5=" + h5 +
                ", h6=" + h6 +
                ", h7=" + h7 +
                ", h8=" + h8 +
                ", h9=" + h9 +
                ", h10=" + h10 +
                ", h11=" + h11 +
                ", h12=" + h12 +
                ", h13=" + h13 +
                ", h14=" + h14 +
                ", h15=" + h15 +
                ", h16=" + h16 +
                ", h17=" + h17 +
                ", h18=" + h18 +
                ", h19=" + h19 +
                ", h20=" + h20 +
                ", h21=" + h21 +
                ", h22=" + h22 +
                ", h23=" + h23 +
                ", h24=" + h24 +
                ", v1='" + v1 + '\'' +
                ", v2='" + v2 + '\'' +
                ", v3='" + v3 + '\'' +
                ", v4='" + v4 + '\'' +
                ", v5='" + v5 + '\'' +
                ", v6='" + v6 + '\'' +
                ", v7='" + v7 + '\'' +
                ", v8='" + v8 + '\'' +
                ", v9='" + v9 + '\'' +
                ", v10='" + v10 + '\'' +
                ", v11='" + v11 + '\'' +
                ", v12='" + v12 + '\'' +
                ", v13='" + v13 + '\'' +
                ", v14='" + v14 + '\'' +
                ", v15='" + v15 + '\'' +
                ", v16='" + v16 + '\'' +
                ", v17='" + v17 + '\'' +
                ", v18='" + v18 + '\'' +
                ", v19='" + v19 + '\'' +
                ", v20='" + v20 + '\'' +
                ", v21='" + v21 + '\'' +
                ", v22='" + v22 + '\'' +
                ", v23='" + v23 + '\'' +
                ", v24='" + v24 + '\'' +
                '}';
    }
}

package Meteo;

import lombok.*;

@Data
public class Municipio {

       // private String provincia;
        private String codigoMunicipio;
        private String estacion;
        private String magnitud;
        private String puntoMuestreo;
        private int año,mes,dia;
        private int concentracionMedida;
        private char validarHora;

    public Municipio(String estacion, String magnitud, String puntoMuestreo) {
        this.estacion= estacion;
        this.magnitud=magnitud;
        this.puntoMuestreo= puntoMuestreo;
    }

    public Municipio( String codigoMunicipio, String estacion, String magnitud, String puntoMuestreo, int año, int mes, int dia, int concentracionMedida, char validarHora) {
                //this.provincia = provincia;
                this.codigoMunicipio = codigoMunicipio;
                this.estacion = estacion;
                this.magnitud = magnitud;
                this.puntoMuestreo = puntoMuestreo;
                this.año = año;
                this.mes = mes;
                this.dia = dia;
                this.concentracionMedida = concentracionMedida;
                this.validarHora = validarHora;
        }

    public Municipio() {

    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public String getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(String magnitud) {
        this.magnitud = magnitud;
    }

    public String getPuntoMuestreo() {
        return puntoMuestreo;
    }

    public void setPuntoMuestreo(String puntoMuestreo) {
        this.puntoMuestreo = puntoMuestreo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getConcentracionMedida() {
        return concentracionMedida;
    }

    public void setConcentracionMedida(int concentracionMedida) {
        this.concentracionMedida = concentracionMedida;
    }

    public char getValidarHora() {
        return validarHora;
    }

    public void setValidarHora(char validarHora) {
        this.validarHora = validarHora;
    }
}

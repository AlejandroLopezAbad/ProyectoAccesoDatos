package Meteo.Controller;

import Meteo.Model.Contaminantes;
import Meteo.Model.Medicion;
import Meteo.Model.Temperatura;
import lombok.NonNull;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorXML {

    private static LectorXML controller;
    private String uri;
    private Document data;


    private LectorXML(String uri) {
        this.uri = uri;
    }

    public static LectorXML getInstance(@NonNull String uri) {
        if (controller == null) {
            controller = new LectorXML(uri);
        }
        return controller;
    }

    public void loadData() throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(this.uri);
        this.data = (Document) builder.build(xmlFile);
    }

    /**
     * Cargamos el XML en una lista de objetos Temperatura
     * @return listatemperaturas
     */
    public List<Temperatura> getTemperatura() {
        // Tomamos el elemento raiz y obtenemos sus hijos
        Element root = (Element) this.data.getRootElement();
        List<Element> listaMediciones = root.getChildren("medicion");

        List<Temperatura> listatemperaturas = new ArrayList<>();

        // Por cada elemento
        listaMediciones.forEach(elemento -> {

                Temperatura temp = new Temperatura();
                temp.setProvincia(Integer.parseInt(elemento.getChildText("provincia")));
                temp.setMunicipio(Integer.parseInt(elemento.getChildText("municipio")));
                temp.setEstacion(Integer.parseInt(elemento.getChildText("estacion")));
                temp.setMagnitud(Integer.parseInt(elemento.getChildText("magnitud")));
                temp.setPuntoMuestreo(elemento.getChildText("puntoMuestreo"));
                temp.setAño(Integer.parseInt(elemento.getChildText("anio")));
                temp.setMes(Integer.parseInt(elemento.getChildText("mes")));
                temp.setDia(Integer.parseInt(elemento.getChildText("dia")));
                temp.setH1(Double.parseDouble(elemento.getChildText("h1")));
                temp.setV1(elemento.getChildText("v1"));
                temp.setH2(Double.parseDouble(elemento.getChildText("h2")));
                temp.setV2(elemento.getChildText("v2"));
                temp.setH3(Double.parseDouble(elemento.getChildText("h3")));
                temp.setV3(elemento.getChildText("v3"));
                temp.setH4(Double.parseDouble(elemento.getChildText("h4")));
                temp.setV4(elemento.getChildText("v4"));
                temp.setH5(Double.parseDouble(elemento.getChildText("h5")));
                temp.setV5(elemento.getChildText("v5"));
                temp.setH6(Double.parseDouble(elemento.getChildText("h6")));
                temp.setV6(elemento.getChildText("v6"));
                temp.setH7(Double.parseDouble(elemento.getChildText("h7")));
                temp.setV7(elemento.getChildText("v7"));
                temp.setH8(Double.parseDouble(elemento.getChildText("h8")));
                temp.setV8(elemento.getChildText("v8"));
                temp.setH9(Double.parseDouble(elemento.getChildText("h9")));
                temp.setV9(elemento.getChildText("v9"));
                temp.setH10(Double.parseDouble(elemento.getChildText("h10")));
                temp.setV10(elemento.getChildText("v10"));
                temp.setH11(Double.parseDouble(elemento.getChildText("h11")));
                temp.setV11(elemento.getChildText("v11"));
                temp.setH12(Double.parseDouble(elemento.getChildText("h12")));
                temp.setV12(elemento.getChildText("v12"));
                temp.setH13(Double.parseDouble(elemento.getChildText("h13")));
                temp.setV13(elemento.getChildText("v13"));
                temp.setH14(Double.parseDouble(elemento.getChildText("h14")));
                temp.setV14(elemento.getChildText("v14"));
                temp.setH15(Double.parseDouble(elemento.getChildText("h15")));
                temp.setV15(elemento.getChildText("v15"));
                temp.setH16(Double.parseDouble(elemento.getChildText("h16")));
                temp.setV16(elemento.getChildText("v16"));
                temp.setH17(Double.parseDouble(elemento.getChildText("h17")));
                temp.setV17(elemento.getChildText("v17"));
                temp.setH18(Double.parseDouble(elemento.getChildText("h18")));
                temp.setV18(elemento.getChildText("v18"));
                temp.setH19(Double.parseDouble(elemento.getChildText("h19")));
                temp.setV19(elemento.getChildText("v19"));
                temp.setH20(Double.parseDouble(elemento.getChildText("h20")));
                temp.setV20(elemento.getChildText("v20"));
                temp.setH21(Double.parseDouble(elemento.getChildText("h21")));
                temp.setV21(elemento.getChildText("v21"));
                temp.setH22(Double.parseDouble(elemento.getChildText("h22")));
                temp.setV22(elemento.getChildText("v22"));
                temp.setH23(Double.parseDouble(elemento.getChildText("h23")));
                temp.setV23(elemento.getChildText("v23"));
                temp.setH24(Double.parseDouble(elemento.getChildText("h24")));
                temp.setV24(elemento.getChildText("v24"));
                listatemperaturas.add(temp);

        });
        //System.out.println(listatemperaturas);
        return listatemperaturas;
    }

    /**
     * Cargamos los datos del XML en una listaContaminantes
     * @return listaContaminantes
     */
    public List<Contaminantes> getContaminantes() {
        // Tomamos el elemento raiz y obtenemos sus hijos
        Element root = (Element) this.data.getRootElement();
        List<Element> listaMediciones = root.getChildren("medicion");

        List<Contaminantes> listacontaminantes = new ArrayList<>();

        // Por cada elemento
        listaMediciones.forEach(elemento -> {

            Contaminantes cont = new Contaminantes();
            cont.setProvincia(Integer.parseInt(elemento.getChildText("provincia")));
            cont.setMunicipio(Integer.parseInt(elemento.getChildText("municipio")));
            cont.setEstacion(Integer.parseInt(elemento.getChildText("estacion")));
            cont.setMagnitud(Integer.parseInt(elemento.getChildText("magnitud")));
            cont.setPuntoMuestreo(elemento.getChildText("puntoMuestreo"));
            cont.setAno(Integer.parseInt(elemento.getChildText("anio")));
            cont.setMes(Integer.parseInt(elemento.getChildText("mes")));
            cont.setDia(Integer.parseInt(elemento.getChildText("dia")));
            cont.setH1(Double.parseDouble(elemento.getChildText("h1")));
            cont.setV1(elemento.getChildText("v1"));
            cont.setH2(Double.parseDouble(elemento.getChildText("h2")));
            cont.setV2(elemento.getChildText("v2"));
            cont.setH3(Double.parseDouble(elemento.getChildText("h3")));
            cont.setV3(elemento.getChildText("v3"));
            cont.setH4(Double.parseDouble(elemento.getChildText("h4")));
            cont.setV4(elemento.getChildText("v4"));
            cont.setH5(Double.parseDouble(elemento.getChildText("h5")));
            cont.setV5(elemento.getChildText("v5"));
            cont.setH6(Double.parseDouble(elemento.getChildText("h6")));
            cont.setV6(elemento.getChildText("v6"));
            cont.setH7(Double.parseDouble(elemento.getChildText("h7")));
            cont.setV7(elemento.getChildText("v7"));
            cont.setH8(Double.parseDouble(elemento.getChildText("h8")));
            cont.setV8(elemento.getChildText("v8"));
            cont.setH9(Double.parseDouble(elemento.getChildText("h9")));
            cont.setV9(elemento.getChildText("v9"));
            cont.setH10(Double.parseDouble(elemento.getChildText("h10")));
            cont.setV10(elemento.getChildText("v10"));
            cont.setH11(Double.parseDouble(elemento.getChildText("h11")));
            cont.setV11(elemento.getChildText("v11"));
            cont.setH12(Double.parseDouble(elemento.getChildText("h12")));
            cont.setV12(elemento.getChildText("v12"));
            cont.setH13(Double.parseDouble(elemento.getChildText("h13")));
            cont.setV13(elemento.getChildText("v13"));
            cont.setH14(Double.parseDouble(elemento.getChildText("h14")));
            cont.setV14(elemento.getChildText("v14"));
            cont.setH15(Double.parseDouble(elemento.getChildText("h15")));
            cont.setV15(elemento.getChildText("v15"));
            cont.setH16(Double.parseDouble(elemento.getChildText("h16")));
            cont.setV16(elemento.getChildText("v16"));
            cont.setH17(Double.parseDouble(elemento.getChildText("h17")));
            cont.setV17(elemento.getChildText("v17"));
            cont.setH18(Double.parseDouble(elemento.getChildText("h18")));
            cont.setV18(elemento.getChildText("v18"));
            cont.setH19(Double.parseDouble(elemento.getChildText("h19")));
            cont.setV19(elemento.getChildText("v19"));
            cont.setH20(Double.parseDouble(elemento.getChildText("h20")));
            cont.setV20(elemento.getChildText("v20"));
            cont.setH21(Double.parseDouble(elemento.getChildText("h21")));
            cont.setV21(elemento.getChildText("v21"));
            cont.setH22(Double.parseDouble(elemento.getChildText("h22")));
            cont.setV22(elemento.getChildText("v22"));
            cont.setH23(Double.parseDouble(elemento.getChildText("h23")));
            cont.setV23(elemento.getChildText("v23"));
            cont.setH24(Double.parseDouble(elemento.getChildText("h24")));
            cont.setV24(elemento.getChildText("v24"));
            listacontaminantes.add(cont);
        });
        //System.out.println(listacontaminantes);
        return listacontaminantes;
    }



}

package Meteo;

import Meteo.Controller.Filtrar;
import Meteo.Controller.JAXBController;
import Meteo.Controller.LectorCSV;
import Meteo.Controller.LectorXML;
import org.jdom2.JDOMException;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class Meteo {

    public static void main(String[] args) throws IOException, JAXBException, JDOMException {

        String WORKING_DIRECTORY = System.getProperty("user.dir");

        String TEMPERATURA_XML = WORKING_DIRECTORY + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Datos" + File.separator + "temperatura.xml";
        String CONTAMINANTES_XML = WORKING_DIRECTORY + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Datos" + File.separator + "contaminantes.xml";

        String DATOS_METEO_MES = WORKING_DIRECTORY + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Datos" + File.separator + "calidad_aire_datos_meteo_mes.csv";
        String DATOS_MES = WORKING_DIRECTORY + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Datos" + File.separator + "calidad_aire_datos_mes.csv";

        //PASAMOS LOS CSV A XML CON NUESTRO LECTOR CSV
        LectorCSV temperatura = LectorCSV.getInstance(DATOS_MES);
        temperatura.transformarCSV();
        temperatura.writeXMLFile(TEMPERATURA_XML);

        LectorCSV contaminacion = LectorCSV.getInstance(DATOS_METEO_MES);
        contaminacion.transformarCSV();
        contaminacion.writeXMLFile(CONTAMINANTES_XML);


        // CARGAREMOS LOS XML EN UNA LISTA DE OBJETOS
        LectorXML lectorTemperatura =  LectorXML.getInstance(TEMPERATURA_XML);
        lectorTemperatura.loadData();
        lectorTemperatura.getTemperatura();

        LectorXML lectorContaminantes =  LectorXML.getInstance(CONTAMINANTES_XML);
        lectorContaminantes.loadData();
        lectorContaminantes.getContaminantes();

        Filtrar filtros = new Filtrar();

        filtros.cargarDatosContaminantes();
        filtros.cargarDatosTemperatura();
        filtros.sacarDatosTemperatura();
        filtros.sacarDatosContaminantes();
        filtros.sacarMediasMinMaxTemperatura();















        //RegistroMunicipios registro = new RegistroMunicipios();
        //System.out.println("DATOS CARGADOS");
        //registro.cargarDatosContaminantes();
       // registro.cargarDatosTemperatura();
        //registro.sacarDatosContaminantes();
       // registro.sacarDatosTemperatura();

       /* System.out.println("Comienza el controlador");
        JAXBController controller = JAXBController.getInstance();
        RegistroMunicipios regis = new RegistroMunicipios();
        try {
            controller.setClaseContaminantes(regis.listacontaminantes);
            System.out.println("Pasando de Objeto Contaminante a XML");
            controller.printXMLContaminantes();
            controller.writeXMLFileContaminantes(CONTAMINANTES_XML);
            System.out.println();

            controller.setClaseTemperatura(regis.listatemperatura);
            System.out.println("Pasando de Objeto Temperatura a XML");
            controller.printXMLTemperatura();
            controller.writeXMLFileTemperatura(TEMPERATURA_XML);
            System.out.println();
        } catch (JAXBException e) {
            e.printStackTrace();
        }*/


    }
}



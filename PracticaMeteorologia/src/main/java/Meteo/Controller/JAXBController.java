package Meteo.Controller;
import Meteo.Model.Contaminantes;
import Meteo.Model.Temperatura;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JAXBController {
    //Ibamos a utilizar el JBAX controller para sacar del xml el dom y con el dom poder filtrarlo XPATH
    private static JAXBController instance;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private List<Temperatura> listatemperatura;
    private List<Contaminantes> listacontaminantes;

    //singleton
    public static JAXBController getInstance() {
        if (instance == null) {
            instance = new JAXBController();
        }
        return instance;
    }


    private void convertirObjetoTemperaturaAXml(List<Temperatura> listatemperatura) throws JAXBException {

        this.listatemperatura= listatemperatura;
        //creamos un contexto
        JAXBContext contexto = JAXBContext.newInstance(Temperatura.class);
        //Marshall ---> es objeto a XML
        this.marshaller= contexto.createMarshaller();
        this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
    }

    public void setClaseTemperatura(List<Temperatura> listatemperatura)throws JAXBException{
        convertirObjetoTemperaturaAXml(listatemperatura);
    }

    public void writeXMLFileTemperatura(String uri) throws JAXBException {
        this.marshaller.marshal(listatemperatura, new File(uri));
        System.out.println("Fichero XML Temperatura se a generado con éxito");
    }

    //metodo para printear el xml
    public void printXMLTemperatura() throws JAXBException {
        this.marshaller.marshal(listatemperatura, System.out);
    }

    //metodo para pasar del xml al objeto temperatura
    public List<Temperatura> convertXMLToObjectTemperatura(String uri) throws JAXBException {
        // Creamos el contexto
        JAXBContext context = JAXBContext.newInstance(Temperatura.class);
        this.unmarshaller = context.createUnmarshaller();
        // Unmarshall --> de xml al objeto temperatura
        this.listatemperatura = (List<Temperatura>) this.unmarshaller.unmarshal(new File(uri));
        return this.listatemperatura;
    }
    ///////////////////////////////////////////////////////// Metodos para leer contaminacion/////////////////////////////////////////



    private void convertirObjetoContaminacionAXml(List<Contaminantes> listacontaminantes) throws JAXBException {

        this.listacontaminantes = listacontaminantes;
        //creamos un contexto
        JAXBContext contexto = JAXBContext.newInstance(Contaminantes.class);
        //Marshall ---> es objeto a XML
        this.marshaller= contexto.createMarshaller();
        this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
    }

    public void setClaseContaminantes(List<Contaminantes> listacontaminantes)throws JAXBException{
        convertirObjetoContaminacionAXml(listacontaminantes);
    }

    public void writeXMLFileContaminantes(String uri) throws JAXBException {
        this.marshaller.marshal(listacontaminantes, new File(uri));
        System.out.println("Fichero XML Contaminantes se a  generado con éxito");
    }

    //metodo para printear el xml
    public void printXMLContaminantes() throws JAXBException {
        this.marshaller.marshal(listacontaminantes, System.out);
    }

    //metodo para pasar del xml al objeto contaminantes

    public List<Contaminantes> convertXMLToObjectContaminantes(String uri) throws JAXBException {
        // Creamos el contexto
        JAXBContext context = JAXBContext.newInstance(Contaminantes.class);
        this.unmarshaller = context.createUnmarshaller();
        // Unmarshall --> de xml al objeto temperatura
        this.listacontaminantes = (List<Contaminantes>) this.unmarshaller.unmarshal(new File(uri));
        return this.listacontaminantes;
    }
}

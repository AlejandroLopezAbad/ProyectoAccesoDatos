package Meteo.Controller;

import Meteo.Model.Contaminantes;
import Meteo.Model.Medicion;
import Meteo.Model.Temperatura;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Filtrar {
    String WORKING_DIRECTORY = System.getProperty("user.dir");

    String TEMPERATURA_XML = WORKING_DIRECTORY + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Datos" + File.separator + "temperatura.xml";
    String CONTAMINANTES_XML = WORKING_DIRECTORY + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Datos" + File.separator + "contaminantes.xml";

    private List<Temperatura> listatempe;
    private List<Contaminantes> listaconta;
    private LectorXML lectortemp= LectorXML.getInstance(TEMPERATURA_XML);
    private LectorXML lectorcont= LectorXML.getInstance(CONTAMINANTES_XML);
    private List<Medicion> mediciones = new ArrayList<>();
    private Temperatura hola= new Temperatura();
    /**
     * Cargando los datos del XML en esta nueva lista con la que empezaremos a filtrar con API STREAM
     */
    public void cargarDatosTemperatura(){
        listatempe=lectortemp.getTemperatura();
        System.out.println("Datos cargados en Lista Temperaturas");
    }
    /**
     * Cargando los datos del XML en esta nueva lista con la que empezaremos a filtrar con API STREAM
     */
    public void cargarDatosContaminantes(){
        listaconta=lectorcont.getContaminantes();
        System.out.println("Datos cargados en Lista Contaminantes");
    }

    public void sacarDatosTemperatura(){
        listatempe.stream().forEach(System.out::println);
    }
    public void sacarDatosContaminantes(){
        listaconta.stream().forEach(System.out::println);
    }

    public void sacarMediasMinMaxTemperatura() {
        System.out.println("");
        System.out.println("DATOS FILTRADOS TEMPERATURA");
        System.out.println("");
        System.out.println("MAXIMO DATO ");
        //hola.getAllH();
        //hola.getListahs().stream().max();

         //  System.out.println(listatempe.stream().max(Comparator.comparing(hola::getAllH())).get());

        /*System.out.println(listatempe.stream().mapToDouble(j->{
            for(int i=1;i <= listatempe.size();i++){
                j.getListahs().stream().max();//aqui iria la sentencia de con api stream donde filtrariamos todas las h para sacar el max
            }
            return j;
        }));*/
        System.out.println("Es el maximo de h1:"+listatempe.stream().mapToDouble(u->u.getH1()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH2()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH3()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH4()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH5()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH6()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH7()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH8()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH9()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH10()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH11()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH12()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH13()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH14()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH15()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH16()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH17()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH18()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH19()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH20()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH21()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH22()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH23()).max());
        System.out.println(listatempe.stream().mapToDouble(u->u.getH24()).max());
    //   System.out.println(listatempe.stream().mapToDouble(r->r.getH1()+r.getH2()+r.getH3()+r.getH4()+r.getH5()+r.getH6()+r.getH7()+r.getH8()+r.getH9()+r.getH10()+r.getH11()+r.getH12()+r.getH13()+r.getH14()+r.getH15()+r.getH16()+r.getH17()+r.getH18()+r.getH19()+r.getH20()+r.getH21()+r.getH22()+r.getH23()+r.getH24()).max());



        //var x=listatempe.stream().max(Comparator.comparing(Temperatura::getH1));
    }

   /* public void sacarMediasMinMaxTContaminantes() {
        System.out.println("");
        System.out.println("DATOS FILTRADOS CONTAMINANTES");
        System.out.println("");
        System.out.println("MAXIMO DATO ");
        //hola.getAllH();
        //hola.getListahs().stream().max();




        // System.out.println(listatempe.stream().mapToDouble(r->r.getH1()r.getH2()+r.getH3()+r.getH4()+r.getH5()+r.getH6()+r.getH7()+r.getH8()+r.getH9()+r.getH10()+r.getH11()+r.getH12()+r.getH13()+r.getH14()+r.getH15()+r.getH16()+r.getH17()+r.getH18()+r.getH19()+r.getH20()+r.getH21()+r.getH22()+r.getH23()+r.getH24()).max());


        System.out.println(listatempe.stream().max(Comparator.comparing(Temperatura::getAllH)).get());
        var x=listaconta.stream().max(Comparator.comparing(listaconta::getH1));
    }
*/





}

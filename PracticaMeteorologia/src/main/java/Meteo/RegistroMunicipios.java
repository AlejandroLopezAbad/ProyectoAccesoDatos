package Meteo;

import Meteo.Model.Contaminantes;
import Meteo.Model.Temperatura;

import java.io.IOException;
import java.util.List;

public class RegistroMunicipios {

    List<Contaminantes> listacontaminantes ;
    List<Temperatura> listatemperatura;

    public void cargarDatosContaminantes() throws IOException {
        //listacontaminantes = LectorCSV.getContaminantes();
    }
    public void cargarDatosTemperatura() throws IOException {
        //listatemperatura = LectorCSV.getTemperaturas();
    }
    public void sacarDatosContaminantes() {
        System.out.println("Sacando datos contaminantes ");
        listacontaminantes.stream().forEach(System.out::println);
    }
    public void sacarDatosTemperatura() {
        System.out.println("Sacando datos temperatura ");
        listatemperatura.stream().forEach(System.out::println);
    }
    //NO HAGAS CASO A ESTOS METODOS
    public void sacarMediaContaminantes(){
        System.out.println("Mediciones del csv de contaminantes");
        System.out.println("Media de contaminantes:");
        listacontaminantes.stream().mapToDouble(w->{
                double media;
                media= w.getH1()+w.getH1()+w.getH2()+w.getH3()+w.getH4()+w.getH5()+w.getH6()+w.getH7()+w.getH8()+w.getH9()+w.getH10()+w.getH11()+w.getH12()+w.getH13()+w.getH14()+w.getH15()+w.getH16()+w.getH17()+w.getH18()+w.getH19()+w.getH20()+w.getH21()+w.getH22()+w.getH23()+w.getH24();
                return media;
        }).average();

    }
    public void sacarMaximoContaminantes(){
        System.out.println("Maximo dato contaminantes");
        listacontaminantes.stream().mapToDouble(u->{
            double max;
            max= u.getH1()+u.getH1()+u.getH2()+u.getH3()+u.getH4()+u.getH5()+u.getH6()+u.getH7()+u.getH8()+u.getH9()+u.getH10()+u.getH11()+u.getH12()+u.getH13()+u.getH14()+u.getH15()+u.getH16()+u.getH17()+u.getH18()+u.getH19()+u.getH20()+u.getH21()+u.getH22()+u.getH23()+u.getH24();
            return max;
        }).max();
    }






}

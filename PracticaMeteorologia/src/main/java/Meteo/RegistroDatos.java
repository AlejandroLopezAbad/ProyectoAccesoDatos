package Meteo;

import java.time.LocalDate;
import lombok.*;

@Data
public class RegistroDatos {

        public int provincia;
        public int municipio;
        public int estacion;



        public RegistroDatos(int estacion, int provincia, int municipio) {
        }
}

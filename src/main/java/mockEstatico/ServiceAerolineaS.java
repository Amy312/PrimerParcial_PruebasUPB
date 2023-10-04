package mockEstatico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiceAerolineaS {

    public static boolean existenPasajes(String destino, int cantidad){
        return true;
    }

    public static String getDay(int dia, int mes, int gestion){
        LocalDateTime myDateObj = LocalDateTime.of(gestion,mes,dia,0,0);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE");

        String formattedDate = myDateObj.format(myFormatObj);
        formattedDate = formattedDate.toUpperCase().charAt(0) + formattedDate.substring(1, formattedDate.length());
        return formattedDate;
    }
}

package mock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiceAerolinea {

    public boolean existenPasajes(String destino, int cantidad){
        return true;
    }

    public String getDay(int dia, int mes, int gestion){
        LocalDateTime myDateObj = LocalDateTime.of(gestion,mes,dia,0,0);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE");
        String formattedDate = myDateObj.format(myFormatObj);
        formattedDate = formattedDate.toUpperCase().charAt(0) + formattedDate.substring(1, formattedDate.length());
        return formattedDate;
    }
}

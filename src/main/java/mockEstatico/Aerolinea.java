package mockEstatico;

public class Aerolinea {



    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion){
        String month;
        if(cantidad < 1 || dia < 1 || gestion <1){
            return "datos invalidos";
        }
        if(ServiceAerolineaS.existenPasajes(destino,cantidad)){
            switch (mes){
                case 1:
                    month = "Enero";
                    break;
                case 2:
                    month = "Febrero";
                    break;
                case 3:
                    month = "Marzo";
                    break;
                case 4:
                    month = "Abril";
                    break;
                case 5:
                    month = "Mayo";
                    break;
                case 6:
                    month = "Junio";
                    break;
                case 7:
                    month = "Julio";
                    break;
                case 8:
                    month = "Agosto";
                    break;
                case 9:
                    month = "Septiembre";
                    break;
                case 10:
                    month = "Octubre";
                    break;
                case 11:
                    month = "Noviembre";
                    break;
                case 12:
                    month = "Diciembre";
                    break;
                default:
                    return "datos invalidos";
            }


            return "el día " + ServiceAerolineaS.getDay(dia, mes, gestion) + " " + dia + " " + month + " "+ gestion +
                    " existen " + cantidad + " pasajes para " + destino;
        } else {
            return "no existen suficientes pasajes para " + destino;
        }
    }
}

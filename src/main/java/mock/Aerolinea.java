package mock;

public class Aerolinea {
    ServiceAerolinea serviceAerolinea;

    public Aerolinea() {
        this.serviceAerolinea = new ServiceAerolinea();
    }

    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion){
        if(serviceAerolinea.existenPasajes(destino,cantidad)){
            return "el día " + serviceAerolinea.getDay(dia, mes, gestion) + dia + " de " + mes + gestion +
                    "existen" + cantidad + " pasajes para " + destino;
        } else {
            return "no existen suficientes pasajes para " + destino;
        }
    }
}

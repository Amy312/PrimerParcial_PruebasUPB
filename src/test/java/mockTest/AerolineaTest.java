package mockTest;

import mock.Aerolinea;
import mock.ServiceAerolinea;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class AerolineaTest {
    private Aerolinea aerolinea;
    private ServiceAerolinea service;
    @BeforeEach
    public void setup(){
        aerolinea = new Aerolinea();
        service = Mockito.mock(ServiceAerolinea.class);
    }
    @ParameterizedTest
    @CsvSource({
            "La Paz, 2, 29, 5, 2023, Lunes, true, el día Lunes 29 Mayo 2023 existen 2 pasajes para La Paz",
            "La Paz, -1, 29, 5, 2023, Lunes, true, el día Lunes 29 Mayo 2023 existen 2 pasajes para La Paz",
            "La Paz, 0, 29, 5, 2023, Lunes, true, el día Lunes 29 Mayo 2023 existen 2 pasajes para La Paz",
            "La Paz, 100, 29, 5, 2023, Lunes, true, el día Lunes 29 Mayo 2023 existen 100 pasajes para La Paz",
            "La Paz, 2, 29, 5, 2023, Lunes, true, el día Lunes 29 Mayo 2023 existen 2 pasajes para La Paz",
            "La Paz, 2, 29, 5, 2023, Lunes, true, el día Lunes 29 Mayo 2023 existen 2 pasajes para La Paz",
            "La Paz, 2, 29, 5, 2023, Lunes, true, el día Lunes 29 Mayo 2023 existen 2 pasajes para La Paz",
            "La Paz, 2, 29, 5, 2023, Lunes, true, el día Lunes 29 Mayo 2023 existen 2 pasajes para La Paz"
    })
    public  void verifyReservaVuelo(String destino, int cantidad, int dia, int mes, int gestion, String expectedDay, Boolean expPasaje, String expected){
        Mockito.when(service.getDay(dia, mes, gestion)).thenReturn(expectedDay);
        Mockito.when(service.existenPasajes(destino, cantidad)).thenReturn(expPasaje);

        String actual = aerolinea.reservaVuelo(destino, cantidad, dia, mes, gestion);
        Assertions.assertEquals(expected, actual, "Error!, mensaje incorrecto");


    }
}

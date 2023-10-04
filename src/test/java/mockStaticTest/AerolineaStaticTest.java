package mockStaticTest;

import mock.Aerolinea;
import mock.ServiceAerolinea;
import mockEstatico.ServiceAerolineaS;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class AerolineaStaticTest {
    private Aerolinea aerolinea;
    private MockedStatic<ServiceAerolineaS> serviceAerolineaMockedStatic;
    @BeforeEach
    public void setup(){
        aerolinea = new Aerolinea();
        serviceAerolineaMockedStatic = Mockito.mockStatic(ServiceAerolineaS.class);
    }
    @ParameterizedTest
    @CsvSource({
            "La Paz, 2, 29, 5, 2023, Lunes, true, el día Lunes 29 Mayo 2023 existen 2 pasajes para La Paz",
            "La Paz, -1, 29, 5, 2023, Lunes, true, datos invalidos",
            "La Paz, 0, 29, 5, 2023, Lunes, true, datos invalidos",
            "La Paz, 100, 29, 5, 2023, Lunes, true, el día Lunes 29 Mayo 2023 existen 100 pasajes para La Paz",
            "La Paz, 2, 29, -1, 2023, Lunes, true, datos invalidos",
            "La Paz, 2, 29, 5, -2023, Lunes, true, datos invalidos",
            "La Paz, 2, -29, 5, 2023, Lunes, true, datos invalidos"
    })
    public  void verifyReservaVuelo(String destino, int cantidad, int dia, int mes, int gestion, String expectedDay, Boolean expPasaje, String expected){
        serviceAerolineaMockedStatic.when(() -> ServiceAerolineaS.getDay(dia, mes, gestion)).thenReturn(expectedDay);
        serviceAerolineaMockedStatic.when(() -> ServiceAerolineaS.existenPasajes(destino, cantidad)).thenReturn(expPasaje);

        String actual = aerolinea.reservaVuelo(destino, cantidad, dia, mes, gestion);
        Assertions.assertEquals(expected, actual, "Error!, mensaje incorrecto");
    }

    @AfterEach
    public void end(){
        serviceAerolineaMockedStatic.close();
    }
}

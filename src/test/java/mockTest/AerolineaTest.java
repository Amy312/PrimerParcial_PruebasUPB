package mockTest;

import mock.ServiceAerolinea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AerolineaTest {

    @Test
    public  void verifygetDay(){
        ServiceAerolinea serviceAerolinea = new ServiceAerolinea();

        String actual = serviceAerolinea.getDay(1,10,2023);
        String expected = "lunes";

        Assertions.assertEquals(expected, actual, "Error!!");
    }
}

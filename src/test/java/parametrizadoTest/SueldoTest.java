package parametrizadoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import parametrizado.Sueldo;

public class SueldoTest {
    private Sueldo sueldo1 = new Sueldo();
    @ParameterizedTest
    @CsvSource({
            "1000, 1000",
            "0, 0",
            "1, 1",
            "-1, dato invalido",
            "1000, 1000",
            "0, 0",
            "1200, 1200",
            "2200, 2090",
            "4001, 3400"
    })
    public void verifyDescuento(int sueldo, String expected){
        String actual = sueldo1.descuento(sueldo);
        Assertions.assertEquals(expected, actual, "Error! Descuento o datos invalidos");
    }

    @Test
    public void verifyException() throws Exception {
        Assertions.assertThrows(Exception.class, () -> {
            sueldo1.descuento(-1);
        });
    }

}

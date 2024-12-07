package home2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Type2Test {
    public static final int HOURS_FOR_JAVA = 198;
    private Type2 t1;
    private Type2 t2;
    private Type2 t3;
    private Type2 t4;

    @BeforeEach
    public void setT2T3() {
        t1 = new Type2(HOURS_FOR_JAVA, "Иван", "Рогов", 0.1);
        t2 = new Type2(HOURS_FOR_JAVA, "Анатолий", "Розенберг", 0.4);
        t3 = new Type2(HOURS_FOR_JAVA, "Антон", "Савицкий", 0.6);
        t4 = new Type2(HOURS_FOR_JAVA, "Максим", "Головин", 0.0);
    }

    @Test
    public void discriptTest2() {
        String x = "Делает только практическую часть и разборы";
        assertEquals(x, t1.discript());
    }

    @Test
    public void summAll2() {
        BigDecimal b1 = new BigDecimal(3960).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b3 = new BigDecimal(990).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b5 = new BigDecimal(660).setScale(1, RoundingMode.HALF_UP);
        assertEquals(b1, t1.summAll());
        assertEquals(b3, t2.summAll());
        assertEquals(b5, t3.summAll());
    }


    @Test
    public void summParts2() {
        BigDecimal b2 = new BigDecimal(1980).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b4 = new BigDecimal(495).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b6 = new BigDecimal(330).setScale(1, RoundingMode.HALF_UP);
        assertEquals(b2, t1.summPart());
        assertEquals(b4, t2.summPart());
    }

    @Test
    public void verifyExeption2() {
        assertThrows(ArithmeticException.class, () -> t4.summAll());
    }


    @Test
    public void showTest2() {
        String result = "Тип студента: 2\n" +
                "Талант: " + 0.1 + "\n" +
                "Время, затраченное на разборы: " + 1980.0 + " часов\n" +
                "Время, затраченное на практику: " + 1980.0 + " часов\n" +
                "Cуммарное время на освоение навыка: " + 3960.0 + " часов";
        assertEquals(result, t1.show());
    }


}
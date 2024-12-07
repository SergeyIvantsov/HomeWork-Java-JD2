package home2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Type1Test {
    public static final int HOURS_FOR_JAVA = 198;
    private Type1 t1;
    private Type1 t2;
    private Type1 t3;
    private Type1 t4;

    @BeforeEach
    public void setT1T2() {
        t1 = new Type1(HOURS_FOR_JAVA, "Вася", "Дубровский", 0.5);
        t2 = new Type1(HOURS_FOR_JAVA, "Илья", "Лущинский", 0.2);
        t3 = new Type1(HOURS_FOR_JAVA, "Валя", "Лорина", 0.8);
        t4 = new Type1(HOURS_FOR_JAVA, "Вася", "Дубровский", 0.0);
    }


    @Test
    public void discriptTest() {
        String x = "Делает разборы, практическую часть и находится в потоке";
        assertEquals(x, t1.discript(), "Вывод соответствует ожидаемому");
    }


    @Test
    public void summAllTest() {
        BigDecimal b1 = new BigDecimal(396).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b3 = new BigDecimal(990).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b5 = new BigDecimal(247.5).setScale(1, RoundingMode.HALF_UP);

        assertEquals(b1, t1.summAll());
        assertEquals(b3, t2.summAll());
        assertEquals(b5, t3.summAll());
    }


    @Test
    public void summPartsTest() {
        BigDecimal b2 = new BigDecimal(132).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b4 = new BigDecimal(330).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b6 = new BigDecimal(82.5).setScale(1, RoundingMode.HALF_UP);

        assertEquals(b2, t1.summPart());
        assertEquals(b4, t2.summPart());
        assertEquals(b6, t3.summPart());
    }


    @Test
    public void verifyExeption() {
        assertThrows(ArithmeticException.class, () -> t4.summAll());
    }


    @Test
    public void showTest() {
        String x = "Тип студента: 1\n" +
                "Талант: " + 0.5 + "\n" +
                "Время, затраченное на разборы: " + 132.0 + " часов\n" +
                "Время, затраченное на практику: " + 132.0 + " часов\n" +
                "Время, затраченное на нахождение в потоке: " + 132.0 + " часов\n" +
                "Cуммарное время на освоение навыка: " + 396.0 + " часов";
        assertEquals(x, t1.show());
    }

}
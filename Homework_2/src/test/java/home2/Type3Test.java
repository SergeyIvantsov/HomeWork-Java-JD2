package home2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Type3Test {
    public static final int HOURS_FOR_JAVA = 198;
    private Type3 t1;
    private Type3 t2;
    private Type3 t3;
    private Type3 t4;

    @BeforeEach
    public void setT3T4() {
        t1 = new Type3(HOURS_FOR_JAVA, "Юля", "Иванова", 0.7);
        t2 = new Type3(HOURS_FOR_JAVA, "Федя", "Сидоров", 0.9);
        t3 = new Type3(HOURS_FOR_JAVA, "Маша", "Смирнова", 0.2);
        t4 = new Type3(HOURS_FOR_JAVA, "Гриша", "Черняковский", 0.0);
    }

    @Test
    public void discriptTest3() {
        String x = "Делает только практическую часть";
        assertEquals(x, t1.discript());
    }

    @Test
    public void summAllTest3() {
        BigDecimal b1 = new BigDecimal(848.6).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b2 = new BigDecimal(660).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b3 = new BigDecimal(2970).setScale(1, RoundingMode.HALF_UP);
        assertEquals(b1, t1.summAll());
        assertEquals(b2, t2.summAll());
        assertEquals(b3, t3.summAll());
    }

    @Test
    public void verifyExeption3() {
        assertThrows(ArithmeticException.class, () -> t4.summAll());
    }

    @Test
    public void showTest3() {
        String x = "Тип студента: 3\n" +
                "Талант: " + 0.7 + "\n" +
                "Время, затраченное на практику: " + 848.6 + " часов\n" +
                "Cуммарное время на освоение навыка: " + 848.6 + " часов";
        assertEquals(x, t1.show());
    }
}
package home2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentsTest {

    public static final int HOURS_FOR_JAVA = 198;
    private Type1 t1 = new Type1(HOURS_FOR_JAVA, "Вася", "Дубровский", 0.5);
    private Type2 t2 = new Type2(HOURS_FOR_JAVA, "Иван", "Рогов", 0.1);
    private Student[] students = {t1, t2};

    private Students stud = new Students(students);
    private PrintStream standart = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();


    @BeforeEach
    public void setPrint() {
        System.setOut(new PrintStream(out));
    }


    @Test
    void getStudentsTest() {
        stud.getStudents();
        String x = "Делает разборы, практическую часть и находится в потоке\r\n" +
                "Тип студента: 1\n" +
                "Талант: " + 0.5 + "\n" +
                "Время, затраченное на разборы: " + 132.0 + " часов\n" +
                "Время, затраченное на практику: " + 132.0 + " часов\n" +
                "Время, затраченное на нахождение в потоке: " + 132.0 + " часов\n" +
                "Cуммарное время на освоение навыка: " + 396.0 + " часов\r\n" +
                "\r\n" +
                "Делает только практическую часть и разборы\r\n" +
                "Тип студента: 2\n" +
                "Талант: " + 0.1 + "\n" +
                "Время, затраченное на разборы: " + 1980.0 + " часов\n" +
                "Время, затраченное на практику: " + 1980.0 + " часов\n" +
                "Cуммарное время на освоение навыка: " + 3960.0 + " часов\r\n\r\n";
        assertEquals(x, out.toString());
    }

    @AfterEach
    public void closePrint() throws IOException {
        System.setOut(standart);

    }
}
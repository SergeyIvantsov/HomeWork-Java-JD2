package home2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Type1 implements Student {
    private int hours;
    private String name;
    private String surname;
    private double talent;

    public Type1(int hours, String name, String surname, double talent) {
        this.hours = hours;
        this.name = name;
        this.surname = surname;
        this.talent = talent;
    }

    @Override
    public String discript() {
        return "Делает разборы, практическую часть и находится в потоке";
    }

    @Override
    public BigDecimal summAll() {
        if (talent == 0.0) {
            System.out.println("Талант равен 0");
        }
        BigDecimal b = new BigDecimal(hours);
        return b.divide(BigDecimal.valueOf(talent), 1, RoundingMode.HALF_UP);
    }

    public BigDecimal summPart() {
        return summAll().divide(BigDecimal.valueOf(3), 1, RoundingMode.HALF_UP);
    }

    @Override
    public String show() {
        String result = "Тип студента: 1\n" +
                "Талант: " + talent + "\n" +
                "Время, затраченное на разборы: " + summPart().toString() + " часов\n" +
                "Время, затраченное на практику: " + summPart().toString() + " часов\n" +
                "Время, затраченное на нахождение в потоке: " + summPart().toString() + " часов\n" +
                "Cуммарное время на освоение навыка: " + summAll().toString() + " часов";
        return result;
    }

    @Override
    public void hours() {
        System.out.println(show());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Type1{" +
                "hours=" + hours +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", talent=" + talent +
                '}';
    }
}

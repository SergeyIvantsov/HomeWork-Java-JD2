package home2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Type2 implements Student {
    private int hours;
    private String name;
    private String surname;
    private double talent;

    public Type2(int hours, String name, String surname, double talent) {
        this.hours = hours;
        this.name = name;
        this.surname = surname;
        this.talent = talent;
    }


    public String discript() {
        return "Делает только практическую часть и разборы";
    }

    @Override
    public BigDecimal summAll() {
        if (talent == 0.0) {
            System.out.println("Талант равен 0");
        }
        BigDecimal b = new BigDecimal(hours);
        return b.multiply(BigDecimal.valueOf(2)).divide(BigDecimal.valueOf(talent), 1, RoundingMode.HALF_UP);
    }


    public BigDecimal summPart() {
        return summAll().divide(BigDecimal.valueOf(2), 1, RoundingMode.HALF_UP);
    }

    @Override
    public String show() {
        String result = "Тип студента: 2\n" +
                "Талант: " + talent + "\n" +
                "Время, затраченное на разборы: " + summPart().toString() + " часов\n" +
                "Время, затраченное на практику: " + summPart().toString() + " часов\n" +
                "Cуммарное время на освоение навыка: " + summAll().toString() + " часов";
        return result;
    }

    @Override
    public void hours() {
        System.out.println(show());
        System.out.println();
    }
}

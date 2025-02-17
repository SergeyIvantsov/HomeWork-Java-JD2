package home2;

public class UtilClass {
    public static final int HOURS_FOR_JAVA = 198;

    protected static double getTalent() {
        double x = Math.random() + 0.1;
        double y = Math.floor(x * 10.0) / 10.0;
        return y;
    }

    protected static String getName() {
        String[] name = {"Коля", "Петя", "Юля", "Саша", "Маша", "Митя"};
        int n = (int) (Math.random() * name.length);
        return name[n];
    }

    protected static String getSurname() {
        String[] surname = {"Гришченко", "Турасевич", "Волк", "Авченко", "Данилевич"};
        int n = (int) (Math.random() * surname.length);
        return surname[n];
    }

    protected static Student[] stud(int NUMBER_TYPE) {
        Student[] students = new Student[NUMBER_TYPE];
        for (int i = 0; i < NUMBER_TYPE; i++) {
            double y = UtilClass.getTalent();
            if (i >= 0 && i <= 2) {
                students[i] = new Type1(HOURS_FOR_JAVA, UtilClass.getName(), UtilClass.getSurname(), y);
            }
            if (i >= 3 && i <= 5) {
                students[i] = new Type2(HOURS_FOR_JAVA, UtilClass.getName(), UtilClass.getSurname(), y);
            }
            if (i >= 6) {
                students[i] = new Type3(HOURS_FOR_JAVA, UtilClass.getName(), UtilClass.getSurname(), y);
            }
        }
        return students;
    }
}

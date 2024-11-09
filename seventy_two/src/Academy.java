import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Academy {
    public static void info() {
        int x = 10;
    }

    @Academyinfo(year = 15)
    public static void forAcademy() {
        String x = "How many years?";
    }

    public static void main(String[] args) {
        Academy academy = new Academy();
        Class c = academy.getClass();
        Method methods[] = c.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Annotation anno = null;
            if (methods[i].isAnnotationPresent(Academyinfo.class)) {
                anno = methods[i].getAnnotation(Academyinfo.class);
                System.out.println("Метод " + methods[i].getName() + " содержит аннотацию " + anno + " с полем " + ((Academyinfo) anno).year());
            } else {
                System.out.println("Метод " + methods[i].getName() + " не содержит аннотацию " + anno);
            }
        }


    }


}

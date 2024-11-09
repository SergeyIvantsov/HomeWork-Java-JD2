package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AboutMan {

    public static void aboutMan() {
        Man immortal = new Man();
        Class c = immortal.getClass();
        //узнаем информацию о классе
        System.out.println("Имя класса: " + c.getName());
        int modClass = c.getModifiers();
        System.out.println("Модификаторы доступа класса: " + Modifier.toString(modClass));

        //узнаем информацию о полях класса
        System.out.println("Список полей(переменных) класса Man: ");
        Field fields[] = c.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            int x = fields[i].getModifiers();
            System.out.print("Имя переменной: " + fields[i].getName() + ". ");
            System.out.print("Модификатор доступа переменной: " + Modifier.toString(x) + ". ");
            System.out.println("Тип переменной: " + fields[i].getType());
            //System.out.println();
            if (Modifier.isPrivate(x) || Modifier.isProtected(x)) {
                fields[i].setAccessible(true);
            }
        }
        try {
            Field field = c.getDeclaredField("age");
            System.out.println("Значение переменной " + field.getName() + ": " + (Integer) field.get(immortal));
            Field field1 = c.getDeclaredField("name");
            field1.setAccessible(true);
            System.out.println("Значение переменной " + field1.getName() + ": " + (String) field1.get(immortal));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        //узнаем информацию о методах класса
        Method methods[] = c.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            int y = methods[i].getModifiers();
            System.out.println("Имя метода: " + methods[i].getName() + ". Модификаторы доступа: " + Modifier.toString(y)
                    + ". Тип возвращаемого значения метода: " + methods[i].getReturnType());
        }
        try {
            Method m = c.getDeclaredMethod("fromCountry");
            m.setAccessible(true);
            Object in = m.invoke(immortal);
            System.out.println("Возвращаемое значение метода " + m.getName() + ": " + in);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        aboutMan();
    }

}

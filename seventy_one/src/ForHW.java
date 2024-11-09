import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ForHW {
    public static void main(String[] args) {
        WhatTheClass wtc = new WhatTheClass();
        Class<?> с = wtc.getClass();//получили объект типа Class, описывающий класс WhatTheClass
        try {
            Method m = с.getDeclaredMethod("printHelloWorld");//возвращает метод, описывающий метод printHelloWorld()

            Object in = m.invoke(wtc);//для вызова метода использовали invoke
            System.out.println(in);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}

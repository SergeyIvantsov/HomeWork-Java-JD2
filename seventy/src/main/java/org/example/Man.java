package org.example;

public final class Man {
    public int age = 400;
    private String name = "Dunkan Maclaud";

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    private String fromCountry(){
        return "Scotland";
    }
}

package com.company;

//in java can implements Comparable<nameclass>, then Override method compareTo too.

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public int compareTo(Person o) {
//        if (this.age > o.age) return 1;
//        if (this.age < o.age) return -1;
//        return 0;
//    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}

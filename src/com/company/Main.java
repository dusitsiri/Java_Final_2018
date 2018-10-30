package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Person tiger = new Person("tiger", 10);
        Person pat = new Person("pat", 3);

//        TreeSet<Person> data = new TreeSet<>(new PersonComparator());
//        data.add(tiger);
//        data.add(pat);
//
//        for (Person d : data){
//            System.out.println(d.getName());
//            System.out.println(d.getAge());
//        }

        ArrayList<Person> array = new ArrayList();
        array.add(tiger);
        array.add(pat);

//        System.out.println("-----Before sort-----");
//        for (int i=0; i<array.size(); i++){
//            System.out.print(array.get(i)+ " ");
//        }
//        Collections.sort(array, new PersonComparator());    //sort เลย
//        System.out.println();
//        System.out.println("-----After sort-----");
//        for (int i=0; i<array.size(); i++){
//            System.out.print(array.get(i)+" ");
//        }

        //Anonymous class
        Collections.sort(array, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        });


    }
}
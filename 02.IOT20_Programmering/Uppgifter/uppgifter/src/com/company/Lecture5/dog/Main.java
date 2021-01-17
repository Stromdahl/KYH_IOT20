package com.company.Lecture5.dog;

import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Axel", "chiwawa", LocalDate.of(2017, 06, 24));
        Dog dog2 = new Dog("Axel", "labrador", LocalDate.of(2017, 10, 24));
        System.out.println("Hunden heter " + dog1.getName());
        dog1.chase(dog2);

        Period diff = dog2.getAge();
        System.out.println(diff.getYears() + "years" + diff.getMonths() + "months" + diff.getDays() + "days");
        System.out.println(Dog.converHumanYearsToDogYears(5));

        Chicken chicken = new Chicken("Pelle");
        chicken.printSound();

        Cat cat = new Cat("Majsan");
        cat.printSound();
    }
}

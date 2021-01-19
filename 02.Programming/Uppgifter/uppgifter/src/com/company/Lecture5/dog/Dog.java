package com.company.Lecture5.dog;

import java.time.LocalDate;
import java.time.Period;

public class Dog extends Animal{
    private String call = "";
    private String race;
    private LocalDate birthDate;
    private static int conversionRateForDogYears = 7;

    public Dog (String name, String bred, LocalDate birthDate) {
        super(name, "Bark");
        this.race = bred;
        this.birthDate = birthDate;

        switch (bred){
            case "labrador":
                call = "Bark!";
                break;
            case "chiwawa":
                call = "Mjauu";
                break;
            default:
                call = "Woff";
        }
    }

    public static int converHumanYearsToDogYears(int i){
        return i * conversionRateForDogYears;
    }


    public boolean equals(Dog dog) {
        return this.getName().equals(dog.getName());
    }


    public void setRace(String race) {
        this.race = race;
    }

    public LocalDate getBirthDate(){
        return this.birthDate;
    }

    public Period getAge(){
        LocalDate l = this.birthDate; //specify year, month, date directly
        LocalDate now = LocalDate.now(); //gets localDate
        Period diff = Period.between(l, now); //difference between the dates is calculated
        return diff;
    }

    public void chase(Dog dog){
        System.out.println(name + " chasing " + dog.getName());
        this.bark("RAAwwrrr");
        dog.bark();
    }

    public void bark() {
        System.out.println(name + ": " + call);
    }
    public void bark(String b){
        System.out.println(name + ": " + b);
    }
}

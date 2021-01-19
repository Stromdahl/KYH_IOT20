package com.company.Lecture5.dog;

public abstract class Animal {
    protected String name;
    protected String sound;

    Animal(String name, String sound){
        this.name = name;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void printSound(){
        System.out.println(this.name + " says " + this.sound);
    }
}

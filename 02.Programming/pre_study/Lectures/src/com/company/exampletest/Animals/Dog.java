package com.company.exampletest.Animals;

public class Dog {
    public Dog(){

    }

    void bark() {
        System.out.println("woff");
    }

    public void chase(Dog d) {
        this.bark();
        d.bark();
    }
}

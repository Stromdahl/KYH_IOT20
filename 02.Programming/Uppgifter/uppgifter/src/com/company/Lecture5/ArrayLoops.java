package com.company.Lecture5;

public class ArrayLoops {

    /*
    Övning 1:
    - Skapa en ny array "numbers" med värdena:
      "Ford", "Audi", "Skoda", "Volvo", "Chevrolet"
    - Gör en for-loop skriv ut alla värden på skärmen.
      "Place 0: Ford"
      "Place 1: Audi"
      "Place 2: Skoda"
      "Place 3: Volvo"
      "Place 4: Chevrolet"

    Övning 2:
    - Utan att tidigare kod: Lägg till en rad kod som ändrar "Audi" till "Nissan" i listan.
    - Skriv ut alla elementen i arrayen baklänges, från det sista till det första
     */

    public static void main(String[] args) {
        // Skriv din kod här
        String[] numbers= {"Ford", "Audi", "Skoda", "Volvo", "Chevrolet"};

        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
        System.out.println();
        for(int i = numbers.length-1; i >= 0; i--){
            if(numbers[i].equals("Audi")){
                numbers[i] = "Skoda";
            }
            System.out.println(numbers[i]);
        }
    }
}

package com.company.Lecture5;

public class ArrayMethods {
    /*
    Övningar:

    1: Skriv en metod "summa". Metoden ska ta in en array med heltal, och returnera summan av talen.

    2: Skriv en metod "maximum". Metoden ska ta in en array med heltal, och returnera det största talet.
    */

    public static int summa(int[] numbers){
        int result = 0;
        for (int n:numbers) {
            result += n;
        }
        return result;
    }

    public static int maximum(int[] numbers){
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            max = Math.max(numbers[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {-10, -20, -7, -14, -3, -30};
        // Använd dessa rader för att använda dina metoder

        int sum = summa(numbers);
        int max = maximum(numbers);

        System.out.println("Summan är: " + sum); // Ska skriva ut 54
        System.out.println("Största talet är: " + max); // Ska skriva ut 20

    }

    // Skriv dina metoder här här
}

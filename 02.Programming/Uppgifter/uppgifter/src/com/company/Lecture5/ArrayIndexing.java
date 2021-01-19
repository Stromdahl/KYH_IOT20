package com.company.Lecture5;

public class ArrayIndexing {
    /*
    Övningar:
    - Skriv ut det första talet i arrayen
    - Skriv ut det sista talet i arrayen
    - Ändra talet "123.321" till "8.8", utan att ändra på raden där arrayen skapas
    - Skriv ut det sista talet i arrayen igen
     */

    public static void main(String[] args) {
        double[] minLista = {5.6, 4.0, 99.22, 3.3, 34.0, 0.01, 3.1415, 9.001, 13.13, 123.321};

        // Skriv din kod här
        System.out.println(minLista[0]);
        System.out.println(minLista[minLista.length-1]);
        minLista[minLista.length-1] = 8.8;
        System.out.println(minLista[minLista.length-1]);
    }
}

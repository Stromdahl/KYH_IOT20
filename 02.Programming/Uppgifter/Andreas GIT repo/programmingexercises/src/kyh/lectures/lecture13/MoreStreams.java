package kyh.lectures.lecture13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoreStreams {
    // Hur gör vi om denna till en lambda-funktion?
    public static int add(int a, int b) {
        return a + b;
    }

    interface MyAdd {
        int func(int x, int y);
    }

    public static void main(String[] args) {
        // Repetition: Gör om add() till en lambda-funktion
        MyAdd addFunc = (a, b) -> {
            return a + b;
        };

        int summa = addFunc.func(8, 21);

        System.out.println("Summan är " + summa);


        /*
        Streams repetition:

        Intermediate operations - Låter dig fortsätta strömmen. Ordningen spelar roll!
        Ex: filter(), map(), sorted(), distinct(), ...

        Terminal operations - Avslutar strömmen
        Ex: count(), min(), max(), reduce(), forEach(), collect(), sum(), ...
        */

        // Alternativt sätt att skapa en lista
        List<Integer> array = Arrays.asList(1, 2, 6, 3, 5, 4);


        // Exempel på filter, sorted och collect

        List<Integer> newArray =  // Spara resultatet i en ny variabel
                array.stream()
                .filter(i -> i > 3)  // Hitta alla heltal större än 3
                .sorted()  // Sortera (standard: minst till störst)
                .collect(Collectors.toList());  // collect() kan ge tillbaka t.ex en lista

        newArray.forEach(System.out::println);  // Skriv ut varje element i newArray

        /*
         * Exempel: Räkna element
         */

        long evenCount =
                array.stream()
                .filter(i -> i % 2 == 0)  // Hitta alla jämna tal
                .count();  // Räkna antalet element som är kvar

        System.out.println("Antal jämna nummer: " + evenCount);  // Skriv ut

        /*
         * Exempel: Reduce - Summera ints
         */

        int reduceSum = array.stream()
                .reduce(-200, (a, b) -> a + b);
        System.out.println("Reduce() med summering ger: " + reduceSum);

        // Streamen är: 1, 2, 6, 3, 5, 4
        // - Reduce kör funktionen (a, b) -> a + b
        // - Först är "identiteten" (startvärdet) = 0
        // - reduce() kör lambda-funktionen på identiteten och varje tal för sig.
        //   Efter varje steg lagrar den resultatet i identiteten
        //    0 + 1 = 1
        //    1 + 2 = 3
        //    3 + 6 = 9
        //    osv...

        
        /*
         * Exempel: Reduce - Bygg ihop strängar
         */

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        ArrayList<String> lettersarr = new ArrayList<>();
        lettersarr.add("a");

        String reducedString = letters
                .stream()
                .reduce("Start-värde... ", (s, element) -> s + element.toUpperCase());
        System.out.println("Reduce() med strängar ger: " + reducedString);


    }
}

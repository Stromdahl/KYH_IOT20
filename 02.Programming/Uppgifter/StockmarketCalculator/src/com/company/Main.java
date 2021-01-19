package com.company;

public class Main {

    public static void main(String[] args) {
        /*
        Detta är en frivillig övning, med syftet att ge exempel på och skapa förståelse för vad man kan göra med
        den mängd Java-kod ni har lärt er hittills. Det är ingen inlämning, och vi kommer inte ställa några följdfrågor
        på lektionstid. Lek runt med programmet, och fundera på vad ni annars kan programmera med det ni lärt er?

        Detta kodexempel visar hur pengars värde kan utvecklas över tid, när de används på olika sätt. Programmet börjar
        med en summa pengar, och lägger på lite ränta varje år.

        Förslag på övningar:
            1) Just nu är räntan satt till 1%. (Detta är generöst för att vara ett vanligt sparkonto. Swedbank och många
               andra har 0% ränta just nu.) Ändra räntan till exempelvis 8% (genomsnittlig årlig avkastning på en global
               indexfond över lång tid).
            2) Du sätter in 12 000 SEK per år på kontot (1000 SEK per månad). Ändra koden så detta räknas med.
            3) Lek runt med siffrorna för ränta (interest), startpengar (money) och tid (i).
               - Hur mycket hade du kunnat spara ihop innan du själv går i pension?
               - Vad händer när "money"-summan går över 10 miljoner?
            4) Hur kan man ändra for-loopen, så vi använder "year" istället för "i"?
               Tips: for (int year=startYear; ... )
            5) Vad har pengarna för faktisk köpkraft varje år? D.v.s hur mycket drar Sveriges inflation ner värdet?
               Inflationen brukar i genomsnitt vara 2% per år.
        */

        // Först, skapa några variabler som vi kan använda som grund
        double interest = 1.08; // Vad är den årliga räntan?
        double money = 12000; // Hur mycket pengar startar vi med?
        int startYear = 2020; // Vilket år startar vi?

        int birthYear = 1996;

        double moneyPerMonth = 5000; // Hur mycket pengar vi lägger undan var måndad

        double targetMoney = 10_000_000;

        // Skriv ut vilka värden vi startar med
        System.out.println("Starting money: " + money);
        System.out.println("Interest: " + interest);

        // Räkna ut hur pengarna ändras år för år
        int i = 0;
        while(money < targetMoney){
            // Hur mycket pengar har vi vid årets start?

            // Multiplicera med räntan för att få avkastning vid årets slut
            money = money * interest;

            // Addera under året insatt belop
            money += moneyPerMonth * 12;

            //Subtrahera inflationen
            money -= money * 0.02;

            System.out.printf("Year: %d; Age: %d. Money: %.2f\n", (startYear + i),(startYear + i) - birthYear, money);

            i++;
        }
    }
}
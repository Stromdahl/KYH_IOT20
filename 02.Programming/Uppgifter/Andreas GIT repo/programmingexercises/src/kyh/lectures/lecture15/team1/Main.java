package kyh.lectures.lecture15.team1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Fråga användaren om två filer
        // 1. Läs innehållet i en fil
        // 2. Översätt till rövarspråk
        // 3. Skriv ut till en fil

        Scanner sc = new Scanner(System.in);

        System.out.print("Skriv fil att läsa från: ");
        String inFile = sc.nextLine();

        System.out.print("Skriv fil att skriva till: ");
        String outFile = sc.nextLine();

        // Läs in filen
        ArrayList<String> fileContents = readFile(new File(inFile));

        // Översätt till rövarspråk, och spara till en fil
        for (String line: fileContents) {
            writeFile(toPirateLang(line), new File(outFile));
        }
    }

    public static ArrayList<String> readFile(File file) {
        // Läs innehållet i en fil, returnerar innehållet
        ArrayList<String> fileContents = new ArrayList<>();

        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                fileContents.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            // Om filen inte finns:
            System.err.println("File does not exists");
        }

        return fileContents;
    }

    public static boolean isVowel(char c) {
        // True om c är en vokal
        // Annars false

        String str = String.valueOf(c).toLowerCase();

        // Vokaler: aouåeiyäö
        if (str.equals("a") || str.equals("o") || str.equals("u") || str.equals("å") ||
                str.equals("e") || str.equals("i") || str.equals("y") || str.equals("ä") || str.equals("ö")) {
            return true;
        } else {
            return false;
        }
    }

    public static String toPirateLang(String inText) {
        // Givet "Hello", returnera "HOHelollolo"

        StringBuilder resultStr = new StringBuilder();

        // Vilka är konsonanter, eller vokaler?
        for (int i=0; i < inText.length() ; i++) {
            // Tar ut bokstraven
            char c = inText.charAt(i);

            if (isVowel(c)) {
                // Vid vokal: Lägg till på resultatet
                resultStr.append(c);
            } else {
                // Konvertera konsonant till rövarspråk
                // -- Skriv ut konsonanten
                // -- Skriv ut ett "o"
                // -- Skriv ut konsonanten igen

                resultStr.append(c);

                boolean isUpper = Character.isUpperCase(c);
                if (isUpper) {
                    resultStr.append('O');
                } else {
                    resultStr.append('o');
                }

                resultStr.append(c);
            }
        }

        return resultStr.toString();
    }

    public static void writeFile(String pirateText, File file) {
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(pirateText + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

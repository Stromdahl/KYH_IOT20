package kyh.lectures.lecture15.team2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    /**
     * Returns the content of a text file
     * @param pathOfInputFile path of the input file
     * @return the content of a text file
     */
    String readFile(String pathOfInputFile) {
        String content = "";
        File file = new File(pathOfInputFile);
        Scanner sc;
        try {
            sc = new Scanner(file);
            while(sc.hasNextLine()) {
                content += sc.nextLine() + "\n";
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        return content;
    }

    /**
     * Returns a string that is converted to pirate language
     * @param input the string to be converted
     * @return a string converted to pirate language
     */
    String convertToPirateLanguage(String input) {
        String result = "";
        String consonants = "bcdfghjklmnpqrstvwxz";
        String upperCons = consonants.toUpperCase();
        for(char x: input.toCharArray()) {
            if(consonants.contains(x+"")) {
                result += x + "o" + x;
            } else if(upperCons.contains(x+"")) {
                result += x + "O" + x;
            } else {
                result += x;
            }
        }
        return result;
    }

    /**
     * Saves a string to a text file
     * @param path path of destination file
     * @param content string to write to a textfile
     */
    void saveToFile(String path, String content) {
        try {
            File file = new File(path);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            System.out.println("The new file has been created on " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Could not write to file");
        }
    }

    public static void main(String[] args) {
        System.out.println("Please provide original input file path.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Please provide output file path.");
        String output = sc.nextLine();
        sc.close();
        Main main = new Main();
        String originalFileContent = main.readFile(input);
        String pirateContent = main.convertToPirateLanguage(originalFileContent);
        main.saveToFile(output, pirateContent);
    }
}

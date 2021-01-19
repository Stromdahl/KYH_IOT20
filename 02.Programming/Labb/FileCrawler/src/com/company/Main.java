package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Välkommen till FileCrawler 3000"); //input för READ
        System.out.print("Skriv in ditt sökord: ");

        String searchWord = scan.nextLine();

        try {
            if (searchWord.equals("Hello")) {
                throw new NotHelloExeption();
            }
        } catch (NotHelloExeption e){
            System.err.println("Hello not allowed");
            return;
        }

        String userDir = System.getProperty("user.dir");
        File filesDir = new File(userDir);
        findFiles(searchWord, filesDir);
    }

    //Function to check if the file contains the search word
    public static boolean fileContains(File file, String searchWord){
        try{
            // Create a scanner to read file
            Scanner fileScanner = new Scanner(file);
            // Read each line for to find the search word
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                if(line.contains(searchWord))
                {
                    return true;
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            try {
                System.err.println(file.getCanonicalPath());
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
        }

        return false;
    }


    public static void findFiles(String searchWord, File files){
        // List all files in directory
        File[] fileDirectory = files.listFiles();
        // Loop thru each file
        for(File file : fileDirectory){
            if(file.isDirectory()){
                findFiles(searchWord, file);
            } else {
                if (fileContains(file, searchWord)) {
                    try {
                        System.out.println(file.getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
package kyh.lectures.lecture15.team1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    /*
    *
    * Det andra testet testar att meningen “Hello World” skrivs ut rätt.
    * Det tredje testet är ett negativt test för en valfri textsträng.
     */

    @Test
    @DisplayName("Test error message")
    public void testErrorMessage() {
        // Testa att ett fel skrivs ut till System.error om inputfilen inte finns.

        // 1. Ända så vi fånga stderr
        // - Allt som skrivs ut med System.err.println() kommer fångas.
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));

        // 2. Kör funktionen, och fånga output
        // - Ta in en sökväg till en fil som inte finns
        Main.readFile(new File("path/to/file.txt"));

        String actualOutput = outContent.toString().trim();
        String expectedOutput = "File does not exists";

        // 3. Kolla att output är vad vi förväntar oss (assert)
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("Test file that exists")
    public void testFileExists() {
        String fileStr = "testData/Drycker/Vatten.txt";
        ArrayList<String> fileContents = Main.readFile(new File(fileStr));

        // Vatten.txt innehåller:
        // Vatten

        // System.out.println("File contents: " + fileContents.get(0));

        // Filen ska innehålla raden "Vatten"
        assertEquals("Vatten", fileContents.get(0));

        // fileContents.size() ska vara 1
        assertEquals(1, fileContents.size());
    }

    @Test
    @DisplayName("Test file with multiple lines")
    public void testMultipleLines() {
        String fileStr = "testData/Ost.txt";
        ArrayList<String> fileContents = Main.readFile(new File(fileStr));

        // Ost.txt innehåller:
        // Mjölk
        // Hål
        // Mögel

        /*System.out.println("File contents:");
        for (String element : fileContents) {
            System.out.println(element);
        }*/

        // Testa filens innehåll
        assertEquals("Mjölk", fileContents.get(0));
        assertEquals("Hål", fileContents.get(1));
        assertEquals("Mögel", fileContents.get(2));

        // fileContents.size() ska vara 3
        assertEquals(3, fileContents.size());
    }

    @Test
    @DisplayName("Test converting a line to robber language")
    public void testTranslateALine() {
        // Hello
        // HOHelollolo
        // 1. Vid vokal: skriv ut vokalen
        // 2. Vid konsonant
        // -- Skriv ut konsonanten
        // -- Skriv ut ett "o"
        // -- Skriv ut konsonanten igen

        // Skicka in en rad text
        String inText = "Hello";
        String actualText = Main.toPirateLang(inText);
        String expectedText = "HOHelollolo";

        assertEquals(expectedText, actualText);
    }

    @Test
    @DisplayName("Test vowel detection")
    public void testVowel() {
        assertTrue(Main.isVowel('a'));
        assertTrue(Main.isVowel('o'));
        assertTrue(Main.isVowel('u'));
        assertTrue(Main.isVowel('å'));
        assertTrue(Main.isVowel('e'));
        assertTrue(Main.isVowel('i'));
        assertTrue(Main.isVowel('y'));
        assertTrue(Main.isVowel('ä'));
        assertTrue(Main.isVowel('ö'));
        assertFalse(Main.isVowel('f'));
        assertFalse(Main.isVowel('g'));
        assertFalse(Main.isVowel('x'));
    }
}

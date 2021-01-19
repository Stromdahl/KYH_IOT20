package kyh.lectures.lecture15.team2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MainTest {
    @Test
    @DisplayName("Check if method prints error message if file not found")
    void readSystemError() {
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        Main main = new Main();
        main.readFile("testData/Rovarspra.txt");
        assertEquals("File not found", errContent.toString().trim());
    }

    @Test
    @DisplayName("Check if method convertToBanditLanguage returns  a correctly converted string")
    void checkText() {
        Main main = new Main();
        assertEquals("HOHelollolo WOWororloldod", main.convertToPirateLanguage("Hello World"));
    }

    @Test
    @DisplayName("Check if method convertToBanditLanguage does not return an incorrectly converted string")
    void checkTextNegative() {
        Main main = new Main();
        assertNotEquals("Hello World", main.convertToPirateLanguage("Hello World"));
    }
}

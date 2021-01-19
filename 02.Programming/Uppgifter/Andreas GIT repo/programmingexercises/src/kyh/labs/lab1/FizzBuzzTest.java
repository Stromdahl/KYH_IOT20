package kyh.labs.lab1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    @Test
    void main() {
        /* Runs Main.main() from student code, captures stdout, and compares against a predefined string */

        // Setup test to capture stdout
        // After this all System.out.println() statements will come to outContent stream.
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call main to run FizzBuzz
        //FizzBuzz.main(null);

        // Deal with line breaks that are different between systems. Convert all other line breaks to \n.
        String actualOutput = outContent.toString();
        actualOutput = actualOutput.replace("\r\n", "\n"); // Windows uses \r\n
        actualOutput = actualOutput.replace("\r", "\n"); // Old MacOs uses \r

        //Now you have to validate the output
        String expectedOutput =
            "1\n" +
            "2\n" +
            "Fizz\n" +
            "4\n" +
            "Buzz\n" +
            "Fizz\n" +
            "7\n" +
            "8\n" +
            "Fizz\n" +
            "Buzz\n" +
            "11\n" +
            "Fizz\n" +
            "13\n" +
            "14\n" +
            "FizzBuzz\n" +
            "16\n" +
            "17\n" +
            "Fizz\n" +
            "19\n" +
            "Buzz\n" +
            "Fizz\n" +
            "22\n" +
            "23\n" +
            "Fizz\n" +
            "Buzz\n" +
            "26\n" +
            "Fizz\n" +
            "28\n" +
            "29\n" +
            "FizzBuzz\n" +
            "31\n" +
            "32\n" +
            "Fizz\n" +
            "34\n" +
            "Buzz\n" +
            "Fizz\n" +
            "37\n" +
            "38\n" +
            "Fizz\n" +
            "Buzz\n" +
            "41\n" +
            "Answer to the Ultimate Question of Life, the Universe, and Everything\n" +
            "43\n" +
            "44\n" +
            "FizzBuzz\n" +
            "46\n" +
            "47\n" +
            "Fizz\n" +
            "49\n" +
            "Buzz\n" +
            "Fizz\n" +
            "52\n" +
            "53\n" +
            "Fizz\n" +
            "Buzz\n" +
            "56\n" +
            "Fizz\n" +
            "58\n" +
            "59\n" +
            "FizzBuzz\n" +
            "61\n" +
            "62\n" +
            "Fizz\n" +
            "64\n" +
            "Buzz\n" +
            "Fizz\n" +
            "67\n" +
            "68\n" +
            "Fizz\n" +
            "Buzz\n" +
            "71\n" +
            "Fizz\n" +
            "73\n" +
            "74\n" +
            "FizzBuzz\n" +
            "76\n" +
            "77\n" +
            "Fizz\n" +
            "79\n" +
            "Buzz\n" +
            "Fizz\n" +
            "82\n" +
            "83\n" +
            "Fizz\n" +
            "Buzz\n" +
            "86\n" +
            "Fizz\n" +
            "88\n" +
            "89\n" +
            "FizzBuzz\n" +
            "91\n" +
            "92\n" +
            "Fizz\n" +
            "94\n" +
            "Buzz\n" +
            "Fizz\n" +
            "97\n" +
            "98\n" +
            "Fizz\n" +
            "Buzz\n";

        // Do the actual assertion
        assertEquals(expectedOutput, actualOutput);
    }
}
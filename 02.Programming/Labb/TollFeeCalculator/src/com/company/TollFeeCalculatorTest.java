package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class TollFeeCalculatorTest {
    TollFeeCalculator tollFeeCalculator = new TollFeeCalculator("testData/Lab4_f.txt");

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    public LocalDateTime parseStringToDate(String dateString) throws DateTimeException {
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    @BeforeEach
    void setup(){
        System.setErr(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Testing TollFeeCalculator")
    void testFileNotFound(){

        System.setErr(new PrintStream(outputStreamCaptor));

        //Test if IOException is caught if the given file doesn't exist
        String inputFile = "testData/notLab4.txt";
        new TollFeeCalculator(inputFile);
        assertEquals("Could not find file: " + inputFile, outputStreamCaptor.toString().trim());
    }


    @Test
    @DisplayName("Test that getDates returns correct array lengths")
    void testGetDates(){
        // Test that getDates returns a array with correct length
        String[] dateStrings = {
                "2020-06-01 07:00",
                "2020-06-35 08:30",
                "2020-06-01 14:00"
        };

        assertEquals(dateStrings.length, tollFeeCalculator.getDates(dateStrings).length);

        assertEquals(String.format("Could not parse \"%s\", it´s not a valid date", dateStrings[1]), outputStreamCaptor.toString().trim());

    }

    @Test
    @DisplayName("Testing parseStringsToDates")
    void testParseStringToDate(){
        //Test a string with a valid date
        String dateString = "2020-06-30 02:00";
        LocalDateTime date = parseStringToDate(dateString);
        assertEquals(date, parseStringToDate(dateString));

    }

    @Test
    @DisplayName("Testing getTotalFeeCost")
    void testGetTotalFeeCost(){

        this.testParseStringToDate();

        //Test total fee.
        LocalDateTime[] datesTest1 = {
                parseStringToDate("2020-06-01 07:00"), //18
                parseStringToDate("2020-06-01 08:30"), //8
                parseStringToDate("2020-06-01 14:00"), //8
                parseStringToDate("2020-06-01 17:00")  //13
        };
        assertEquals(47, tollFeeCalculator.getTotalFeeCost(datesTest1));

        //test max fee
        LocalDateTime[] datesTest2 = {
                parseStringToDate("2020-06-01 07:00"), //18
                parseStringToDate("2020-06-01 08:30"), //8
                parseStringToDate("2020-06-01 14:00"), //8
                parseStringToDate("2020-06-01 16:00"), //13
                parseStringToDate("2020-06-01 17:30"), //18
        };
        assertEquals(60, tollFeeCalculator.getTotalFeeCost(datesTest2));

        //test with dates less than 60 minutes apart
        LocalDateTime[] datesTest3 = {
                parseStringToDate("2020-06-30 06:01"), //8
                parseStringToDate("2020-06-30 06:33"), //13
                parseStringToDate("2020-06-30 08:20"), //18
                parseStringToDate("2020-06-30 09:15"), //13
                parseStringToDate("2020-06-30 14:35"), //8
                parseStringToDate("2020-06-30 15:15"), //8
        };
        assertEquals(39, tollFeeCalculator.getTotalFeeCost(datesTest3));
    }


    @Test
    @DisplayName("Testing getTollFeePerPassing")
    void testGetTollFeePerPassing(){

        this.testParseStringToDate();

        assertEquals(8, tollFeeCalculator.getTollFeePerPassing(parseStringToDate("2020-06-01 06:00")));
        assertEquals(13, tollFeeCalculator.getTollFeePerPassing(parseStringToDate("2020-06-01 06:30")));
        assertEquals(18, tollFeeCalculator.getTollFeePerPassing(parseStringToDate("2020-06-01 07:00")));
        assertEquals(13, tollFeeCalculator.getTollFeePerPassing(parseStringToDate("2020-06-01 08:00")));
        assertEquals(8, tollFeeCalculator.getTollFeePerPassing(parseStringToDate("2020-06-01 08:30")));
        assertEquals(8, tollFeeCalculator.getTollFeePerPassing(parseStringToDate("2020-06-01 14:00")));
        assertEquals(13, tollFeeCalculator.getTollFeePerPassing(parseStringToDate("2020-06-01 15:00")));
        assertEquals(18, tollFeeCalculator.getTollFeePerPassing(parseStringToDate("2020-06-01 15:30")));
        assertEquals(18, tollFeeCalculator.getTollFeePerPassing(parseStringToDate("2020-06-01 16:00")));
        assertEquals(13, tollFeeCalculator.getTollFeePerPassing(parseStringToDate("2020-06-01 17:00")));
        assertEquals(8, tollFeeCalculator.getTollFeePerPassing(parseStringToDate("2020-06-01 18:00")));
        assertEquals(0, tollFeeCalculator.getTollFeePerPassing(parseStringToDate("2020-06-01 23:00")));
    }

    @Test
    @DisplayName("Testing isTollFreeDate")
    void testIsTollFreeDate(){
        // Create a date that is not weekend and not month 7
        LocalDateTime date = LocalDateTime.parse("2020-06-01 00:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertFalse(tollFeeCalculator.isTollFreeDate(date));
        // Create a date that is on a saturday
        LocalDateTime dateWeekday6 = LocalDateTime.parse("2020-06-06 00:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertTrue(tollFeeCalculator.isTollFreeDate(dateWeekday6));
        // Create a date that is on a sunday
        LocalDateTime dateWeekday7 = LocalDateTime.parse("2020-06-07 00:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertTrue(tollFeeCalculator.isTollFreeDate(dateWeekday7));
        // Create a date that is in July (month 7)
        LocalDateTime dateMonth7 = LocalDateTime.parse("2020-07-07 00:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertTrue(tollFeeCalculator.isTollFreeDate(dateMonth7));

    }

}
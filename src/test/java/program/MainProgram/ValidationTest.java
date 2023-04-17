package program.MainProgram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    void calculateTimeDifference() {
        assertEquals( "00:00",Validation.calculateTimeDifference("12:00", "12:00"));
        assertEquals( "00:01",Validation.calculateTimeDifference("12:00", "12:01"));
        assertEquals( "11:02",Validation.calculateTimeDifference("01:00", "12:02"));
        assertEquals( "23:23",Validation.calculateTimeDifference("00:00", "23:23"));
        assertEquals( "00:00",Validation.calculateTimeDifference("25:00", "25:30"));
        assertEquals( "00:00",Validation.calculateTimeDifference("0:10", "1:5"));
        assertEquals( "00:00",Validation.calculateTimeDifference("04:101", "04:102"));
        assertEquals( "00:00",Validation.calculateTimeDifference("abc", "abc"));
        assertEquals( "00:00",Validation.calculateTimeDifference("1", "1"));

    }

    @Test
    void validateTimeInput() {
        assertTrue(Validation.validateTimeInput("12:00"));
        assertTrue(Validation.validateTimeInput("00:00"));
        assertTrue(Validation.validateTimeInput("23:59"));
        assertFalse(Validation.validateTimeInput("12:60"));
        assertFalse(Validation.validateTimeInput("24:00"));
        assertFalse(Validation.validateTimeInput("12:00:00"));
        assertFalse(Validation.validateTimeInput("12:00am"));
        assertFalse(Validation.validateTimeInput("12:00pm"));
    }

    @Test
    void validateDistanceInput() {
        assertTrue(Validation.validateDistanceInput("1"));
        assertTrue(Validation.validateDistanceInput("1.0"));
        assertTrue(Validation.validateDistanceInput("1.00"));
        assertFalse(Validation.validateDistanceInput("1.000"));
        assertTrue(Validation.validateDistanceInput("1.45"));
        assertFalse(Validation.validateDistanceInput("1.476"));
        assertFalse(Validation.validateDistanceInput("-10.5"));
        assertFalse(Validation.validateDistanceInput("10.5.5"));
        assertFalse(Validation.validateDistanceInput("10km"));
    }

    @Test
    void calculateMinutes() {
        assertEquals(0,Validation.calculateMinutes("00:00"));
        assertEquals(1,Validation.calculateMinutes("00:01"));
        assertEquals(60,Validation.calculateMinutes("01:00"));
        assertEquals(1439,Validation.calculateMinutes("23:59"));
        assertEquals(0,Validation.calculateMinutes("abc"));
        assertEquals(0,Validation.calculateMinutes("1"));
    }
}
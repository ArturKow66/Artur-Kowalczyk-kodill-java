package com.kodilla.stream.array;

import org.junit.jupiter.api.*;

import java.util.OptionalDouble;

@DisplayName("Test ArrayOperations")
public class ArrayOperationsTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("The beginning of tests");
    }

    @AfterAll
    public static void afterAllTests(){
        System.out.println("The end of all tests");
    }

    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Execute test #" + testCounter);
    }

    @DisplayName("Test: getAverage()")
    @Test
    void testGetAverage(){
        //Given
        int[] numbers = new int[20];
        numbers[0] = 4;
        numbers[1] = 42;
        numbers[2] = 52;
        numbers[3] = 1;
        numbers[4] = 44;
        numbers[5] = 75;
        numbers[6] = 8;
        numbers[7] = 13;
        numbers[8] = 20;
        numbers[9] = 42;
        numbers[10] = 78;
        numbers[11] = 78;
        numbers[12] = 38;
        numbers[13] = 24;
        numbers[14] = 48;
        numbers[15] = 85;
        numbers[16] = 75;
        numbers[17] = 99;
        numbers[18] = 49;
        numbers[19] = 75;

        //When
        OptionalDouble result = ArrayOperations.getAverage(numbers);
        OptionalDouble expected = OptionalDouble.of(47.5);
        //Then
        Assertions.assertEquals(expected, result);

    }
}

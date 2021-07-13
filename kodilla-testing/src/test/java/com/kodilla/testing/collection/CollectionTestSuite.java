package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Random;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }

    @DisplayName("When created empty list for Odd Numbers Exterminator" +
            "Then size() of list should return 0"
    )
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> newList = new ArrayList<>();

        //When
        ArrayList<Integer> result = exterminator.exterminate(newList);
        System.out.println("Size of list: " + result.size());

        //Then
        Assertions.assertEquals(0, result.size());
        System.out.println("New list is empty");
    }

    @DisplayName("When created normal list of Odd Numbers Exterminator" +
            "Then exterminate() should "
    )
    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        //When
        ArrayList<Integer> newList = new ArrayList<>();
        Random generator = new Random();
        for (int i = 0; i < 50; i++) {
            newList.add(generator.nextInt(50));
        }
        ArrayList<Integer> result = oddNumbersExterminator.exterminate(newList);
        System.out.println("Size of list: " + result.size());

        //Then
        Assertions.assertNotEquals(newList, result);
        System.out.println("Only even numbers in list\n");
        for (Integer newNumber: result){
            if (newNumber % 2 == 0){
                System.out.println("Even number " + newNumber);
            } else {
                System.out.println("Error");
            }
        }
        System.out.println("Only even numbers in list");
    }
}

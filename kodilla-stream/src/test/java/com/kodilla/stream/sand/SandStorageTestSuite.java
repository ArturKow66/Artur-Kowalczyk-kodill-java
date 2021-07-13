package com.kodilla.stream.sand;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.*;

@DisplayName("Test SandStorage")
public class SandStorageTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("The beginning of tests");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("The end of all tests");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Execute test #" + testCounter);
    }

    @DisplayName("Test: getSandBeansQuantity()")
    @Test
    void testGetSandBeansQuantity() {
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());

        //When
        BigDecimal totalSand = BigDecimal.ZERO;
        for (SandStorage continent : continents) {
            totalSand = totalSand.add(continent.getSandBeansQuantity());
        }

        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        Assertions.assertEquals(expectedSand, totalSand);
    }

    @DisplayName("Test: getSandBeansQuantityWithReduce()")
    @Test
    void testGetSandBeansQuantityWithReduce() {
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());

        //When
        BigDecimal totalSand = continents.stream()
                .map(SandStorage::getSandBeansQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        Assertions.assertEquals(expectedSand, totalSand);
    }
}
package com.kodilla.stream.world;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.ArrayList;

@DisplayName("Test World")
public class WorldTestSuite {

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

    @DisplayName("Test: getPeopleQuantity()")
    @Test
    public void testGetPeopleQuantity(){
        //Given
        //continent1
        Continent continent1 = new Continent("continent1", new ArrayList<>());
        continent1.addCountry(new Country("Country 1", new BigDecimal(1)));
        continent1.addCountry(new Country("Country 2", new BigDecimal(1)));
        continent1.addCountry(new Country("Country 3", new BigDecimal(1)));
        continent1.addCountry(new Country("Country 4", new BigDecimal(1)));
        continent1.addCountry(new Country("Country 5", new BigDecimal(1)));
        //continent1
        Continent continent2 = new Continent("continent1", new ArrayList<>());
        continent1.addCountry(new Country("Country 1", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 2", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 3", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 4", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 5", new BigDecimal("1")));
        //continent1
        Continent continent3 = new Continent("continent1", new ArrayList<>());
        continent1.addCountry(new Country("Country 1", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 2", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 3", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 4", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 5", new BigDecimal("1")));
        //continent1
        Continent continent4 = new Continent("continent1", new ArrayList<>());
        continent1.addCountry(new Country("Country 1", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 2", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 3", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 4", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 5", new BigDecimal("1")));

        World world = new World(new ArrayList<>());
        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);
        world.addContinent(continent4);


        //When
        BigDecimal peopleQuantity = world.getPeopleQuantity();
        BigDecimal expected = new BigDecimal("20");
        //Then
        Assertions.assertEquals(expected, peopleQuantity);
        System.out.println(peopleQuantity);
    }
}

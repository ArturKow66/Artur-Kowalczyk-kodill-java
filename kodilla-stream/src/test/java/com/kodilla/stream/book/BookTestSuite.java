package com.kodilla.stream.book;

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.IntStream;

@DisplayName("Test Book")
public class BookTestSuite {

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

    @DisplayName("Test: getListUsingFor()")
    @Test
    void testGetListUsingFor() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = 0;
        for (Book book : books) {
            if (book.getYearOfPublication() > 2007) {
                numberOfBooksPublicatedAfter2007++;
            }
        }
        Assertions.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @DisplayName("Test: getListUsingIntStream()")
    @Test
    void testGetListUsingIntStream() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .map(n -> 1)
                .sum();
        Assertions.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @DisplayName("Test: getListUsingIntStreamCount()")
    @Test
    void testGetListUsingIntStreamCount() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        long numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count();
        Assertions.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
}

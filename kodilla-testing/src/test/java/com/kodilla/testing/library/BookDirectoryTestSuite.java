package com.kodilla.testing.library;

import com.kodilla.testing.libraby.Book;
import com.kodilla.testing.libraby.BookLibrary;
import com.kodilla.testing.libraby.LibraryDatabase;
import com.kodilla.testing.libraby.LibraryUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    private static int testCounter = 0;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Mock
    private LibraryDatabase libraryDatabaseMock;

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

    @Nested
    @DisplayName("Test List Books With Conditions")
    class TestListBookWithCondition {
        @DisplayName("Test: listBooksWithConditionsReturnList()")
        @Test
        void testListBooksWithConditionsReturnList() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);                  // [3]
            List<Book> resultListOfBooks = new ArrayList<>();                                // [4]
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);                 // [8]
            resultListOfBooks.add(book1);                                                    // [9]
            resultListOfBooks.add(book2);                                                    // [10]
            resultListOfBooks.add(book3);                                                    // [11]
            resultListOfBooks.add(book4);                                                    // [12]
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);// [13]

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");        // [14]

            // Then
            Assertions.assertEquals(4, theListOfBooks.size());
        }

        @DisplayName("Test: listBooksWithConditionMoreThan20()")
        @Test
        void testListBooksWithConditionMoreThan20() {
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);                  // [1]
            List<Book> resultListOf0Books = new ArrayList<>();                           // [2]
            List<Book> resultListOf15Books = generateListOfNBooks(15);                       // [3]
            List<Book> resultListOf40Books = generateListOfNBooks(40);                       // [4]
            when(libraryDatabaseMock.listBooksWithCondition(anyString()))                    // [5]
                    .thenReturn(resultListOf15Books);                                             // [6]
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))                    // [7]
                    .thenReturn(resultListOf0Books);                                              // [8]
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))                   // [9]
                    .thenReturn(resultListOf40Books);                                             // [10]

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");    // [11]
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");   // [12]
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");  // [13]
            // Then

            Assertions.assertEquals(0, theListOfBooks0.size());                                         // [14]
            Assertions.assertEquals(15, theListOfBooks15.size());                                       // [15]
            Assertions.assertEquals(0, theListOfBooks40.size());
        }

        @DisplayName("Test: listBooksWithConditionFragmentShorterThan3()")
        @Test
        void testListBooksWithConditionFragmentShorterThan3() {
            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);            // [2]
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);               // [3]

            // When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");       // [4]

            // Then
            Assertions.assertEquals(0, theListOfBooks10.size());                                     // [5]
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }

    @Nested
    @DisplayName("Test List Books In Hands Of")
    class TestListBooksInHandsOf {

        @DisplayName("Test: listBooksInHandsOf()")
        @Test
        void testListBooksInHandsOf() {
            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<>();
            List<Book> resultListOf1Book = generateListOfNBooks(1);
            List<Book> resultListOf5Books = generateListOfNBooks(5);
            LibraryUser userWith0Books = new LibraryUser("Adam", "Zero", "000");
            LibraryUser userWith1Book = new LibraryUser("Adam", "One", "111");
            LibraryUser userWith5Books = new LibraryUser("Adam", "Five", "555");
            when(libraryDatabaseMock.listBooksInHandsOf(userWith0Books)).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksInHandsOf(userWith1Book)).thenReturn(resultListOf1Book);
            when(libraryDatabaseMock.listBooksInHandsOf(userWith5Books)).thenReturn(resultListOf5Books);

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksInHandsOf(userWith0Books);
            List<Book> theListOfBook1 = bookLibrary.listBooksInHandsOf(userWith1Book);
            List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(userWith5Books);

            // Then
            Assertions.assertEquals(0, theListOfBooks0.size());
            Assertions.assertEquals(1, theListOfBook1.size());
            Assertions.assertEquals(5, theListOfBooks5.size());
        }
    }
}

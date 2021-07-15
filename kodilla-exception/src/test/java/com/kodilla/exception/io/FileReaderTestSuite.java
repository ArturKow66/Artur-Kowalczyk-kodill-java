package com.kodilla.exception.io;

import org.junit.jupiter.api.*;

@DisplayName("FileReader Test Suite")
public class FileReaderTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test suite: begin");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Test suite: end");
    }

    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Execute test #" + testCounter);
    }

    @DisplayName("Test: readFile()")
    @Test
    void testReadFile() {
        // given
        FileReader fileReader = new FileReader();
        // when & then
        Assertions.assertDoesNotThrow(() -> fileReader.readFile());
    }

    @DisplayName("Test: whenFileDosentExistsReadFileShouldThrowException()")
    @Test
    void whenFileDosentExistsReadFileShouldThrowException() {
        // given
        FileReader fileReader = new FileReader();
        String fileName = "nie_ma_takiego_pliku.txt";
        // when & then
        Assertions.assertThrows(FileReaderException.class, () -> fileReader.readFile(fileName));
    }

    @DisplayName("Test: readFileWithName()")
    @Test
    public void testReadFileWithName() {
        // given
        FileReader fileReader = new FileReader();
        // when & then
        Assertions.assertAll(
                () -> Assertions.assertThrows(FileReaderException.class, () -> fileReader.readFile("nie_ma_takiego_pliku.txt")),
                () -> Assertions.assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> Assertions.assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );
    }
}

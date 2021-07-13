package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("TDD: Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

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

    @Nested
    @DisplayName("Test for figure")
    class TestFigure{
        @Test
        void testAddFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(new Circle("cno1", 3.0));
            shapeCollector.addFigure(new Square("sno1", 4.0));
            shapeCollector.addFigure(new Triangle("tno1", 3.0,4.0));
            int result = shapeCollector.getShapeCollectorSize();

            //Then
            Assertions.assertEquals(3,result);
        }

        @Test
        void testRemoveFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(new Circle("cno2", 4.0));
            shapeCollector.removeFigure(0);
            int result = shapeCollector.getShapeCollectorSize();

            //Then
            Assertions.assertEquals(0, result);
        }

        @Test
        void testGetFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            Circle circle1 = new Circle("cno3", 5.0);
            shapeCollector.addFigure(circle1);
            Shape result = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(circle1, result);
        }

        @Test
        void testShowFigures(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(new Square("sno2", 2.0));
            String result = shapeCollector.showFigures();

            //Then
            Assertions.assertEquals("square with field of: 4.0", result);
        }
    }
}

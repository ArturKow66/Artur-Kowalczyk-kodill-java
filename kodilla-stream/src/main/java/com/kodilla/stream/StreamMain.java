package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.beautyfier.PoemBeautifier;
import com.kodilla.stream.preson.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        System.out.println("Welcome to module 7 - Stream");
        System.out.println();

        //1
        SaySomething saySomething = new SaySomething();
        saySomething.say();
        System.out.println();

        //2.0
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text."));

        //2.1
        processor.execute(() -> System.out.println("This is an example text!."));
        System.out.println();

        //3.0
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        //3.1
        System.out.println("\nCalculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        System.out.println();

        //3.2
        System.out.println("\nCalculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
        System.out.println();

        //4
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String strToBeaut = "Not so nice Text for Beautifier";
        poemBeautifier.beautify(strToBeaut, (toDecorate -> toDecorate.toUpperCase()));
        poemBeautifier.beautify(strToBeaut, (toDecorate -> toDecorate.concat(" ABC")));
        poemBeautifier.beautify(strToBeaut, (toDecorate -> toDecorate.toLowerCase()));
        poemBeautifier.beautify(strToBeaut, (toDecorate -> "ABC" + toDecorate + "ABC"));
        System.out.println();

        //5
        System.out.println("\nUsing Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
        System.out.println();

        //6.1
        People.getList().stream()
                .forEach(System.out::println);
        System.out.println();

        //6.2 Transforming operation
        People.getList().stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
        System.out.println();

        //6.3 Transforming operation
        People.getList().stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println();

        //6.4 Filtration operation
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);
        System.out.println();

        //6.5 Cascading combining operations
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);
        System.out.println();

        //7.0
        BookDirectory theBookDirectory = new BookDirectory();

        //7.1 Stream on collections with any objects
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);
        System.out.println();

        //7.2 Terminal operations - Collectors.toList()
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);
        System.out.println();

        //7.3 Terminal operations - Collectors.toMap()
        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
        System.out.println();

        //7.4 Terminal operations - Collectors.joining()
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
        System.out.println();
    }
}

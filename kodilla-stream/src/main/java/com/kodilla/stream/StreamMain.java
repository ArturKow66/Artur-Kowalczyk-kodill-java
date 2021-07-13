package com.kodilla.stream;

import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.beautyfier.PoemBeautifier;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args) {

        System.out.println("Welcome to module 7 - Stream");

        //1
        SaySomething saySomething = new SaySomething();
        saySomething.say();

        //2.0
        Processor processor = new Processor();

        //2.1
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();


        //2.2
        Executor codeToExecute = () -> System.out.println("This is an example text!");


        //2.3
        processor.execute(() -> System.out.println("This is an example text!."));

        //3.0
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        //3.1
        System.out.println("\nCalculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

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
        //5
        System.out.println("\nUsing Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);


    }
}

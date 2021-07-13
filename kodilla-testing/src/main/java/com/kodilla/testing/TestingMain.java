package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {

        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        SimpleUser simpleUser = new SimpleUser("theForumUser");
        Calculator calculator = new Calculator(6, 4);

        String result = simpleUser.getUsername();
        int sum = calculator.addAToB();
        int subtraction = calculator.subtractBFromA();


        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //Test
        System.out.println("Test 1. Adding");

        if (sum == 10) {
            System.out.println("Test 1. ok");
        } else {
            System.out.println("Error - test 1.");
        }

        //Test
        System.out.println("Test 2. Adding");

        if (subtraction == 2) {
            System.out.println("Test 2. ok");
        } else {
            System.out.println("Error - test 2.");
        }

    }
}

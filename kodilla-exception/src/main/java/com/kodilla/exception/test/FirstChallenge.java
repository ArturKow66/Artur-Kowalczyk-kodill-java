package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            System.out.println("Result: " + firstChallenge.divide(10, 0));
        } catch (ArithmeticException a){
            System.out.println("Arithmetic error: " + a);
        } finally {
            System.out.println("Check for another numbers");
        }

    }
}

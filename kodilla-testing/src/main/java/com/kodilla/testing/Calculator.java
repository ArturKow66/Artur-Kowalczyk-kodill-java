package com.kodilla.testing;

public class Calculator {

    int a;
    int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int addAToB(){
        return a + b;
    }

    public int subtractBFromA(){
        return a - b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

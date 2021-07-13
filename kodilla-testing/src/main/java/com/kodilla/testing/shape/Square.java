package com.kodilla.testing.shape;

public class Square implements Shape {

    private String square;
    private double wallLength;
    private double squareField;

    public Square(String square, double wallLength){
        this.square = square;
        this.wallLength = wallLength;
    }

    public String getShapeName(){
        return "square";
    }

    public double getField(){
        return squareField = wallLength * wallLength;
    }

    @Override
    public String toString(){
        return getShapeName() + " with field of: " + getField();
    }
}

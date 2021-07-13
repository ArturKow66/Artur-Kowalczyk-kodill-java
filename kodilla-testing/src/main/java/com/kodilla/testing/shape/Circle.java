package com.kodilla.testing.shape;

public class Circle implements Shape {

    private String circle;
    private double circleRadius;
    private static double pi = 3.14;
    private double circleField;

    public Circle(String circle, double circleRadius){
        this.circle = circle;
        this.circleRadius = circleRadius;
    }

    public String getShapeName(){
        return "circle";
    }

    public double getField(){
        return circleField = circleRadius * circleRadius * pi;
    }

    @Override
    public String toString(){
        return getShapeName() + " with field of: " + getField();
    }
}

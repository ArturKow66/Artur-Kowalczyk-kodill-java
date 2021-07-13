package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private String triangle;
    private double triangleHeight;
    private double baseLength;
    private double triangleField;

    public Triangle(String triangle, double triangleHeight, double baseLength){
        this.triangle = triangle;
        this.triangleHeight = triangleHeight;
        this.baseLength = baseLength;
    }

    public String getShapeName(){
        return "triangle";
    }

    public double getField(){
        return triangleField = triangleHeight * baseLength / 2;
    }

    @Override
    public String toString(){
        return getShapeName() + " with field of: " + getField();
    }
}

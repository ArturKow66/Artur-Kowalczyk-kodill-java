package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapeCollector = new ArrayList<>();
    private String figure = "";

    public void addFigure(Shape shape){
        shapeCollector.add(shape);
    }

    public void removeFigure(int n){
        shapeCollector.remove(n);
    }

    public Shape getFigure(int f){
        return shapeCollector.get(f);
    }

    public String showFigures(){
        for(Shape theShape: shapeCollector){
            figure = figure + theShape;
        }
        return figure;
    }

    public int getShapeCollectorSize(){
        return shapeCollector.size();
    }
}

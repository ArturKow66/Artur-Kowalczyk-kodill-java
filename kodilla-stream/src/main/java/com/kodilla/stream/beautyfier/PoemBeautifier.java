package com.kodilla.stream.beautyfier;

public class PoemBeautifier {

    public void beautify(String toDecorate, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(toDecorate);
        System.out.println("Result of beautifier: " + result);
    }
}

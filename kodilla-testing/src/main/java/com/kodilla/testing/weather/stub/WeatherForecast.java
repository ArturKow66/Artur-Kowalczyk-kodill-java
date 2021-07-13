package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {

        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverage(){
        double resultSum = 0.0;
        double mapSize = 0.0;
        for (Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()){
            resultSum = resultSum + temperature.getValue();
            mapSize++;
        }
        return resultSum / mapSize;
    }

    public double calculateMedian() {
        List<Double> temperaturesForMedian = new ArrayList<>();

        for (Map.Entry<String, Double> theTemperature : temperatures.getTemperatures().entrySet()) {
            boolean valueIsBigger = false;
            int listCounter = 0;
            while (!valueIsBigger) {
                if (temperaturesForMedian.isEmpty()) {
                    temperaturesForMedian.add(listCounter, theTemperature.getValue());
                    valueIsBigger = true;
                } else if (listCounter == temperaturesForMedian.size()) {
                    temperaturesForMedian.add(theTemperature.getValue());
                    valueIsBigger = true;
                } else if (theTemperature.getValue() <= temperaturesForMedian.get(listCounter)) {
                    temperaturesForMedian.add(listCounter, theTemperature.getValue());
                    valueIsBigger = true;
                } else {
                    listCounter++;
                }
            }
        }

        int numberToGet;
        double median;

        if (temperaturesForMedian.size() % 2 == 0) {
            numberToGet = temperaturesForMedian.size() / 2;
            median = (temperaturesForMedian.get(numberToGet) + temperaturesForMedian.get(numberToGet - 1)) / 2;
        } else {
            numberToGet = (int) ((temperaturesForMedian.size() / 2) + 0.5);
            median = temperaturesForMedian.get(numberToGet);
        }
        return median;
    }
}

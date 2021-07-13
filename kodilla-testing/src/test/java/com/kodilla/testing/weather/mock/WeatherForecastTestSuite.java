package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@DisplayName("TDD: Weather Forecast Test Suite")
@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    private static int testCounter = 0;

    private Map<String, Double> generateTemperaturesMap() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        return temperaturesMap;
    }

    @Mock
    private Temperatures temperaturesMock;

    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("The beginning of tests");
    }

    @AfterAll
    public static void afterAllTests(){
        System.out.println("The end of all tests");
    }

    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Execute test #" + testCounter);
    }

    @DisplayName("Test: Calculate Forecast With Mock")
    @Test
    void testCalculateForecastWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = generateTemperaturesMap();
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @DisplayName("Test: Calculate Average Temperature")
    @Test
    void testCalculateAverageTemperature(){
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = generateTemperaturesMap();
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //When
        double averageTemperature = weatherForecast.calculateAverage();

        //Then
        Assertions.assertEquals(25.56, averageTemperature);
    }

    @DisplayName("Test: Calculate Median Of Temperature")
    @Test
    void testCalculateMedianOfTemperature(){
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = generateTemperaturesMap();
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //When
        double medianTemperature = weatherForecast.calculateMedian();

        //Then
        Assertions.assertEquals(25.5, medianTemperature);
    }
}

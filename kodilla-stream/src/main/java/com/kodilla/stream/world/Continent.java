package com.kodilla.stream.world;

import java.util.*;

public class Continent {

    private final String continentName;
    private List<Country> listOfCountries;

    public Continent(final String continentName, List<Country> listOfCountries){
        this.continentName = continentName;
        this.listOfCountries = listOfCountries;
    }
    public void addCountry(Country country){
        listOfCountries.add(country);
    }

    public List<Country> getListOfCountries(){
        return new ArrayList<>(listOfCountries);
    }
}

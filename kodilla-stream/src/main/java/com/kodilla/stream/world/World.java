package com.kodilla.stream.world;

import java.util.*;
import java.math.BigDecimal;

public final class World {
    private final List<Continent> listOfContinents;

    public World(List<Continent> listOfCountries){
        this.listOfContinents = listOfCountries;
    }

    public void addContinent(Continent continent){
        listOfContinents.add(continent);
    }

    public List<Continent> getListOfContinents(){
        return new  ArrayList<>(listOfContinents);
    }

    public BigDecimal getPeopleQuantity(){
        return listOfContinents.stream()
                .flatMap(continent -> continent.getListOfCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}

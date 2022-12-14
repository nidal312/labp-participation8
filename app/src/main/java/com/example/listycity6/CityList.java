package com.example.listycity6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        else{
            cities.add(city);
        }

    }

    /**
     * This deletes a city to the list if the city exists in the list
     * @param city
     * This is a candidate city to delete
     */
    public void delete(City city){
        if(!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }



    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List getCities() {
        List list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This method returns true if a city is contained in the ArrayList cities
     * @param city
     * @return Returns true if city is contianed in the list
     */
    public boolean hasCity(City city){
        if(cities.contains(city)){
            return true;
        }
        return false;
    }

    /**
     * This counts the number of cities in the list
     * @return the number of cities
     */
    public int countCities(){
        return getCities().size();
    }


}


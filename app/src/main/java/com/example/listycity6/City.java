package com.example.listycity6;


/**
 * This class defines a city. City (@link String) and province (@link String)
 * @author Nidal
 * @version 1.0
 *
 */
public class City implements Comparable{
    /**
     * This variable stores city name which is of type {@link String}
     */
    private String city;
    /**
     * This variable stores province name which is of type {@link String}
     */
    private String province;

    /**
     * This is a constructor for the City class to create City object packagename.classname.
     * @param city it stores name of city which is of type {@link String}
     * @param province it stores province name for the city object which is of type {@link String}
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * This function returns the city name
     * @return {@link #city}
     */
    String getCityName(){
        return this.city;
    }

    /**
     * This function returns the province name
     * @return {@link #province}
     */
    String getProvinceName(){
        return this.province;
    }

    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

}

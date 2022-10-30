package com.example.listycity6;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static java.time.Duration.ofMinutes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;


public class CityListTest {
    private CityList cityList = new CityList();
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    @DisplayName("Testing add fucntion of CityList class")
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertAll("Testing addition of second city",
                ()-> assertEquals(2, cityList.getCities().size()),
                ()-> assertTrue(cityList.getCities().contains(city)));
    }


    @Test
    void testAddException() {
        assertTimeout(ofMinutes(12),()->{
            CityList cityList = mockCityList();
            City city = new City("Yellowknife", "Northwest Territories");
            cityList.add(city);
            assertThrows( IllegalArgumentException.class, () -> {
                cityList.add(city); });

        });
    }

    @Test
    void testDelete(){
        CityList cityList = mockCityList();
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        cityList.delete(city);
        assertAll("Testing deletion of city",
                ()-> assertEquals(1,cityList.getCities().size()),
                ()-> assertFalse(cityList.getCities().contains(city)));

    }

    @Test
    void testDeleteException() {
        assertTimeout(ofMinutes(12),()->{
            CityList cityList = mockCityList();
            City city = new City("Yellowknife", "Northwest Territories");
            assertThrows( IllegalArgumentException.class, () -> {
                cityList.delete(city); });

        });
    }

    @Test
    void testhasCity(){
        CityList cityList = mockCityList();
        City city = new City("Calgary","Alberta");
        cityList.add(city);
        assertEquals(true,cityList.hasCity(city));
    }

    @Test
    void testCount(){
        CityList cityList = mockCityList();
        City city = new City("Dubai","UAE");
        cityList.add(city);
        City city2 = new City("Vancouver","British Columbia");
        cityList.add(city2);
        assertEquals(3, cityList.countCities());
        City city3 = new City("Toronto","Ontario");
        cityList.add(city3);
        assertEquals(4, cityList.countCities());
    }


}

package org.example.lesson7.project.model;


import org.example.lesson7.project.viem.Period;

import java.io.IOException;

public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException;

}

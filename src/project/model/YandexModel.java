package org.example.lesson7.project.model;

import org.example.lesson7.project.viem.Period;

import java.io.IOException;

public class YandexModel implements WeatherModel{
    @Override
    public void getWeather(String selectedCity, Period period) throws IOException {
        System.out.println("Модуль в разрадотке, по ощущениям погода будет хорошей");
    }
}

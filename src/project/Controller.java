package org.example.lesson7.project;

import org.example.lesson7.project.model.AccuweatherModel;
import org.example.lesson7.project.model.WeatherModel;
import org.example.lesson7.project.viem.Period;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel;
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller(WeatherModel weatherModel) {
        this.weatherModel = weatherModel;
        variants.put(1, Period.NOW);
        variants.put(5, Period.FIVE_DAYS);
    }

    public void getWeather(String userInput, String selectedCity) throws IOException {
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case NOW -> weatherModel.getWeather(selectedCity, Period.NOW);
            case FIVE_DAYS -> weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
            default -> {
                System.out.printf("ltf");
                throw new IOException("Метод не риализован");
            }
        }
    }
}

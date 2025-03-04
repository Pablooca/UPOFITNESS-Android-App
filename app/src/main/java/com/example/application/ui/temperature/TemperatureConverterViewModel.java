package com.example.application.ui.temperature;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TemperatureConverterViewModel extends ViewModel {
    private final MutableLiveData<String> result = new MutableLiveData<>();

    public void convertTemperature(double temp, String from, String to) {
        double convertedTemp = temp;
        if (from.equals("Celsius") && to.equals("Fahrenheit")) convertedTemp = (temp * 9/5) + 32;
        if (from.equals("Celsius") && to.equals("Kelvin")) convertedTemp = temp + 273.15;
        if (from.equals("Fahrenheit") && to.equals("Celsius")) convertedTemp = (temp - 32) * 5/9;
        if (from.equals("Fahrenheit") && to.equals("Kelvin")) convertedTemp = (temp - 32) * 5/9 + 273.15;
        if (from.equals("Kelvin") && to.equals("Celsius")) convertedTemp = temp - 273.15;
        if (from.equals("Kelvin") && to.equals("Fahrenheit")) convertedTemp = (temp - 273.15) * 9/5 + 32;

        result.setValue("Result: " + convertedTemp);
    }

    public LiveData<String> getResult() {
        return result;
    }
}

package com.example.application.ui.calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {

    private final MutableLiveData<String> result = new MutableLiveData<>();

    public void calculateSum(double num1, double num2){
        result.setValue("Result: " + (num1 + num2));
    }

    public void calculateSubstract(double num1, double num2){
        result.setValue("Result: " + (num1 - num2));
    }

    public void calculateMultiplication(double num1, double num2){
        result.setValue("Result: " + (num1 * num2));
    }

    public void calculateDivision(double num1, double num2){
        if (num2 == 0){
            result.setValue("It is not possible to divide by zero");
        } else {
            result.setValue("Result: " + (num1 / num2));
        }
    }

    public LiveData<String> getResult(){
        return result;
    }
}
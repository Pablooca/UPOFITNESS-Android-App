package com.example.application.ui.equations;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EquationSolverViewModel extends ViewModel {
    private final MutableLiveData<String> result = new MutableLiveData<>();

    public void solveEquation(double a, double b, Double c) {
        if (c == null) { // Ecuación de primer grado
            if (a == 0) {
                result.setValue("No hay solución si a = 0");
            } else {
                result.setValue("Solución: x = " + (-b / a));
            }
        } else { // Ecuación de segundo grado
            double discriminant = b * b - 4 * a * c;
            if (discriminant < 0) {
                result.setValue("No hay soluciones reales");
            } else if (discriminant == 0) {
                result.setValue("Única solución: x = " + (-b / (2 * a)));
            } else {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                result.setValue("Soluciones: x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }

    public LiveData<String> getResult() {
        return result;
    }
}

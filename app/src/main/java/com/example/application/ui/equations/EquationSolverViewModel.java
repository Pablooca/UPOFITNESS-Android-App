package com.example.application.ui.equations;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EquationSolverViewModel extends ViewModel {
    private final MutableLiveData<String> result = new MutableLiveData<>();

    public void solveEquation(double a, double b, Double c) {
        if (c == null) { // Ecuación de primer grado
            if (a == 0) {
                result.setValue("There is no solution if a = 0");
            } else {
                result.setValue("Solution: x = " + (-b / a));
            }
        } else { // Ecuación de segundo grado
            double discriminant = b * b - 4 * a * c;
            if (discriminant < 0) {
                result.setValue("There are no real solutions");
            } else if (discriminant == 0) {
                result.setValue("Unique solution: x = " + (-b / (2 * a)));
            } else {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                result.setValue("Solutions: x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }

    public LiveData<String> getResult() {
        return result;
    }
}

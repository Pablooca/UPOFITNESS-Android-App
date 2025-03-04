package com.example.application.ui.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.application.databinding.FragmentCalculatorBinding;

public class CalculatorFragment extends Fragment {
    private FragmentCalculatorBinding binding;
    private CalculatorViewModel calculatorViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        calculatorViewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        binding = FragmentCalculatorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Botón Sumar
        binding.addButton.setOnClickListener(v -> {
            double num1 = Double.parseDouble(binding.input1.getText().toString());
            double num2 = Double.parseDouble(binding.input2.getText().toString());
            calculatorViewModel.calculateSum(num1, num2);
        });

        // Botón Restar
        binding.subtractButton.setOnClickListener(v -> {
            double num1 = Double.parseDouble(binding.input1.getText().toString());
            double num2 = Double.parseDouble(binding.input2.getText().toString());
            calculatorViewModel.calculateSubstract(num1, num2);
        });

        // Botón Multiplicar
        binding.multiplyButton.setOnClickListener(v -> {
            double num1 = Double.parseDouble(binding.input1.getText().toString());
            double num2 = Double.parseDouble(binding.input2.getText().toString());
            calculatorViewModel.calculateMultiplication(num1, num2);
        });

        // Botón Dividir
        binding.divideButton.setOnClickListener(v -> {
            double num1 = Double.parseDouble(binding.input1.getText().toString());
            double num2 = Double.parseDouble(binding.input2.getText().toString());
            calculatorViewModel.calculateDivision(num1, num2);
        });

        calculatorViewModel.getResult().observe(getViewLifecycleOwner(), binding.result::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
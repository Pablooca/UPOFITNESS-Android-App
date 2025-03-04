package com.example.application.ui.equations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.application.databinding.FragmentEquationSolverBinding;

public class EquationSolverFragment extends Fragment {

    private FragmentEquationSolverBinding binding;
    private EquationSolverViewModel equationSolverViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        equationSolverViewModel = new ViewModelProvider(this).get(EquationSolverViewModel.class);

        binding = FragmentEquationSolverBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Manejar visibilidad de coeficiente C
        binding.checkBoxQuadratic.setOnCheckedChangeListener((buttonView, isChecked) ->
                binding.coefC.setVisibility(isChecked ? View.VISIBLE : View.GONE)
        );

        binding.solveButton.setOnClickListener(v -> {
            double a = Double.parseDouble(binding.coefA.getText().toString());
            double b = Double.parseDouble(binding.coefB.getText().toString());
            Double c = binding.checkBoxQuadratic.isChecked() ? Double.parseDouble(binding.coefC.getText().toString()) : null;

            equationSolverViewModel.solveEquation(a, b, c);
        });

        equationSolverViewModel.getResult().observe(getViewLifecycleOwner(), binding.result::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

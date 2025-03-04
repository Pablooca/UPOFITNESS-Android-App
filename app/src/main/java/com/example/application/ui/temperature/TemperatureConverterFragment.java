package com.example.application.ui.temperature;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.application.databinding.FragmentTemperatureConverterBinding;

public class TemperatureConverterFragment extends Fragment {

    private FragmentTemperatureConverterBinding binding;
    private TemperatureConverterViewModel temperatureConverterViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        temperatureConverterViewModel = new ViewModelProvider(this).get(TemperatureConverterViewModel.class);

        binding = FragmentTemperatureConverterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(),
                com.example.application.R.array.temperature_units,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.unitFrom.setAdapter(adapter);
        binding.unitTo.setAdapter(adapter);

        binding.convertButton.setOnClickListener(v -> {
            double temp = Double.parseDouble(binding.inputTemp.getText().toString());
            String from = binding.unitFrom.getSelectedItem().toString();
            String to = binding.unitTo.getSelectedItem().toString();

            temperatureConverterViewModel.convertTemperature(temp, from, to);
        });

        temperatureConverterViewModel.getResult().observe(getViewLifecycleOwner(), binding.result::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

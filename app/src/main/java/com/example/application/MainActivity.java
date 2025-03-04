package com.example.application;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.application.ui.calculator.CalculatorFragment;
import com.example.application.ui.equations.EquationSolverFragment;
import com.example.application.ui.temperature.TemperatureConverterFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.nav_calculator) {
                selectedFragment = new CalculatorFragment();
            } else if (item.getItemId() == R.id.nav_equation_solver) {
                selectedFragment = new EquationSolverFragment();
            } else if (item.getItemId() == R.id.nav_temperature_converter) {
                selectedFragment = new TemperatureConverterFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }
            return true;
        });

        // Establece la pantalla inicial en la calculadora
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new CalculatorFragment())
                    .commit();
        }
    }
}

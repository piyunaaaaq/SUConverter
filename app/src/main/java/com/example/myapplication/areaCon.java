//Jera Canoy
package com.example.myapplication;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class areaCon extends AppCompatActivity {
    EditText input;
    Spinner unit;
    TextView area1, area2, area3, area4, area5, area6, area7, area8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_area_con);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        area1 = findViewById(R.id.area1);
        area2 = findViewById(R.id.area2);
        area3 = findViewById(R.id.area3);
        area4 = findViewById(R.id.area4);
        area5 = findViewById(R.id.area5);
        area6 = findViewById(R.id.area6);
        area7 = findViewById(R.id.area7);
        area8 = findViewById(R.id.area8);

        String[] arr = {"m²", "km²", "cm²", "mm²", "ha", "ac", "a", "b"};
        unit.setAdapter(new ArrayAdapter(areaCon.this, android.R.layout.simple_list_item_1, arr));

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                update();
            }
        });
    }

    private void update() {
        if (!input.getText().toString().isEmpty() && unit.getSelectedItem() != null) {
            double inputValue = Double.parseDouble(input.getText().toString());
            String selectedUnit = unit.getSelectedItem().toString();

            // Perform conversion based on the selected unit
            switch (selectedUnit) {
                case "m²":
                    setAreaValues(inputValue, inputValue, inputValue * 10000, inputValue);
                    break;
                case "km²":
                    setAreaValues(inputValue * 1e-6, inputValue, inputValue * 1e6, inputValue);
                    break;
                case "cm²":
                    setAreaValues(inputValue * 1e-4, inputValue * 1e-10, inputValue, inputValue);
                    break;
                case "mm²":
                    setAreaValues(inputValue * 1e-6, inputValue * 1e-12, inputValue * 100, inputValue);
                    break;
                case "ha":
                    setAreaValues(inputValue * 10000, inputValue * 1e-4, inputValue * 1e8, inputValue * 1e10);
                    break;
                case "ac":
                    setAreaValues(inputValue * 4046.86, inputValue * 4.04686e-3, inputValue * 4.04686e7, inputValue * 4.04686e9);
                    break;
                case "a":
                    setAreaValues(inputValue * 100, inputValue * 1e-6, inputValue * 1e6, inputValue * 1e8);
                    break;
                case "b":
                    setAreaValues(inputValue * 1e-28, inputValue * 1e-34, inputValue * 1e-18, inputValue * 1e-16);
                    break;
            }
        }
    }
    private void setAreaValues(double m2, double km2, double cm2, double mm2) {
        area1.setText(String.format("%.2f m²", m2));
        area2.setText(String.format("%.6f km²", km2));
        area3.setText(String.format("%.2f cm²", cm2));
        area4.setText(String.format("%.2f mm²", mm2));
        area5.setText(String.format("%.2f ha", m2 / 10000));  // 1 ha = 10,000 m²
        area6.setText(String.format("%.6f ac", m2 / 4046.86)); // 1 ac = 4046.86 m²
        area7.setText(String.format("%.2f a", m2 / 100));      // 1 a = 100 m²
        area8.setText(String.format("%.2e b", m2 * 1e-28));
    }
}



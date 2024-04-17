//Fiona Labrador
package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class lengthCon extends AppCompatActivity {

    EditText input;
    Spinner unit_spinner;
    TextView inch_value, foot_value,yard_value, mile_value, nanom_value, microm_value, mm_value, cm_value, m_value, km_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_length_con);

        input = findViewById(R.id.input);
        unit_spinner = findViewById(R.id.unit_spinner);
        inch_value = findViewById(R.id.inch_value);
        foot_value = findViewById(R.id.foot_value);
        yard_value = findViewById(R.id.yard_value);
        mile_value = findViewById(R.id.mile_value);
        nanom_value = findViewById(R.id.nanom_value);
        microm_value = findViewById(R.id.microm_value);
        mm_value = findViewById(R.id.mm_value);
        cm_value = findViewById(R.id.cm_value);
        m_value = findViewById(R.id.m_value);
        km_value = findViewById(R.id.km_value);

        String[] arr = {"inch", "foot", "yard", "mile", "nanometer", "micrometer", "millimeter", "centimeter", "meter", "kilometer"};
        unit_spinner.setAdapter(new ArrayAdapter(lengthCon.this, android.R.layout.simple_list_item_1, arr));

        unit_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update ();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                update();
            }
        });

    }

    private void update(){
        if (!input.getText().toString().equals("") && !unit_spinner.getSelectedItem().toString().equals("")){
            double in = Double.parseDouble(input.getText().toString());
            switch (unit_spinner.getSelectedItem().toString()) {
                case "kilometer":
                    setKm(in);
                    break;
                case "meter":
                    setKm(in/1000);
                    break;
                case "centimeter":
                    setKm(in/100000);
                    break;
                case "millimeter":
                    setKm(in/1000000);
                    break;
                case "micrometer":
                    setKm(in/1000000000);
                    break;
                case "nanometer":
                    double d = 1000000 * 1000000;
                    setKm(in/d);
                    break;
                case "mile":
                    setKm(in*1.609);
                    break;
                case "yard":
                    setKm(in/1094);
                    break;
                case "foot":
                    setKm(in/3281);
                    break;
                case "inch":
                    setKm(in/39370);
                    break;
            }
        }
    }

    private void setKm(double km_in){
        km_value.setText(String.valueOf(km_in));
        m_value.setText(String.valueOf(km_in*1000));
        cm_value.setText(String.valueOf(km_in*100000));
        mm_value.setText(String.valueOf(km_in*1000000));
        microm_value.setText(String.valueOf(km_in*1000000000));
        nanom_value.setText(String.valueOf(km_in*1000000*1000000));
        mile_value.setText(String.valueOf(km_in/1.609));
        yard_value.setText(String.valueOf(km_in*1094));
        foot_value.setText(String.valueOf(km_in*3281));
        inch_value.setText(String.valueOf(km_in*39370));


    }
}
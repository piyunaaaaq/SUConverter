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

public class weightCon extends AppCompatActivity {
    EditText input;
    Spinner unit;
    TextView tonne, kilogram, gram, milligram, microgram, stone, pound, ounce;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weight_con);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        tonne = findViewById(R.id.tonne_num);
        kilogram = findViewById(R.id.kilo_num);
        gram = findViewById(R.id.gram_num);
        milligram = findViewById(R.id.milli_num);
        microgram = findViewById(R.id.microgram_num);
        stone = findViewById(R.id.stone_num);
        pound = findViewById(R.id.pound_num);
        ounce = findViewById(R.id.ounce_num);

        String[] arr = {"tonne", "kilogram", "gram", "milligram", "microgram", "stone", "pound", "ounce"};
        unit.setAdapter(new ArrayAdapter(weightCon.this, android.R.layout.simple_list_item_1,arr));

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update();
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
            public void afterTextChanged(Editable editable) {
                update();
            }
        });
    }

    private void update() {
        if (!input.getText().toString().equals("")&& !unit.getSelectedItem().toString().equals("")) {
            double in = Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()) {
                case "kilogram":
                    setKilo(in);
                    break;
                case "tonne":
                    setKilo(in * 1000);
                    break;
                case "gram":
                    setKilo(in/1000);
                    break;
                case "milligram":
                    setKilo(in/1000000);
                    break;
                case "microgram":
                    setKilo(in/1000000000);
                    break;
                case "stone":
                    setKilo(in*6.35029);
                    break;
                case"pound":
                    setKilo(in*0.45359237);
                    break;
                case "ounce":
                    setKilo(in*0.0283495);
            }
        }
    }

    private void setKilo(double kilo){
        kilogram.setText(String.valueOf(kilo));
        tonne.setText(String.valueOf(kilo/1000));
        gram.setText(String.valueOf(kilo*1000));
        milligram.setText(String.valueOf(kilo*1000000));
        microgram.setText(String.valueOf(kilo*1000000000));
        stone.setText(String.valueOf(kilo/6.35029));
        pound.setText(String.valueOf(kilo/0.45359237));
        ounce.setText(String.valueOf(kilo/0.0283495));
    }
}

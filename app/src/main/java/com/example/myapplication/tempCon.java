//Christian Angcaya
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


public class tempCon extends AppCompatActivity {
    EditText input;
    Spinner unit;
    TextView cel, kelv, fah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_temp_con);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        cel = findViewById(R.id.cel);
        kelv = findViewById(R.id.kelv);
        fah = findViewById(R.id.fah);

        String[] arr = {"celsius", "kelvin", "fahrenheit"};
        unit.setAdapter(new ArrayAdapter(tempCon.this, android.R.layout.simple_list_item_1, arr));

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
            public void afterTextChanged(Editable s) {
                update();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void update() {
        if(!input.getText().toString().isEmpty() && !unit.getSelectedItem().toString().isEmpty()){
            double in = Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()){
                case "celsius":
                    setcel(in);
                    break;
                case "kelvin":
                    setcel(in - 273.15);
                    break;
                case "fahrenheit":
                    setcel((in-32)*0.5555555555555556);
                    break;
            }
        }
    }

    private void setcel(double in) {

        cel.setText(String.valueOf(in));
        kelv.setText(String.valueOf(in + 273.15));
        fah.setText(String.valueOf((in*1.8)+32));

    }
}


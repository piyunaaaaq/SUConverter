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

public class timeCon extends AppCompatActivity {
    EditText input;
    Spinner unit;
    TextView mils, secs, min, hour, day, week, month, year, decade, century, millennium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_time_con);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        mils = findViewById(R.id.mils);
        secs = findViewById(R.id.secs);
        min = findViewById(R.id.min);
        hour = findViewById(R.id.hour);
        day = findViewById(R.id.day);
        week = findViewById(R.id.week);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        decade = findViewById(R.id.decade);
        century = findViewById(R.id.century);
        millennium = findViewById(R.id.millennium);

        String[] arr = {"millisecond", "second", "minute", "hour", "day", "week", "month", "year", "decade", "century", "millennium"};
        unit.setAdapter(new ArrayAdapter(timeCon.this, android.R.layout.simple_list_item_1, arr));

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
                case "millisecond":
                    setweek(in/604800000);
                    break;
                case "second":
                    setweek(in/604800);
                    break;
                case "minute":
                    setweek(in/10080);
                    break;
                case "hour":
                    setweek(in/168);
                    break;
                case "day":
                    setweek(in/7);
                    break;
                case "week":
                    setweek(in);
                    break;
                case "month":
                    setweek(in/0.2301369863);
                    break;
                case "year":
                    setweek(in/0.0191649555);
                    break;
                case "decade":
                    setweek(in/0.0019164956);
                    break;
                case "century":
                    setweek(in/0.0001916496);
                    break;
                case "millennium":
                    setweek(in/0.000019165);
                    break;
            }

        }
    }

    private void setweek(double in) {

        mils.setText(String.valueOf(in*604800000));
        secs.setText(String.valueOf(in*604800));
        min.setText(String.valueOf(in*10080));
        hour.setText(String.valueOf(in*168));
        day.setText(String.valueOf(in*7));
        week.setText(String.valueOf(in));

        month.setText(String.valueOf(in*0.2301369863));
        year.setText(String.valueOf(in*0.0191649555));
        decade.setText(String.valueOf(in*0.0019164956));
        century.setText(String.valueOf(in*0.0001916496));
        millennium.setText(String.valueOf(in*0.000019165));
    }
}



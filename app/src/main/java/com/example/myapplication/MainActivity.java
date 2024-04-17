//Fiona Labrador
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageButton imgButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    imgButton = (ImageButton) findViewById(R.id.length_button);
    imgButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, lengthCon.class);
            startActivity(intent);
        }
    });

    imgButton = (ImageButton) findViewById(R.id.temp_button);
    imgButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, tempCon.class);
            startActivity(intent);
            }
        });

    imgButton = (ImageButton) findViewById(R.id.area_button);
    imgButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, areaCon.class);
            startActivity(intent);
            }
        });

    imgButton = (ImageButton) findViewById(R.id.time_button);
    imgButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, timeCon.class);
            startActivity(intent);
            }
        });


        imgButton = (ImageButton) findViewById(R.id.weight_button);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, weightCon.class);
                startActivity(intent);
            }
        });

        imgButton = (ImageButton) findViewById(R.id.area_button);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, areaCon.class);
                startActivity(intent);
            }
        });






    }
}
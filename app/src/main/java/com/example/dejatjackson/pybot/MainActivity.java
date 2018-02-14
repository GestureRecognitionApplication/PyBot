package com.example.dejatjackson.pybot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button buttonForward = findViewById(R.id.buttonForward);
        Button buttonBack = findViewById(R.id.buttonBack);
        Button buttonLeft = findViewById(R.id.buttonLeft);
        Button buttonRight = findViewById(R.id.buttonRight);

        //do this for the other buttons as well



    }
}

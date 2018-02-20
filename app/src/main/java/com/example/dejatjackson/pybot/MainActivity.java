package com.example.dejatjackson.pybot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Make the Image change based on the bluetooth connection

        Button btRight = findViewById(R.id.right);
        Button btLeft = findViewById(R.id.left);
        Button btUp = findViewById(R.id.up);
        Button btDown = findViewById(R.id.up);

        //do this for the other buttons as well

        //TODO: Make the buttons actually work to move the Robot (based on up, down, etc..)


    }
}

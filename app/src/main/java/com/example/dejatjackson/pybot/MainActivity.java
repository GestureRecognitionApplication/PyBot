package com.example.dejatjackson.pybot;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView rConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ImageView redCircle = findViewById(R.id.circle);
        //TODO: Make the Image change based on the bluetooth connection

        //TODO: Make the Text change based on the bluetooth Connection

        //TODO: Pop-Up to Tell the User to Connect the Pi and Phone to Bluetooth if the Circle is Red

        ImageButton btRight = findViewById(R.id.right);
        ImageButton btLeft = findViewById(R.id.left);
        ImageButton btUp = findViewById(R.id.up);
        ImageButton btDown = findViewById(R.id.down);
        ImageButton bt360 = findViewById(R.id.button360);
        btRight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sendCommandRight();
            }
        });
        btLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sendCommandLeft();
            }
        });


        //TODO: Make the buttons actually work to move the Robot (based on up, down, etc..)

        //This is temporary for the purpose of testing since I don't have a drawer
        Button buttonRemove = findViewById(R.id.button);
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, VoiceActivity.class));
            }
        });
        private void sendCommandRight() {
            //TODO: Insert Code Here
        }
        private void sendCommandLeft() {
            //TODO: Insert Code Here
        }
        private void sendCommandForward() {
            //TODO: Insert Code Here
        }
        private void sendCommandBackwards() {
            //TODO: Insert Code Here
        }
        private void sendCommand360() {
            //TODO: Insert Code Here
        }

    }

}

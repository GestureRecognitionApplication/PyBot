package com.example.dejatjackson.pybot;

import android.os.Handler;
import android.widget.TextView;
//package com.stacktips.speechtotext;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class VoiceActivity extends AppCompatActivity {

    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView voiceOutputText;
    private ImageButton voiceBt;
    private ImageButton robotBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        voiceOutputText = (TextView) findViewById(R.id.voiceOutput);
        voiceBt = (ImageButton) findViewById(R.id.voice);
        robotBt = (ImageButton) findViewById(R.id.robot);

        voiceBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startVoiceInput();
            }
        }); //set the onClick to the Voice Recognizer Built in
        /*robotBt.setOnLongClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startVoiceHelp();
            }
        }); //set the onClick to the Robot Command */
        robotBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sendRobotCommand();
            }
        }); //set the onClick to the Robot Command


    }
    //Voice API
    private void startVoiceInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hello, Say a one-word voice command?");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }
    //Voice Help Dialogue
    private void startVoiceHelp() {
        //TODO: Insert Code Here for a Dialog
    }
    //Send Robot Command
    private void sendRobotCommand() {
        //TODO: Insert Code Here for a Robot Command toast to actually work -- currently this a test message
        Toast toast=Toast.makeText(this, "Pybot hasn't been connected yet", Toast.LENGTH_LONG);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 500);
        }
            //"PyBot is turning left"
            //"PyBot is turning 360 degrees"
            //"PyBot is turning right"
            //"PyBot is moving backwards"
            //"PyBot is moving forwards"
            //"PyBot has not received a recognized command"


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    voiceOutputText.setText(result.get(0));
                }
                break;
            }

        }
    }
}
//TODO: On  Long Click Listener --> Create a Dialog for the Voice Commands
//TODO: Make the Voice Activity Work
//TODO: Add some help Icon for the Voice Commands they can submit
//TODO: Check the Bluetooth Connection
//TODO: Pop-Up to Tell the User to Connect the Pi and Phone to Bluetooth if the Circle is Red
//TODO: Make the Robot Button Work to Send the Command to the Robot & Connect Via Bluetooth to the Robot (May need to Connect to a Script on the Robot
//ToDO: Make a toast come up to confirm the motion the robot executes
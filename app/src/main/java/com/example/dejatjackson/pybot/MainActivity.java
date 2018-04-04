package com.example.dejatjackson.pybot;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    BluetoothSocket mmSocket = null;
    BluetoothDevice mmDevice = null;
    private TextView rConnection;
    boolean connectionStatus = false;

    public void sendBtMsg(String mes) {
        UUID uuid = UUID.fromString("94f39d29-7d6d-437d-973b-fba39e49d4ee"); //Standard SerialPortService ID
        try {

            mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
            if (!mmSocket.isConnected()){
                mmSocket.connect();
            }

            String msg = mes;
            OutputStream mmOutputStream = mmSocket.getOutputStream();
            mmOutputStream.write(msg.getBytes()); //Sends Messages

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup Bluetooth Connection and Make sure it is enabled
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            // Device doesn't support Bluetooth
        }
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 0); //when not enabled asks the user if they'd like to enable bluetooth
        }
        //Paired Devices
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        if(pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                if (device.getName().equals("raspberrypi")) //Note, you will need to change this to match the name of your device
                {
                    Log.e("Pybot", device.getName());
                    mmDevice = device;
                    break;
                }
            }
            connectionStatus = true;
        }

        //TODO: Enable and Connect Bluetooth device (maybe by MAC???) or this UUID thing?
        //TODO: Make sure Connection Status is changing correctly



        ImageView circle = findViewById(R.id.circle);
        TextView connec = findViewById(R.id.connection);
        //Use the BluetoothProfile.ServiceListener ??? - tells if connected or disconnected
        if(connectionStatus) {
            circle.setImageResource(R.drawable.green);
            connec.setText("Robot Connected");
        }
        if(!connectionStatus) {
            circle.setImageResource(R.drawable.red);
            connec.setText("Robot Not Connected");
        }
        //TODO: Is the text changing correctly?

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
        btUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sendCommandForward();
            }
        });
        btDown.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sendCommandBackwards();
            }
        });
        bt360.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sendCommand360();
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
    }
    private void sendCommandRight() {
        //TODO: Insert Code Here for Functionality
        sendBtMsg("4");
        //TODO: Add a Delay
        Toast toast=Toast.makeText(this, "PyBot is turning right", Toast.LENGTH_LONG);
        toast.show();
        closeToast(toast);
    }
    private void sendCommandLeft() {
        //TODO: Insert Code Here for Functionality
        sendBtMsg("3");
        //TODO: Add a Delay
        Toast toast=Toast.makeText(this, "PyBot is turning left", Toast.LENGTH_LONG);
        toast.show();
        closeToast(toast);

    }
    private void sendCommandForward() {
        //TODO: Insert Code Here for Functionality
        sendBtMsg("1");
        //TODO: Add a Delay
        Toast toast=Toast.makeText(this, "PyBot is moving forwards", Toast.LENGTH_LONG);
        toast.show();
        closeToast(toast);

    }
    private void sendCommandBackwards() {
        //TODO: Insert Code Here for Functionality
        sendBtMsg("2");
        //TODO: Add a Delay
        Toast toast=Toast.makeText(this, "PyBot is moving backwards", Toast.LENGTH_LONG);
        toast.show();
        closeToast(toast);
    }
    private void sendCommand360() {
        //TODO: Insert Code Here for Functionality
        sendBtMsg("5");
        //TODO: Add a Delay
        Toast toast=Toast.makeText(this, "PyBot is turning 360 degrees", Toast.LENGTH_LONG);
        toast.show();
        closeToast(toast);
    }

    //closes the toast after a set amount of time
    private void closeToast(final Toast toast2) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast2.cancel();
            }
        }, 500);
    }


}
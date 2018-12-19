package com.example.shyam.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {


    TextView result;
    TextView multiplier_text;
    SeekBar multiplier;
    EditText input;

    private SeekBar.OnSeekBarChangeListener seekbarControl = new SeekBar.OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar s, int progress, boolean fromUser)
        {
            multiplier_text.setText(" : " + multiplier.getProgress());
        }

        public void onStartTrackingTouch(SeekBar s)
        {

        }

        public void onStopTrackingTouch(SeekBar s)
        {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        input = findViewById(R.id.number);
        multiplier = findViewById(R.id.multiplier);
        multiplier_text = findViewById(R.id.multiplier_text);

        multiplier_text.setText(" : " + multiplier.getProgress());
        multiplier.setOnSeekBarChangeListener(seekbarControl);
    }

    public void parseResponse(View v)
    {
        int a,b;
        try {
            a = Integer.parseInt(input.getText().toString());
        }
        catch (Exception e)
        {
            a  = 0;
        }
        b = multiplier.getProgress();
        result.setText("" +  a*b);
    }


    public void feedback(View v)
    {
        Intent I = new Intent();
        I.setClass(this, feebackActivity.class);
        if (I.resolveActivity(getPackageManager()) != null)
        {
            startActivity(I);
        }
        else
        {
            Toast.makeText(this, "Error starting feedback activity", Toast.LENGTH_LONG).show();
        }
    }

}

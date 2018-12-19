package com.example.shyam.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {


    TextView result;
    TextView multiplier_text;
    SeekBar multiplier;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        input = findViewById(R.id.number);
        multiplier = findViewById(R.id.multiplier);
        multiplier_text = findViewById(R.id.multiplier_text);

        multiplier_text.setText(" : " + multiplier.getProgress());
        multiplier.setOnSeekBarChangeListener(this);
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

    void changeValue()
    {
        multiplier_text.setText(" : " + multiplier.getProgress());
    }

    public void onProgressChanged(SeekBar s, int progress, boolean fromUser)
    {
        changeValue();
    }

    public void onStartTrackingTouch(SeekBar s)
    {

    }

    public void onStopTrackingTouch(SeekBar s)
    {

    }
    public void feedback(View v)
    {
        String[] email = {"m.shyam.tnj@gmail.com"};
        String subject = "A feedback!";

        Intent I = new Intent (Intent.ACTION_SENDTO);
        I.setData(Uri.parse("mailto:"));
        I.putExtra(Intent.EXTRA_EMAIL, email);
        I.putExtra(Intent.EXTRA_SUBJECT, subject);
        I.putExtra(Intent.EXTRA_TEXT, "Hello, i got the result " +  result.getText());

        if (I.resolveActivity(getPackageManager()) != null)
        {
            startActivity(I);
        }
        else
        {
            Toast.makeText(this, "Error no email app", Toast.LENGTH_LONG).show();
        }
    }

}

package com.example.shyam.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class feebackActivity extends AppCompatActivity {

    private TextView text;
    private LinearLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeback);

        rootView = findViewById(R.id.feedbackRootView);
        text = new TextView(this);
        text.setText("Hey this is the feedback form!");
        text.setPadding(8,8,8,8);
        La
        rootView.addView(text);

    }
}

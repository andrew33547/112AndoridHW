package com.example.radiobuttonone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        // Retrieve the output text passed from MainActivity
        String outputText = getIntent().getStringExtra("OUTPUT_TEXT");

        // Display the output text in a TextView
        TextView outputTextView = findViewById(R.id.outputTextView);
        if (outputTextView != null) {
            outputTextView.setText(outputText);
        }

    }
}



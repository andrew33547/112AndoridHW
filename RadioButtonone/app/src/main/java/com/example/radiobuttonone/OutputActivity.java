package com.example.radiobuttonone;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        // Retrieve the output text passed from MainActivity
        Intent intent = getIntent();
        if (intent != null) {
            String outputText = intent.getStringExtra("OUTPUT_TEXT");

            // Display the output text in the outputTextView
            TextView outputTextView = findViewById(R.id.outputTextView);
            outputTextView.setText(outputText);
        }
    }
}





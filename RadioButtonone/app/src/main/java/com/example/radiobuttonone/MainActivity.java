package com.example.radiobuttonone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Define prices for each type of ticket
    private static final int PRICE_ADULT = 500;
    private static final int PRICE_CHILD = 250;
    private static final int PRICE_STUDENT = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputStr = "";

                RadioButton boy = findViewById(R.id.rdbBoy);
                RadioButton girl = findViewById(R.id.rdbGirl);
                if (boy.isChecked())
                    outputStr += "男生\n";
                else if (girl.isChecked())
                    outputStr += "女生\n";

                RadioGroup type = findViewById(R.id.rgType);
                int price = 0; // Initialize price to calculate total price
                if (type.getCheckedRadioButtonId() == R.id.rdbAdult) {
                    outputStr += "全票\n";
                    price = PRICE_ADULT;
                } else if (type.getCheckedRadioButtonId() == R.id.rdbChild) {
                    outputStr += "兒童票\n";
                    price = PRICE_CHILD;
                } else if (type.getCheckedRadioButtonId() == R.id.rdbStudent) {
                    outputStr += "學生票\n";
                    price = PRICE_STUDENT;
                } else {
                    outputStr += "請選擇票種\n"; // Default case when no radio button is selected
                }

                EditText quantityEditText = findViewById(R.id.editTextNumber);
                int quantity = Integer.parseInt(quantityEditText.getText().toString());
                int totalPrice = price * quantity; // Calculate total price

                outputStr += "張數: " + quantity + "\n";
                outputStr += "總金額: " + totalPrice + "元\n";

                // Pass the output text to the OutputActivity
                Intent intent = new Intent(MainActivity.this, OutputActivity.class);
                intent.putExtra("OUTPUT_TEXT", outputStr);
                startActivity(intent);
            }
        });

        // Add click listener for the "確認" button
        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the output text from lblOutput
                TextView outputTextView = findViewById(R.id.lblOutput);
                String outputText = outputTextView.getText().toString();

                // Pass the output text to the OutputActivity
                Intent intent = new Intent(MainActivity.this, OutputActivity.class);
                intent.putExtra("OUTPUT_TEXT", outputText);
                startActivity(intent);
            }
        });
    }
}



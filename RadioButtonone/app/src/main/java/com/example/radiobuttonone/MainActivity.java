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
//a111221084
public class MainActivity extends AppCompatActivity {

    // Define prices for each type of ticket
    private static final int PRICE_ADULT = 500;
    private static final int PRICE_CHILD = 250;
    private static final int PRICE_STUDENT = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView lblOutput = findViewById(R.id.lblOutput);

        // Update lblOutput in real-time
        RadioGroup rgGender = findViewById(R.id.rgGender);
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateOutput(lblOutput);
            }
        });

        RadioGroup rgType = findViewById(R.id.rgType);
        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateOutput(lblOutput);
            }
        });

        EditText editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    updateOutput(lblOutput);
                }
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
                // You can add code here if needed

                // After final calculation, start OutputActivity
                String outputStr = lblOutput.getText().toString();
                Intent intent = new Intent(MainActivity.this, OutputActivity.class);
                intent.putExtra("OUTPUT_TEXT", outputStr);
                startActivity(intent);
            }
        });
    }

    private void updateOutput(TextView lblOutput) {
        String output = "";

        RadioButton rdbBoy = findViewById(R.id.rdbBoy);
        RadioButton rdbGirl = findViewById(R.id.rdbGirl);
        if (rdbBoy.isChecked()) {
            output += "性別: 男生\n";
        } else if (rdbGirl.isChecked()) {
            output += "性別: 女生\n";
        }

        RadioGroup rgType = findViewById(R.id.rgType);
        int price = 0;
        if (rgType.getCheckedRadioButtonId() == R.id.rdbAdult) {
            output += "票種: 全票\n";
            price = PRICE_ADULT;
        } else if (rgType.getCheckedRadioButtonId() == R.id.rdbChild) {
            output += "票種: 兒童票\n";
            price = PRICE_CHILD;
        } else if (rgType.getCheckedRadioButtonId() == R.id.rdbStudent) {
            output += "票種: 學生票\n";
            price = PRICE_STUDENT;
        }

        EditText editTextNumber = findViewById(R.id.editTextNumber);
        int quantity = 0;
        try {
            quantity = Integer.parseInt(editTextNumber.getText().toString());
        } catch (NumberFormatException e) {
            // Handle parsing error if needed
        }
        int totalPrice = price * quantity;
        output += "張數: " + quantity + "\n";
        output += "金額: " + totalPrice + "元";

        lblOutput.setText(output);
    }
}







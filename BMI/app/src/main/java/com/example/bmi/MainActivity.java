package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txvshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvshow = (TextView) findViewById(R.id.txvshow);
        txvshow.setTextSize(36);
        Button countBMI = (Button) findViewById(R.id.countBMI);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        EditText edtHeight = (EditText) findViewById(R.id.edtHeight);
        EditText edtWeight = (EditText) findViewById(R.id.edtWeight);
        countBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double Height = Double.parseDouble(edtHeight.getText().toString());
                    double Weight = Double.parseDouble(edtWeight.getText().toString());
                    double BMI = Weight / Math.pow(Height / 100.0, 2);
                    if (BMI >= 24)
                        txvshow.setTextColor(Color.RED);
                    else if (BMI < 18.5)
                        txvshow.setTextColor(Color.BLUE);
                    else
                        txvshow.setTextColor(Color.GREEN);

                    txvshow.setText(String.format("%2f", BMI));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "請輸入數值", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHeight.setText("0");
                edtWeight.setText("0");
                txvshow.setText("");
            }
        });
    }

}

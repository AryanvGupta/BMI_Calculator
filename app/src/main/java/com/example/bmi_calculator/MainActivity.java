package com.example.bmi_calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private Button submitBtn;
    private TextView result;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.editTextNumber2);
        weight = (EditText) findViewById(R.id.editTextNumber3);
        submitBtn = (Button) findViewById(R.id.button4);
        result = (TextView) findViewById(R.id.textView7);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setTooltipText("Enter Height");
        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        fab1.setTooltipText("Enter Weight");

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = height.getText().toString();
                String s2 = weight.getText().toString();
                float heightValue = Float.parseFloat(s1);
                float weightValue = Float.parseFloat(s2);
                float bmi = weightValue / (heightValue * heightValue);

                if (bmi < 18.5) {
                    result.setText("Underweight \n Please eat more healthy food..!");
                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    result.setText("Normal Weight \n Keep it up..!");
                } else {
                    result.setText("Overweight \n Kindly exercise daily..!");
                }
            }
        });
    }
}
package com.example.mysimplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etInput;
    private double firstValue = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find UI elements by their IDs
        etInput = findViewById(R.id.etInput);
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnEquals = findViewById(R.id.btnEquals);

        // Set click listeners for numeric buttons
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        // Set click listeners for operator buttons
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        // Handle numeric buttons
        if (buttonText.matches("[0-9]")) {
            etInput.append(buttonText);
        }

        // Handle operator buttons
        switch (button.getId()) {
            case R.id.btnAdd:
            case R.id.btnSubtract:
            case R.id.btnMultiply:
            case R.id.btnDivide:
                operator = buttonText;
                firstValue = Double.parseDouble(etInput.getText().toString());
                etInput.setText("");
                isOperatorClicked = true;
                break;

            case R.id.btnClear:
                etInput.setText("");
                operator = "";
                firstValue = 0;
                isOperatorClicked = false;
                break;

            case R.id.btnEquals:
                if (isOperatorClicked) {
                    double secondValue = Double.parseDouble(etInput.getText().toString());
                    double result = 0;

                    switch (operator) {
                        case "+":
                            result = firstValue + secondValue;
                            break;
                        case "-":
                            result = firstValue - secondValue;
                            break;
                        case "*":
                            result = firstValue * secondValue;
                            break;
                        case "/":
                            if (secondValue != 0) {
                                result = firstValue / secondValue;
                            } else {
                                etInput.setText("Error");
                            }
                            break;
                    }

                    etInput.setText(String.valueOf(result));
                    operator = "";
                    firstValue = result;
                    isOperatorClicked = false;
                }
                break;
        }
    }
}

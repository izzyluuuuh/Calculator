package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final char OPERATOR_ADD = '+';
    private static final char OPERATOR_SUBTRACT = '-';
    private static final char OPERATOR_MULTIPLY = '*';
    private static final char OPERATOR_DIVIDE = '/';
    private static final char OPERATOR_PERCENT = '%';

    private char currentSymbol;

    private double firstValue = Double.NaN;
    private double secondValue;
    private TextView inputDisplay, outputDisplay;
    private MaterialButton button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9, buttonPoint, buttonAdd, buttonSubtract,
            buttonMultiply, buttonDivide, buttonPercent, buttonClear, buttonEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        DecimalFormat decimalFormat = new DecimalFormat("#.##########");

        inputDisplay = findViewById(R.id.input);
        outputDisplay = findViewById(R.id.output);

        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);

        buttonPoint = findViewById(R.id.btnPoint);
        buttonClear = findViewById(R.id.clear);
        buttonPercent = findViewById(R.id.percent);
        buttonAdd = findViewById(R.id.add);
        buttonSubtract = findViewById(R.id.subtract);
        buttonMultiply = findViewById(R.id.multiply);
        buttonDivide = findViewById(R.id.division);
        buttonEqual = findViewById(R.id.equal);
        buttonPercent = findViewById(R.id.percent);

//        button0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                inputDisplay.append("0");
//            }
//        })

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = OPERATOR_ADD;
                outputDisplay.setText(decimalFormat.format(firstValue) + "+");
                inputDisplay.setText(null);
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = OPERATOR_SUBTRACT;
                outputDisplay.setText(decimalFormat.format(firstValue) + "-");
                inputDisplay.setText(null);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = OPERATOR_MULTIPLY;
                outputDisplay.setText(decimalFormat.format(firstValue) + "*");
                inputDisplay.setText(null);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = OPERATOR_DIVIDE;
                outputDisplay.setText(decimalFormat.format(firstValue) + "/");
                inputDisplay.setText(null);
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = OPERATOR_PERCENT;
                outputDisplay.setText(decimalFormat.format(firstValue) + "%");
                inputDisplay.setText(null);
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + ".");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputDisplay.getText().length() > 0) {
                    CharSequence currentText = inputDisplay.getText();
                    inputDisplay.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    firstValue = Double.NaN;
                    secondValue = Double.NaN;
                    inputDisplay.setText("");
                    outputDisplay.setText("");
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                outputDisplay.setText(decimalFormat.format(firstValue));
                firstValue = Double.NaN;
                currentSymbol = '0';
            }
        });
    }

    private void allCalculations() {
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText(null);

            if (currentSymbol == OPERATOR_ADD)
                firstValue = this.firstValue + secondValue;
            else if (currentSymbol == OPERATOR_SUBTRACT)
                firstValue = this.firstValue - secondValue;
            else if (currentSymbol == OPERATOR_MULTIPLY)
                firstValue = this.firstValue * secondValue;
            else if (currentSymbol == OPERATOR_DIVIDE)
                firstValue = this.firstValue / secondValue;
            else if (currentSymbol == OPERATOR_PERCENT)
                firstValue = this.firstValue % secondValue;
        } else {
            try {
                firstValue = Double.parseDouble(inputDisplay.getText().toString());
            } catch (Exception e) {

            }
        }
    }
}
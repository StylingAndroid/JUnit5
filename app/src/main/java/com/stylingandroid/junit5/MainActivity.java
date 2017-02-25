package com.stylingandroid.junit5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText number1;
    private EditText number2;
    private Spinner operatorSelector;
    private TextView result;

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        operatorSelector = (Spinner) findViewById(R.id.operator);
        Button calculate = (Button) findViewById(R.id.calculate);
        result = (TextView) findViewById(R.id.result);

        calculator = new Calculator();

        calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float first = Float.parseFloat(number1.getText().toString());
        float second = Float.parseFloat(number2.getText().toString());
        String operatorString = (String) operatorSelector.getSelectedItem();
        Operator operator = Operator.getOperator(operatorString);
        float resultValue = calculator.calculate(first, second, operator);
        result.setText(String.format(Locale.getDefault(), "%.2f", resultValue));
    }
}

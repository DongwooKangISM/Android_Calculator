package com.example.fortutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String operator = "";
    private int x = 0;
    private Model model = new Model();

    TextView result;
    String firstNumber;
    String secondNumber;
    String finalResult;
    String symbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);
    }

    public void operand(View v) {
        Button clicked = (Button)v;
        String number = clicked.getText().toString();

        result.setText(number);
    }

    public void operator(View v) {
        Button clicked = (Button)v;
        String btnText = clicked.getText().toString();

        if(btnText.equals("=")) {
            secondNumber = result.getText().toString();
            finalResult = String.valueOf(model.calculate(operator, x, Integer.parseInt(secondNumber)));
            result.setText(finalResult);

        } else {
            operator = btnText;
            firstNumber = result.getText().toString();
            x = Integer.parseInt(firstNumber);
            result.setText("");
            symbol = btnText;
        }
    }

    public void history(View v) {
        Intent historyView = new Intent(getApplicationContext(),History.class);

        historyView.putExtra("first",firstNumber);
        historyView.putExtra("second",secondNumber);
        historyView.putExtra("historyFinal",finalResult);
        historyView.putExtra("operator",symbol);

        Toast alarm = Toast.makeText(this,"Moving to History Screen", Toast.LENGTH_SHORT);
        alarm.show();

        startActivity(historyView);

    }
}
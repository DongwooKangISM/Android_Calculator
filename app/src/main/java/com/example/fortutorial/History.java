package com.example.fortutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        TextView firstNumber =(TextView) findViewById(R.id.firstNumber);
        TextView secondNumber =(TextView) findViewById(R.id.secondNumber);
        TextView thirdNumber =(TextView) findViewById(R.id.history_result);
        TextView symbol = (TextView) findViewById(R.id.history_operator);

        Intent historyView = getIntent();

        String first = historyView.getStringExtra("first");
        String second = historyView.getStringExtra("second");
        String third = historyView.getStringExtra("historyFinal");
        String fourth = historyView.getStringExtra("operator");

        firstNumber.setText(first);
        secondNumber.setText(second);
        thirdNumber.setText(third);
        symbol.setText(fourth);
    }
}

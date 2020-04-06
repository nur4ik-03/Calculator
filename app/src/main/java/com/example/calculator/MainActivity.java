package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultField;
    Double firstValue, secondValue, result;
    String operation;
    String savedOp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultField = findViewById(R.id.resultField);
        if (savedInstanceState != null) {
            firstValue = savedInstanceState.getDouble("firstValue",firstValue);
            secondValue = savedInstanceState.getDouble("secondValue",secondValue);
            operation = savedInstanceState.getString("operation",operation);
        }

    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
                resultField.append("0");
                break;
            case R.id.one:
                resultField.append("1");
                break;
            case R.id.two:
                resultField.append("2");
                break;
            case R.id.three:
                resultField.append("3");
                break;
            case R.id.four:
                resultField.append("4");
                break;
            case R.id.five:
                resultField.append("5");
                break;
            case R.id.six:
                resultField.append("6");
                break;
            case R.id.seven:
                resultField.append("7");
                break;
            case R.id.eight:
                resultField.append("8");
                break;
            case R.id.nine:
                resultField.append("9");
                break;
            case R.id.clear:
                resultField.setText("");
                break;
            case R.id.dot:
                String str=resultField.getText().toString().trim();
                if(str.length()>0){
                    resultField.setText(str+".");
                }else{
                    resultField.setText("0.");
                }
        }
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                firstValue = Double.valueOf(resultField.getText().toString());
                resultField.setText(firstValue + "+");
                operation = "+";
                break;
            case R.id.division:
                firstValue = Double.valueOf(resultField.getText().toString());
                resultField.setText(firstValue + "/");
                operation = "/";
                break;
            case R.id.multiply:
                firstValue = Double.valueOf(resultField.getText().toString());
                resultField.setText(firstValue + "*");
                operation = "*";
                break;
            case R.id.minus:
                firstValue = Double.valueOf(resultField.getText().toString());
                resultField.setText(firstValue + "-");
                operation = "-";
                break;
            case R.id.equal:
                String two = resultField.getText().toString().replace(firstValue.toString() + operation, "");
                secondValue = Double.valueOf(two);
                if (operation == "+") {
                    result = firstValue + secondValue;
                    resultField.setText(result.toString());
                    operation = "+";
                }
                if (operation == "-") {
                    result = firstValue - secondValue;
                    resultField.setText(result.toString());
                    operation = "-";
                }
                if (operation == "*") {
                    result = firstValue * secondValue;
                    resultField.setText(result.toString());
                    operation = "*";
                }
                if (operation == "/") {
                    result = firstValue / secondValue;
                    resultField.setText(result.toString());
                    operation = "/";
                }
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (firstValue != null) {
            outState.putDouble("firstValue",firstValue);
        }
        if (secondValue != null) {
            outState.putDouble("secondValue",secondValue);
        }
        if (operation != null) {
            outState.putString("operation", operation);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ololo", "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ololo", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ololo", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ololo", "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ololo", "onDestroy");
    }

    public void onFirstClick(View view) {
        savedOp = "new saved String";
        Log.d("ololo", "Successfully saved " + savedOp);
    }
}



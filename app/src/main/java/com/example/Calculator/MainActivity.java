package com.example.Calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvNumber;
    TextView tvDetails;
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator(this);
        tvNumber = findViewById(R.id.tv_number);
        tvDetails = findViewById(R.id.tv_details);
    }

    public void numberClicked(View view) {
        switch (view.getId()){
            case R.id.b_0: calculator.processNumber(0); break;
            case R.id.b_1: calculator.processNumber(1); break;
            case R.id.b_2: calculator.processNumber(2); break;
            case R.id.b_3: calculator.processNumber(3); break;
            case R.id.b_4: calculator.processNumber(4); break;
            case R.id.b_5: calculator.processNumber(5); break;
            case R.id.b_6: calculator.processNumber(6); break;
            case R.id.b_7: calculator.processNumber(7); break;
            case R.id.b_8: calculator.processNumber(8); break;
            case R.id.b_9: calculator.processNumber(9); break;
            case R.id.b_mc: calculator.masterClear(); break;
            default: Toast.makeText(this, "This action is not handled",
                    Toast.LENGTH_SHORT).show();
        }
        updateCalcUI();
    }

    public void operations(View view) {
        switch (view.getId()){
            case R.id.b_clear: calculator.masterClear(); break;
            case R.id.b_add: calculator.addition(); break;
            case R.id.b_sub: calculator.subtraction(); break;
            case R.id.b_mul: calculator.multiply(); break;
            case R.id.b_div: calculator.divide(); break;
            case R.id.b_per: calculator.percent(); break;
            case R.id.b_mema: calculator.memoryAdd(); break;
            case R.id.b_memr: calculator.memoryRecall(); break;
            case R.id.b_mems: calculator.memorySubtract(); break;
            case R.id.b_ex: calculator.exp();break;
            case R.id.b_mc: calculator.memoryClear();break;
            case R.id.b_eq: calculator.equals(); break;
            default: Toast.makeText(this, "This action is not handled",
                    Toast.LENGTH_SHORT).show();
        }
        updateCalcUI();
    }


    private void updateCalcUI() {
        tvNumber.setText(calculator.numberString);
        tvDetails.setText(calculator.detailsString);
    }

}
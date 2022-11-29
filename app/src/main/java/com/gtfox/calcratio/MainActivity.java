package com.gtfox.calcratio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    private EditText op1;
    private EditText op2;
    private EditText op3;
    private EditText op4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op1= findViewById(R.id.op1);
        op2= findViewById(R.id.op2);
        op3= findViewById(R.id.op3);
        op4= findViewById(R.id.op4);
        Button x1 = findViewById(R.id.x1);
        Button x2 = findViewById(R.id.x2);
        Button x3 = findViewById(R.id.x3);
        Button x4 = findViewById(R.id.x4);
        Button r1 = findViewById(R.id.r1);
        Button r2 = findViewById(R.id.r2);

        @SuppressLint({"NonConstantResourceId", "SetTextI18n"}) View.OnClickListener onClickListener = view -> {
            double res;
            switch (view.getId()){
                case R.id.x1:
                    op1.setText("");
                    op1.requestFocus();
                    break;
                case R.id.x2:
                    op2.setText("");
                    op2.requestFocus();
                    break;
                case R.id.x3:
                    op3.setText("");
                    op3.requestFocus();
                    break;
                case R.id.x4:
                    op4.setText("");
                    op4.requestFocus();
                    break;
                case R.id.r1:
                    res=Math.round(((getDoubleFromEditText(op1)*getDoubleFromEditText(op4))/getDoubleFromEditText(op2))*100.0)/100.0;
                    op3.setText(Double.toString(res));
                    break;
                case R.id.r2:
                    res=Math.round(((getDoubleFromEditText(op2)*getDoubleFromEditText(op3))/getDoubleFromEditText(op1))*100.0)/100.0;
                    op4.setText(Double.toString(res));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
        };

        x1.setOnClickListener(onClickListener);
        x2.setOnClickListener(onClickListener);
        x3.setOnClickListener(onClickListener);
        x4.setOnClickListener(onClickListener);
        r1.setOnClickListener(onClickListener);
        r2.setOnClickListener(onClickListener);

    }

    private double getDoubleFromEditText (EditText edittext){
        String str= edittext.getText().toString();
        if (str.equals("")||Double.parseDouble(str)==0){
            edittext.setText("1");
            return 1;
        } else {
            return Double.parseDouble(edittext.getText().toString());
        }
    }
}
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculator extends AppCompatActivity {
    private static final String TAG = "Caculator";
    private EditText editText1, editText2;
    private TextView result;
    private Button execute;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_caculator);
        initView();
        // new anonymous class with interface View.OnClickListener
        execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caculate();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initView() {
        editText1 = findViewById((R.id.editText1));
        editText2 = findViewById((R.id.editText2));
        result = findViewById((R.id.tv4));
        execute = findViewById((R.id.execute));
        spinner = findViewById(R.id.spinner);
    }

    private void caculate() {
        String num1Str = editText1.getText().toString();
        String num2Str = editText2.getText().toString();
        String operation = spinner.getSelectedItem().toString();
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            result.setText("Please enter numbers");
            return;
        }
        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double res = 0;
        switch (operation) {
            case "Add":
                res = num1 + num2;
                break;
            case "Subtract":
                res = num1 - num2;
                break;
            case "Multiply":
                res = num1 * num2;
                break;
            case "Divide":
                if (num2 == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                res = num1 / num2;
                break;
            default:
                result.setText("Invalid operation");
        }
        result.setText(String.valueOf(res));
    }

}
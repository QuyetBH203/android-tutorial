package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class Ex4Layout extends AppCompatActivity {
    private Spinner spinner1;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex4_layout);
        spinner1=(Spinner)findViewById(R.id.spinner1);
        List<String> arr =List.of("Vietnam","USA","Canada","France","Italy");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.item, arr);
        List<String> arr2 = List.of("Iphone 16 promax","Samsung Galaxy S22","Xiaomi 12","Oppo Find X5","Vivo X90");
        spinner1.setAdapter(adapter1);
        spinner2=(Spinner)findViewById(R.id.sp2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.item, arr2);
        spinner2.setAdapter(adapter2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
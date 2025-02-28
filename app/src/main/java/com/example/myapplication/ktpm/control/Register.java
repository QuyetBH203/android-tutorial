package com.example.myapplication.ktpm.control;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.ktpm.dao.KiThuDao;
import com.example.myapplication.ktpm.model.KiThu;

public class Register extends AppCompatActivity {
    private EditText email, username, password,retypePassword;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        initView();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void  initView(){
        email = findViewById(R.id.email);
        username = findViewById(R.id.Username);
        password = findViewById((R.id.Password));
        retypePassword = findViewById((R.id.retypePassword));
        register = findViewById((R.id.btRegister));
    }

    private void register(){
        String emailStr = email.getText().toString();
        String usernameStr = username.getText().toString();
        String passwordStr = password.getText().toString();
        String retypePasswordStr = retypePassword.getText().toString();
        if (emailStr.isEmpty() || usernameStr.isEmpty() || passwordStr.isEmpty() || retypePasswordStr.isEmpty()) {
            // show error message
            return;
        }
        if (!passwordStr.equals(retypePasswordStr)) {
            // show error message
            return;
        }
        // create new KiThu object
        // save to database
        KiThu kiThu = new KiThu(usernameStr, emailStr, passwordStr);
        KiThuDao kiThuDao = new KiThuDao(this);
        kiThuDao.saveUser(kiThu);
    }
}
package com.example.myapplication.ktpm.dao;


import android.content.Context;
import android.widget.Toast;

import com.example.myapplication.ktpm.model.KiThu;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class KiThuDao {
    private final FirebaseFirestore db;
    private final Context context;

    public KiThuDao(Context context) {
        this.context = context;
        db = FirebaseFirestore.getInstance();
    }

    public void saveUser(KiThu kiThu) {
        Map<String, Object> userData = new HashMap<>();
        userData.put("email", kiThu.getEmail());
        userData.put("username", kiThu.getName());

        String userId = kiThu.getId();
        if (userId == null || userId.isEmpty()) {

            userId = db.collection("users").document().getId();
        }

        db.collection("users").document(userId)
                .set(userData, SetOptions.merge())  // Sử dụng merge để không ghi đè toàn bộ document
                .addOnSuccessListener(aVoid ->
                        Toast.makeText(context, "User registered successfully!", Toast.LENGTH_SHORT).show()
                )
                .addOnFailureListener(e ->
                        Toast.makeText(context, "Error saving user data: " + e.getMessage(), Toast.LENGTH_SHORT).show()
                );
    }
}

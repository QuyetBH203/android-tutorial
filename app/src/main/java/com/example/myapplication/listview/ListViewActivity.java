package com.example.myapplication.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.myapplication.R;
import java.util.Arrays;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private TextView textView;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.txt);
        initListView();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void  initListView (){
        List<String> arr = Arrays.asList(getResources().getStringArray(R.array.tech));
        adapter = new ArrayAdapter<String>(this, R.layout.item, arr);
        listView.setAdapter(adapter);
    }
}
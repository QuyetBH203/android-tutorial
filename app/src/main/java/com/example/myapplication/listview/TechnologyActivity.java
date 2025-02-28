package com.example.myapplication.listview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class TechnologyActivity extends AppCompatActivity {
    private ListView listView;
    private TextView textView;
    private ArrayAdapter<Technology> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_technology);
        textView = findViewById(R.id.tv1);
        listView = findViewById(R.id.listTech);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initListTech();
    }

    private void initListTech(){
        List<Technology> techList = new ArrayList<>();
        techList.add(new Technology(R.drawable.img1, "Android", "Mobile OS", "Google's OS"));
        techList.add(new Technology(R.drawable.img2, "iOS", "Apple OS", "iPhone OS"));
        techList.add(new Technology(R.drawable.img3, "Windows", "Desktop OS", "Microsoft OS"));
        techList.add(new Technology(R.drawable.img4, "Windows", "Desktop OS", "Microsoft OS"));
        techList.add(new Technology(R.drawable.img5, "Windows", "Desktop OS", "Microsoft OS"));
        adapter = new ArrayAdapter<Technology>(this, R.layout.item_tech, techList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Inflate layout mỗi lần mà không tái sử dụng ViewHolder
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tech, parent, false);
                }

                // Lấy dữ liệu của item hiện tại
                Technology tech = getItem(position);

                // Ánh xạ các view và gán dữ liệu
                ImageView imageView = convertView.findViewById(R.id.imageView);
                TextView nameText = convertView.findViewById(R.id.name);
                TextView subText = convertView.findViewById(R.id.sub);
                TextView descText = convertView.findViewById(R.id.desc);
                imageView.setImageResource(tech.getImg());
                nameText.setText(tech.getName());
                subText.setText(tech.getSub());
                descText.setText(tech.getDesc());


                return convertView;
            }
        };
        listView.setAdapter(adapter);


    }
}
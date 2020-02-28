package com.example.fbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fbook.database.myDb;
import com.google.android.material.tabs.TabLayout;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    TextView  NameText,AgeText,MarkText;
    MyFragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.fragment_pager);
        adapter=new MyFragmentAdapter(getSupportFragmentManager());
        tabLayout=findViewById(R.id.tab_Layout);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}

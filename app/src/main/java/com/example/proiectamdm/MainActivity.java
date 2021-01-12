package com.example.proiectamdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button info, stats, check;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.info);
        stats = findViewById(R.id.stats);
        check = findViewById(R.id.check);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToInfoView();
            }
        });
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToDBView();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToCheckView();
            }
        });
    }

    public void changeToDBView()
    {
        Intent intent = new Intent(this, DBActivity.class);
        startActivity(intent);
    }

    public void changeToInfoView()
    {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public void changeToCheckView()
    {
        Intent intent = new Intent(this, CheckActivity.class);
        startActivity(intent);
    }
}
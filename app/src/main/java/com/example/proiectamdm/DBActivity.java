package com.example.proiectamdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DBActivity extends AppCompatActivity
{
    Button view, insert, delete;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b);
        view = findViewById(R.id.View);
        insert = findViewById(R.id.Insert);
        delete = findViewById(R.id.Delete);


        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                changeToChartSelectView();
            }
        });
        insert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                changeToInsertIntoDBView();
            }
        });
    }

    public void changeToInsertIntoDBView()
    {
        Intent intent = new Intent(this, InsertIntoDBActivity.class);
        startActivity(intent);
    }

    public void changeToChartSelectView()
    {
        Intent intent = new Intent(this, ChartSelectActivity.class);
        startActivity(intent);
    }
}
package com.example.proiectamdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChartSelectActivity extends AppCompatActivity {

    Button sw1, sw2, sw3, sw4, sw5;
    int key = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_select);

        sw1 = findViewById(R.id.buttonCPJ);
        sw2 = findViewById(R.id.buttonCNPJ);
        sw3 = findViewById(R.id.buttonVPJ);
        sw4 = findViewById(R.id.buttonVNPJ);
        sw5 = findViewById(R.id.buttonDolj);
        ChartSelection();
    }

    public void ChartSelection()
    {
       sw1.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               StartChart("1");
           }
       });

       sw2.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               StartChart("2");
           }
       });

       sw3.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               StartChart("3");
           }
       });

       sw4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {
               StartChart("4");
           }
       });

       sw5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {
               StartChart("5");
           }
       });
    }

    public void StartChart(String pv_chart_id)
    {
        Intent intent = new Intent(this, ChartActivity.class);
        intent.putExtra("ID", pv_chart_id);
        startActivity(intent);
    }

}
package com.example.proiectamdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertIntoDBActivity extends AppCompatActivity
{
    DataBaseHelper myDb;
    Button insert_into_db;
    EditText judet, cazuri_noi, vaccinari_noi;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_into_d_b);
        insert_into_db = findViewById(R.id.Add);
        judet = findViewById(R.id.textJudet);
        cazuri_noi = findViewById(R.id.textCazuriNoi);
        vaccinari_noi = findViewById(R.id.textVaccinariNoi);
        myDb = new DataBaseHelper(this);
        addData();
    }

    public void addData()
    {
        insert_into_db.setOnClickListener(v -> {
            String lv_judet = judet.getText().toString().trim();
            String lv_cazuri_noi = cazuri_noi.getText().toString().trim();
            String lv_vaccinari_noi = vaccinari_noi.getText().toString().trim();

            if (myDb.insertData(lv_judet, lv_cazuri_noi, lv_vaccinari_noi))
                Toast.makeText(getBaseContext(), "Row inserted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_SHORT).show();
        });
    }
}
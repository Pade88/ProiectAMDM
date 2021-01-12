package com.example.proiectamdm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class CheckActivity extends AppCompatActivity
{
    CheckBox check1,check2,check3,check4,check5,check6,check7,check8,check9;
    Button CheckButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        initCheckBoxes();
        CheckButton = findViewById(R.id.CheckButton);
        CheckButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMessage("Rezultat", BoxesStatus());
            }
        });
    }

    public void initCheckBoxes()
    {
        check1 = findViewById(R.id.checkBox1);
        check2 = findViewById(R.id.checkBox2);
        check3 = findViewById(R.id.checkBox3);
        check4 = findViewById(R.id.checkBox4);
        check5 = findViewById(R.id.checkBox5);
        check6 = findViewById(R.id.checkBox6);
        check7 = findViewById(R.id.checkBox7);
        check8 = findViewById(R.id.checkBox8);
        check9 = findViewById(R.id.checkBox9);
    }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public String BoxesStatus()
    {
        if(check1.isChecked() | check2.isChecked() | check3.isChecked())
        {
            return "Aveti cele mai frecvente simptome, trebuie sa consultati un medic!";
        }
        else if(check4.isChecked() | check5.isChecked() | check6.isChecked())
        {
            return "Trebuie sa vizitati un doctor de urgenta!";
        }
        else if(check7.isChecked() | check8.isChecked() | check9.isChecked())
        {
            return "Nu trebuie sa va ingrijorati, simptomele dumneavoastra nu sunt grave!";
        }
        else
            return "Selectati cel putin 1 simptom!";
    }
}
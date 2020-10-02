package com.example.clienteparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page2 extends AppCompatActivity implements View.OnClickListener {
    private Button leftButton;
    private Button rightButton;
    private Button downButton;
    private Button upButton;
    private Button colorButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        leftButton=findViewById(R.id.leftButton);
        rightButton=findViewById(R.id.rightButton);
        downButton=findViewById(R.id.downButton);
        upButton=findViewById(R.id.upButton);
        colorButton=findViewById(R.id.colorButton);




        upButton.setOnClickListener(this);
        downButton.setOnClickListener(this);
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);



    }


    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.upButton:
                break;
            case R.id.downButton:
                break;

            case R.id.leftButton:
                break;

            case R.id.rightButton:
                break;

            case R.id.colorButton:
                break;
        }

    }

    }
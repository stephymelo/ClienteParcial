package com.example.clienteparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.Serializable;

public class Page2 extends AppCompatActivity implements View.OnClickListener,Serializable {
    private Button leftButton;
    private Button rightButton;
    private Button downButton;
    private Button upButton;
    private Button colorButton;
    private Circulo jugador;
    private TCPSingleton tcp;
    private String name;
    private String json;

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
        colorButton.setOnClickListener(this);


        tcp= TCPSingleton.getInstance();
        name=getIntent().getExtras().getString("nombre");

        jugador = (Circulo)getIntent().getSerializableExtra("jugador");



    }


    public void onClick(View v) {
        Gson gson=new Gson();
        json = gson.toJson(jugador);

        switch (v.getId()) {

            case R.id.upButton:
                jugador.setPosY(jugador.getPosY()-10);
                tcp.enviar(json);
                break;
            case R.id.downButton:
                jugador.setPosY(jugador.getPosY()+10);
                tcp.enviar(json);
                break;

            case R.id.leftButton:
                jugador.setPosX(jugador.getPosX()-10);
                tcp.enviar(json);
                break;

            case R.id.rightButton:
                jugador.setPosX(jugador.getPosX()+10);
                tcp.enviar(json);
                break;

            case R.id.colorButton:

                jugador.setB((int)(Math.random() * 255 + 1));
                jugador.setR((int)(Math.random() * 255 + 1));
                jugador.setG((int)(Math.random() * 255 + 1));
                tcp.enviar(json);
                break;
        }

    }

}
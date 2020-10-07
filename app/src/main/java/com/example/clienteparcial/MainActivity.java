package com.example.clienteparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    private Button okButton;
    private EditText nameEdit;
    private String nombre;
    private String json;
    private Circulo jugador;
    private TCPSingleton tcp;
    private int posX,posY,r,g,b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okButton=findViewById(R.id.okButton);
        nameEdit=findViewById(R.id.nameEdit1);
        posX=50;
        posY=50;
        r=0;
        g=0;
        b=0;

        tcp = TCPSingleton.getInstance();
        tcp.start();



        okButton.setOnClickListener(
                view -> {
                    Intent i=new Intent(this,Page2.class);
                    Gson gson=new Gson();
                    nombre=nameEdit.getText().toString();

                    jugador= new Circulo(nombre,posX,posY,r,g,b);
                    json = gson.toJson(jugador);
                    tcp.enviar(json);
                    i.putExtra("nombre",nombre);
                    i.putExtra("jugador",jugador);
                    i.putExtra("json",json);

                    startActivity(i);

                }
        );




    }






}
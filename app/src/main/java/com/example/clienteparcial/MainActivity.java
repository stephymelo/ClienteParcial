package com.example.clienteparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private Button okButton;
    private EditText nameEdit;
    private String nombre;
    private String json;
    private Circulo jugador;
    private TCPSingleton tcp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okButton=findViewById(R.id.okButton);
        nameEdit=findViewById(R.id.nameEdit1);

        tcp = TCPSingleton.getInstance();
        tcp.start();

//        int random = (int)(Math.random() * 50 + 1);


        okButton.setOnClickListener(
                view -> {
                    Intent i=new Intent(this,Page2.class);
                    Gson gson=new Gson();
                    nombre=nameEdit.getText().toString();
                    i.putExtra("nombre",nombre);
                    jugador= new Circulo(nombre,50,50,255,255,255);
                    json = gson.toJson(jugador);
                    tcp.enviar(json);
//                    startActivity(i);

                }
        );




    }






}
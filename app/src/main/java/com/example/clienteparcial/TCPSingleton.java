package com.example.clienteparcial;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSingleton extends Thread {


    private static TCPSingleton tcpsingleton;

    private TCPSingleton() {}



    public static TCPSingleton getInstance() {
        if(tcpsingleton == null) {
            tcpsingleton = new TCPSingleton();
        }
        return tcpsingleton;
    }


    private Socket socket;
    private BufferedWriter writer;
    private String mensaje = "";
    private MainActivity observer;

    //Metodo de subscripcion del observer - el observer es para :



    public void run() {
        try {

            //Conexion
            System.out.println("Enviando solicitud de conexion...");
            socket = new Socket("192.168.0.200", 5000);
            System.out.println("Conectamos");

            //
            InputStream is = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(out));
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            //
            while(true) {



            }


        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void enviar(String msg) {
        new Thread(

                ()->{
                    try {
                        writer.write(msg + "\n");
                        writer.flush();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

        ).start();


    }

    public String getMensaje() {
        return mensaje;
    }

}

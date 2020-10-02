package com.example.clienteparcial;

public class Circulo {
    private int posX,posY;
    private String nombre;
    private int r,g,b;

    public Circulo(String nombre,int posX,int posY,int r,int g,int b){
        this.nombre=nombre;
        this.posX=posX;
        this.posY=posY;
        this.r=r;
        this.g=g;
        this.b=b;
    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

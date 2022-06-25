package com.company;

public class Factura {
    private String info;
    private double coste;

    public Factura(String info, double coste) {
        this.info = info;
        this.coste = coste;
    }

    public String getInfo() {
        return info;
    }

    public double getCoste() {
        return coste;
    }
}

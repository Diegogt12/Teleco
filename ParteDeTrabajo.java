package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParteDeTrabajo {
    private String descripcionTrabajo;
    private int horasInvertidas;
    private double costeHora;
    private long fechaDeCreacion;

    public String getDescripcionTrabajo() {
        return descripcionTrabajo;
    }

    public void setDescripcionTrabajo(String descripcionTrabajo) {
        this.descripcionTrabajo = descripcionTrabajo;
    }

    public int getHorasInvertidas() {
        return horasInvertidas;
    }

    public void setHorasInvertidas(int horasInvertidas) {
        this.horasInvertidas = horasInvertidas;
    }

    public double getCosteHora() {
        return costeHora;
    }

    public void setCosteHora(double costeHora) {
        this.costeHora = costeHora;
    }

    public long getFechaDeCreacion() {
        return this.fechaDeCreacion;
    }

    public void setFechaDeCreacion(long fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public ParteDeTrabajo(String descripcionTrabajo, int horasInvertidas, double costeHora) throws ExArgumentoIncorrecto {
        if( descripcionTrabajo == null ) throw new ExArgumentoIncorrecto("Descripcion del trabajo no valida");
        this.descripcionTrabajo = descripcionTrabajo;
        if( horasInvertidas < 0 ) throw new ExArgumentoIncorrecto("Horas invertidas no validas");
        this.horasInvertidas = horasInvertidas;
        if( costeHora < 0 ) throw new ExArgumentoIncorrecto("Coste por hora no valida");
        this.costeHora = costeHora;
        Date creacion = new Date();
        SimpleDateFormat dateFormat = new
                SimpleDateFormat("yyyyMMddHHmmssSSS");
        this.setFechaDeCreacion(Long.parseLong(dateFormat.format(creacion))
        );

    }

    public double calcularCosteTotal() {
        return (this.costeHora * this.horasInvertidas);
    }

    public String getInfo() {
        String s = this.descripcionTrabajo + " / " + this.horasInvertidas + " / " + this.costeHora + " / " +  this.getFechaDeCreacion() + " / " + calcularCosteTotal();
        return s;
    }

}
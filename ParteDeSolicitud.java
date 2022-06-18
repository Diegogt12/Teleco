package com.company;

public class ParteDeSolicitud extends  ParteDeTrabajo{
    private double recargo;
    public ParteDeSolicitud(String descripcionTrabajo, int horasInvertidas, double costeHora, int recargo) throws ExArgumentoIncorrecto {
        super(descripcionTrabajo, horasInvertidas, costeHora);
        if (( recargo < 0 ) || ( recargo > 100 )) throw new ExArgumentoIncorrecto("Recargo no valido");
        this.recargo = recargo;
    }

    @Override
    public double calcularCosteTotal(){
        double recargo = this.recargo /100;
        double horasConRecargo = getCosteHora() + (recargo * getCosteHora());
        return (horasConRecargo * getHorasInvertidas());
    }
    @Override
    public String getInfo() {
        String s = getDescripcionTrabajo() + " / " + getHorasInvertidas() + " / " + getCosteHora() + " / " +  getFechaDeCreacion() +" / " + this.recargo + " / " + calcularCosteTotal();
        return s;
    }
}

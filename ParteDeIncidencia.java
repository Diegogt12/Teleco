package com.company;

public class ParteDeIncidencia extends ParteDeTrabajo {
    private double descuento;

    public ParteDeIncidencia(String descripcionTrabajo, int horasInvertidas, double costeHora, int descuento) throws ExArgumentoIncorrecto {
        super(descripcionTrabajo, horasInvertidas, costeHora);
        if (( descuento < 0 ) || ( descuento > 100 )) throw new ExArgumentoIncorrecto("Descuento no valido");
        this.descuento = descuento;
    }

   @Override
   public double calcularCosteTotal(){
       double rebaja = (this.descuento/100);
       double rebajaHora = getCosteHora() - (rebaja * getCosteHora());
       double costeTotal = rebajaHora * getHorasInvertidas();
       return costeTotal;
   }
   @Override
    public String getInfo() {
        String s = getDescripcionTrabajo() + " / " + getHorasInvertidas() + " / " + getCosteHora() + " / " +  getFechaDeCreacion() + " / "+ this.descuento +" / " + calcularCosteTotal();
        return s;
    }
}

package com.company;

import java.util.HashMap;


public class Gestor {
    private String nombreEmpresa;
    private HashMap<String, Cliente> clientes;

    public Gestor(String nombreEmpresa) throws ExArgumentoIncorrecto {
        if (nombreEmpresa == null) throw new ExArgumentoIncorrecto("Nombre de la empresa del gestor no valido");
        this.nombreEmpresa = nombreEmpresa;
        this.clientes = new HashMap<>();
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public void añadirCliente(Cliente c) {
        this.clientes.put(c.getNif(), c);
    }

    public void insertarParte(String nif, ParteDeTrabajo p) throws ExArgumentoIncorrecto {
        if(this.clientes.containsKey(nif)) this.clientes.get(nif).asignaParte(p);
        else throw new ExArgumentoIncorrecto("NIF no existe");
    }

    public void generarFacturasPorFecha(String nif) throws ExArgumentoIncorrecto {
        if(this.clientes.containsKey(nif)) this.clientes.get(nif).obtenerFacturasPorFecha();
        else throw new ExArgumentoIncorrecto("NIF no existe");
    }

    public void generarFacturaPorCoste(String nif) throws ExArgumentoIncorrecto {
        if(this.clientes.containsKey(nif)) this.clientes.get(nif).obtenerFacturasPorCoste();
        else throw new ExArgumentoIncorrecto("Nif no existe");
    }

    public double calculaCosteTotal() {
        double total = 0.0;
        for( Cliente p: this.clientes.values() ) {
            total += p.getCosteTotal();
        }
        return total;

}
}

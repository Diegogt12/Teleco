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

    public void insertarParte(String nif, ParteDeTrabajo p) {
        this.clientes.get(nif).asignaParte(p);
    }

    public void generarFacturasPorFecha(String nif) {
        this.clientes.get(nif).obtenerFacturasPorFecha();
    }

    public void generarFacturaPorCoste(String nif) {
        this.clientes.get(nif).obtenerFacturasPorCoste();
    }

    public double calculaCosteTotal() {
        double total = 0.0;
        for( Cliente p: this.clientes.values() ) {
            total += p.getCosteTotal();
        }
        return total;

}
}


//d. Escribir un método calculaCosteTotal que calcule el coste completo de la empresa
//de telecomunicaciones en instalaciones para todos sus clientes.
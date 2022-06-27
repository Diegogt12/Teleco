package com.company;

import com.sun.source.tree.Tree;

import java.util.Objects;
import java.util.TreeSet;

public class Cliente{
    private String nif;
    private String nombre;
    private String direcion;
    private TreeSet<ParteDeTrabajo> partesDeTrabajo;
    private TreeSet<Factura> facturas;


    public Cliente(String nif, String nombre, String direcion) throws ExArgumentoIncorrecto {
        if (nif == null) throw new ExArgumentoIncorrecto("NIF del cliente no valido");
        this.nif = nif;
        if (nombre == null) throw new ExArgumentoIncorrecto("Nombre del cliente no valido");
        this.nombre = nombre;
        if (direcion == null) throw new ExArgumentoIncorrecto("Direccion del cliente no valido");
        this.direcion = direcion;
        this.partesDeTrabajo = new TreeSet<ParteDeTrabajo>(new fechaComparator());
        this.facturas = new TreeSet<Factura>(new fechaComparatorFactura());
    }

    public TreeSet<ParteDeTrabajo> getPartesDeTrabajo() {
        return this.partesDeTrabajo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public void setParteDeTrabajo(TreeSet<ParteDeTrabajo> parteDeTrabajo) {
        this.partesDeTrabajo = parteDeTrabajo;
    }

    public void asignaParte(ParteDeTrabajo p) {
        this.partesDeTrabajo.add(p);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return nif.equals(cliente.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif);
    }

    public double getCosteTotal(){
        double total = 0.0;
        for( ParteDeTrabajo p: this.getPartesDeTrabajo() ) {
            total += p.calcularCosteTotal();
        }
        return total;
    }


    public void generarFactura(){
        String j="";
        for( ParteDeTrabajo p: this.getPartesDeTrabajo() ) {
           j +=  p.getInfo() + '\n' ;
        }
       Factura f = new Factura(j, this.getCosteTotal());

        this.facturas.add(f);

    }

    public TreeSet<Factura> obtenerFacturasPorFecha() {
        return facturas;
    }

    public TreeSet<Factura> obtenerFacturasPorCoste(){

        TreeSet<Factura> f = new TreeSet<Factura>(new costeTotalComparator());
        f.addAll(this.facturas);
        return f;
    }
}


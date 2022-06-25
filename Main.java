package com.company;

public class Main {

    public static void main(String[] args)  {

        try {
        ParteDeTrabajo pt1 = new ParteDeTrabajo("manual", 5, 6.0);
        ParteDeTrabajo pt2 = new ParteDeTrabajo("gestion", 2, 5.0);
        ParteDeIncidencia pi1 = new ParteDeIncidencia("gestion", 3, 5.5, 5);
        ParteDeIncidencia pi2 = new ParteDeIncidencia("manual", 5, 6.0, 10);
        ParteDeSolicitud ps1 = new ParteDeSolicitud("gestion",7,5,15);
        ParteDeSolicitud ps2 = new ParteDeSolicitud("manual", 5, 6.5, 20);


        Gestor g = new Gestor("Oramba");
        Cliente c = new Cliente("012345P", "pepe", "C/ calle");
        Cliente c1 = new Cliente("67890L","david", "C/falsa 123");
        g.añadirCliente(c);
        g.añadirCliente(c1);

        c.asignaParte(pt1);
        c.asignaParte(pi1);
        c.asignaParte(ps1);
        c.generarFactura();
        c1.asignaParte(pt2);
        c1.asignaParte(pi2);
        c1.asignaParte(ps2);
        c1.generarFactura();
        System.out.println("-Cliente 1 por coste : ");
        
        for( Factura f: c.obtenerFacturasPorCoste()){
                System.out.println( f.getInfo());
                System.out.println( f.getCoste());
            }
        System.out.println("- Cliente 1 por fecha : ");
        for( Factura f: c.obtenerFacturasPorFecha()){
            System.out.println( f.getInfo());
            System.out.println( f.getCoste());
        }
        System.out.println("------------------------------------");
            System.out.println("-Cliente 2 por coste : ");
            for( Factura f: c1.obtenerFacturasPorCoste()){
                System.out.println( f.getInfo());
                System.out.println( f.getCoste());
            }
            System.out.println("- Cliente 2 por fecha : ");
            for( Factura f: c1.obtenerFacturasPorFecha()){
                System.out.println( f.getInfo());
                System.out.println( f.getCoste());
            }
        System.out.println("--------------------------------------");
        System.out.println("Coste total del gestor : ");
        System.out.println(g.calculaCosteTotal());

    }catch(ExArgumentoIncorrecto ex){
        System.out.println(ex);
    }
    }





}

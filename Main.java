package com.company;

public class Main {

    public static void main(String[] args) t {
	try {
        ParteDeTrabajo p1 = new ParteDeTrabajo("manual", 5, 6.0);
        ParteDeIncidencia p2 = new ParteDeIncidencia("manual", 5, 6.0, 10);
        ParteDeSolicitud p3 = new ParteDeSolicitud("manual", 5, 6.5, 20);

        System.out.println(p1.getInfo());
        System.out.println(p2.getInfo());
        System.out.println((p3.getInfo()));
    }catch(ExArgumentoIncorrecto ex){
        System.out.println(ex);
    }
    }
}

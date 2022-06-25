package com.company;

import java.util.Comparator;

public class costeTotalComparator implements Comparator<Factura> {


    @Override
    public int compare(Factura o1, Factura o2) {
        if (o1.getCoste() > o2.getCoste()) return 1;
        return -1;
    }
}

package com.company;

import java.util.Comparator;

public class fechaComparator implements Comparator<ParteDeTrabajo> {
    @Override
    public int compare(ParteDeTrabajo o1, ParteDeTrabajo o2) {
        if( o1.getFechaDeCreacion() > o2.getFechaDeCreacion()) return 1;
        return -1;
    }
}


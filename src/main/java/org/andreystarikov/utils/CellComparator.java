package org.andreystarikov.utils;

import org.andreystarikov.tropicalisland.Cell;

import java.util.Comparator;

/**
 * Created by Andrey on 03.10.2016.
 */
public class CellComparator implements Comparator<Cell> {

    @Override
    public int compare(Cell o1, Cell o2) {
        if (o1.getAltitude() > o2.getAltitude()) return 1;
        if (o1.getAltitude() < o2.getAltitude()) return -1;
        if (o1.isCoast() && !o2.isCoast()) return -1;
        if (o2.isCoast() && !o1.isCoast()) return 1;
        return 0;
    }
}

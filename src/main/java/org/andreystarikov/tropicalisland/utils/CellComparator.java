package org.andreystarikov.tropicalisland.utils;

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
        return 0;
    }

//    @Override
//    public Comparator<Cell> reversed() {
//        return null;
//    }
//
//    @Override
//    public Comparator<Cell> thenComparing(Comparator<? super Cell> other) {
//        return null;
//    }
//
//    @Override
//    public <U> Comparator<Cell> thenComparing(Function<? super Cell, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
//        return null;
//    }
//
//    @Override
//    public <U extends Comparable<? super U>> Comparator<Cell> thenComparing(Function<? super Cell, ? extends U> keyExtractor) {
//        return null;
//    }
//
//    @Override
//    public Comparator<Cell> thenComparingInt(ToIntFunction<? super Cell> keyExtractor) {
//        return null;
//    }
//
//    @Override
//    public Comparator<Cell> thenComparingLong(ToLongFunction<? super Cell> keyExtractor) {
//        return null;
//    }
//
//    @Override
//    public Comparator<Cell> thenComparingDouble(ToDoubleFunction<? super Cell> keyExtractor) {
//        return null;
//    }
}

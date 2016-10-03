package org.andreystarikov.tropicalisland;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.PriorityQueue;

/**
 * Created by Andrey on 03.10.2016.
 */
public class TropicalIsland {

    private Cell[] cells;
    private int M, N, length;

    public TropicalIsland(int M, int N) {
        this.M = M;
        this.N = N;
    }

    public void mergeCells(Cell c1, Cell c2) {
        if (c1.getElementsInCell() >= c2.getElementsInCell()) {
            c1.setElementsInCell(c1.getElementsInCell() + c2.getElementsInCell());
            c1.setVolume(c1.getVolume() + c2.getVolume());
            c2.setParent(c1);
            mergeNeighbors(c1, c2);

        } else {
            c2.setElementsInCell(c1.getElementsInCell() + c2.getElementsInCell());
            c2.setVolume(c1.getVolume() + c2.getVolume());
            c1.setParent(c2);
            mergeNeighbors(c2, c1);
        }
    }

    private void mergeNeighbors(Cell c1, Cell c2) {
        for (Cell cells : c2.getNeighbors()) {
            c1.addNeighbor(cells);
        }
        c2.clearPQ();
    }

    public void setCells(Cell[] cells) {
        this.cells = cells;
    }

}

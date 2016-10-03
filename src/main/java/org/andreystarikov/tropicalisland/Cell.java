package org.andreystarikov.tropicalisland;

import java.util.PriorityQueue;

/**
 * Created by Andrey on 03.10.2016.
 */
public class Cell {

    private int altitude;
    private PriorityQueue<Cell> neighbors;
    private int volume = 0;
    private int elementsInCell = 1;
    private boolean coast = false;

    private Cell parent = this;

    public Cell(int altitude, boolean coast) {
        this.altitude = altitude;
        this.coast = coast;
    }

    public boolean isCoast() {
        if (parent!=this) return parent.isCoast();
        return coast;
    }

    public Cell getParent() {
        if (parent != this) return parent.getParent(); //parent = parent.getParent()???
        return parent;
    }

    public void setParent(Cell parent) {
        this.parent = parent;
    }

    public int getVolume() {
        if (parent != this) return parent.getVolume();
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getElementsInCell() {
        if (parent != this) return parent.getElementsInCell();
        return elementsInCell;
    }

    public void setElementsInCell(int elementsInCell) {
        this.elementsInCell = elementsInCell;
    }

    public void setCoast(boolean coast) {
        this.coast = coast;
    }

    public PriorityQueue<Cell> getNeighbors() {
        if (parent != this) return parent.getNeighbors();
        return neighbors;
    }

    public void setNeighbors(PriorityQueue<Cell> neighbors) {
        this.neighbors = neighbors;
    }

    public int getAltitude() {
        if (parent != this) return parent.getAltitude();
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public void clearPQ() {
        neighbors.clear();
    }
    public void addNeighbor(Cell c) {
        neighbors.add(c);
    }

}

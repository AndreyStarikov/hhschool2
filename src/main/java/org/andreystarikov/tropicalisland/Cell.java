package org.andreystarikov.tropicalisland;

import java.util.PriorityQueue;

import org.andreystarikov.utils.CellComparator;

/**
 * Created by Andrey on 03.10.2016.
 */
public class Cell {

    private int altitude;
    private PriorityQueue<Cell> neighbors;
    private int volume = 0;
    private boolean coast;
    private int numberOfCells = 1;

    public Cell(int altitude, boolean coast) {
        this.altitude = altitude;
        this.coast = coast;
        neighbors = new PriorityQueue<>(new CellComparator());
    }

    public boolean isCoast() {
        return coast;
    }

    public int getNumberOfNeighbors() {
        return neighbors.size();
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setCoast(boolean coast) {
        this.coast = coast;
    }

    public PriorityQueue<Cell> getNeighbors() {
        return neighbors;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public void clearNeighbors() {
        neighbors.clear();
    }

    public void addNeighbor(Cell c) {
        if (!neighbors.contains(c)) {
            neighbors.add(c);
        }
    }

    public Cell getMinNeighbor() {
        return neighbors.peek();
    }

    public int increase(Cell c2) {
        if (c2.getAltitude() < altitude) throw new IllegalArgumentException();
        int result = (c2.getAltitude() - altitude) * numberOfCells;
        volume = volume + result;
        altitude = c2.getAltitude();
        return result;
    }

    public void remove(Cell c2) {
        neighbors.remove(c2);
    }

    public void setNumberOfCells(int num) {
        numberOfCells = num;
    }

    public int getNumberOfCells() {
        return numberOfCells;
    }

    @Override
    public String toString() {
        return "Alt. = " + altitude
                + ", Coast - " + coast
                + ", NoN = " + getNumberOfNeighbors()
                + ", vol. = " + volume;
    }

    public int compareTo(Cell c2) {
        return altitude - c2.getAltitude();
    }

    /**
     * Для отладки
     */
    public String toStringTest() {
        String s;
        if (coast) s = altitude + "*";
        else s = altitude + " ";
        return s;
    }
}

package org.andreystarikov.tropicalisland;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrey on 07.10.2016.
 */
public class CellTest {

    private Cell cell;

    @Before
    public void setUp() {
        cell = new Cell(3, false);
    }

    @Test
    public void testIsCoastDefault() {
        System.out.println("isCoast");
        assertEquals(false, cell.isCoast());
    }

    @Test
    public void testGetNumberOfNeighbors() {
        System.out.println("getNumberOfNeighbors");
        assertEquals(0, cell.getNumberOfNeighbors());
        cell.addNeighbor(new Cell(7, true));
        assertEquals(1, cell.getNumberOfNeighbors());

    }

    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        assertEquals(0, cell.getVolume());
    }

    @Test
    public void testSetVolume() {
        System.out.println("setVolume");
        cell.setVolume(6);
        assertEquals(6, cell.getVolume());
    }

    @Test
    public void testSetCoast() {
        System.out.println("setCoast");
        cell.setCoast(true);
        assertEquals(true, cell.isCoast());
        cell.setCoast(false);
        assertEquals(false, cell.isCoast());
    }

    @Test
    public void testGetNeighbors() {
        System.out.println("getNeighbors");

    }

    @Test
    public void testSetNeighbors() {
        System.out.println("setNeighbors");
    }

    @Test
    public void testGetAltitude() {
        assertEquals(3, cell.getAltitude());
    }

    @Test
    public void testSetAltitude() {
        cell.setAltitude(34);
        assertEquals(34, cell.getAltitude());
    }

    @Test
    public void testClearNeighbors() {
        System.out.println("clearNeighbors");
        cell.addNeighbor(new Cell(45, true));
        cell.addNeighbor(new Cell(4, false));
        cell.addNeighbor(new Cell(34, false));
        cell.addNeighbor(new Cell(5, false));
        cell.addNeighbor(new Cell(25, false));
        assertEquals(5, cell.getNumberOfNeighbors());
        cell.clearNeighbors();
        assertEquals(0, cell.getNumberOfNeighbors());

    }

    @Test
    public void testAddNeighbor() {
        System.out.println("addNeighbor");
        assertEquals(0, cell.getNumberOfNeighbors());
        cell.addNeighbor(new Cell(7, true));
        assertEquals(1, cell.getNumberOfNeighbors());
//        System.out.println(cell.getMinNeighbor().toString());

    }

    @Test
    public void testGetMinNeighbor() {
        System.out.println("getMinNeighbor");
        cell.addNeighbor(new Cell(45, true));
        cell.addNeighbor(new Cell(4, false));
        cell.addNeighbor(new Cell(34, false));
        cell.addNeighbor(new Cell(5, false));
        cell.addNeighbor(new Cell(25, false));
        assertEquals(4, cell.getMinNeighbor().getAltitude());
    }

    @Test
    public void testIncrease1() {
        System.out.println("increase1");
        Cell cell2 = new Cell(25, false);
        cell.increase(cell2);
        assertEquals(25, cell.getAltitude());
        assertEquals(22, cell.getVolume());
    }

    @Test
    public void testIncrease2() {
        System.out.println("increase2");
        Cell cell2 = new Cell(25, false);
        cell.setVolume(5);
        cell.increase(cell2);
        assertEquals(27, cell.getVolume());
    }

    @Test
    public void testIncrease3() {
        System.out.println("increase3");
        Cell cell2 = new Cell(7, false);
        cell.setVolume(5);
        cell.setNumberOfCells(6);
        cell.increase(cell2);
        assertEquals(29, cell.getVolume());
    }

    @Test
    public void testCompareTo() {
        Cell cell2 = new Cell(7, true);
        assertEquals(-4, cell.compareTo(cell2));
        cell2.setAltitude(3);
        assertEquals(0, cell.compareTo(cell2));
        cell2.setAltitude(1);
        assertEquals(2, cell.compareTo(cell2));
    }

    @Test
    public void testRemove() {
        Cell[] array = new Cell[3];
        array[0] = new Cell(45, true);
        array[1] = new Cell(4, true);
        array[2] = new Cell(5, false);
        cell.addNeighbor(array[0]);
        cell.addNeighbor(array[1]);
        cell.addNeighbor(array[2]);
        assertEquals(3, cell.getNumberOfNeighbors());
        cell.remove(array[1]);
        assertEquals(2, cell.getNumberOfNeighbors());
    }

}

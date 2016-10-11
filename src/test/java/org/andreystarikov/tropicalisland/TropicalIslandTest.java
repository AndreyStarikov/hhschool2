package org.andreystarikov.tropicalisland;

import org.andreystarikov.utils.IslandGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrey on 07.10.2016.
 */
public class TropicalIslandTest {

    TropicalIsland ti;
    int M, N;
    int[][] array;

    /**
     * 9 8 7 8 9 6 7 4
     * 8 3 5 4 8 1 2 3
     * 7 3 3 8 8 7 5 4
     * 7 3 8 1 8 2 2 5
     * 8 9 9 9 1 9 7 1
     */
    @Test
    public void testGetVolume1() {
        M = 5;
        N = 8;
        ti = new TropicalIsland(M, N);
        array = new int[M][N];
        array[0][0] = 9;
        array[0][1] = 8;
        array[0][2] = 7;
        array[0][3] = 8;
        array[0][4] = 9;
        array[0][5] = 6;
        array[0][6] = 7;
        array[0][7] = 4;

        array[1][0] = 8;
        array[1][1] = 3;
        array[1][2] = 5;
        array[1][3] = 4;
        array[1][4] = 8;
        array[1][5] = 1;
        array[1][6] = 2;
        array[1][7] = 3;

        array[2][0] = 7;
        array[2][1] = 3;
        array[2][2] = 3;
        array[2][3] = 8;
        array[2][4] = 8;
        array[2][5] = 7;
        array[2][6] = 5;
        array[2][7] = 4;

        array[3][0] = 7;
        array[3][1] = 3;
        array[3][2] = 8;
        array[3][3] = 1;
        array[3][4] = 8;
        array[3][5] = 2;
        array[3][6] = 2;
        array[3][7] = 5;

        array[4][0] = 8;
        array[4][1] = 9;
        array[4][2] = 9;
        array[4][3] = 9;
        array[4][4] = 1;
        array[4][5] = 9;
        array[4][6] = 7;
        array[4][7] = 1;

        ti.setCells(array);
//        ti.printCells();
        assertEquals(37, ti.getVolume());
//        ti.printCells();
    }

    /**
     * 9 8 7 8 9
     * 8 3 5 4 8
     * 7 3 3 8 8
     * 7 3 8 1 8
     * 8 9 9 9 1
     */
    @Test
    public void testGetVolume2() {
        M = 5;
        N = 5;
        ti = new TropicalIsland(M, N);
        array = new int[M][N];
        array[0][0] = 9;
        array[0][1] = 8;
        array[0][2] = 7;
        array[0][3] = 8;
        array[0][4] = 9;

        array[1][0] = 8;
        array[1][1] = 3;
        array[1][2] = 5;
        array[1][3] = 4;
        array[1][4] = 8;

        array[2][0] = 7;
        array[2][1] = 3;
        array[2][2] = 3;
        array[2][3] = 8;
        array[2][4] = 8;

        array[3][0] = 7;
        array[3][1] = 3;
        array[3][2] = 8;
        array[3][3] = 1;
        array[3][4] = 8;

        array[4][0] = 8;
        array[4][1] = 9;
        array[4][2] = 9;
        array[4][3] = 9;
        array[4][4] = 1;
        ti.setCells(array);

        assertEquals(28, ti.getVolume());
    }

    @Test
    public void testGetVolume3(){
        M = 10;
        N = 8;
        ti = new TropicalIsland(M,N);
        int[][] arr = IslandGenerator.generate(M,N);
        ti.setCells(arr);
//        ti.printCells();
        System.out.println(ti.getVolume());
//        ti.printCells();
    }

    @Test
    public void testGetVolume4(){
        M = 50;
        N = 50;
        ti = new TropicalIsland(M,N);
        int[][] arr = IslandGenerator.generate(M,N);
        ti.setCells(arr);
//        ti.printCells();
        System.out.println(ti.getVolume());
//        ti.printCells();
    }

    /**
     * 9 6 7 8
     * 3 2 3 4
     * 7 3 3 8
     * 7 5 8 1
     */
    @Test
    public void testGetVolume5() {
        M = 4;
        N = 4;
        ti = new TropicalIsland(M, N);
        array = new int[M][N];
        array[0][0] = 9;
        array[0][1] = 8;
        array[0][2] = 7;
        array[0][3] = 8;

        array[1][0] = 3;
        array[1][1] = 2;
        array[1][2] = 3;
        array[1][3] = 4;

        array[2][0] = 7;
        array[2][1] = 3;
        array[2][2] = 3;
        array[2][3] = 8;

        array[3][0] = 7;
        array[3][1] = 5;
        array[3][2] = 8;
        array[3][3] = 1;
        ti.setCells(array);
//        System.out.println(ti.getVolume());
        assertEquals(1, ti.getVolume());
    }
}

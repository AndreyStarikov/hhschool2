package org.andreystarikov.tropicalisland;

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

    private Cell mergeCells(Cell c1, Cell c2) {
        if (c1.getNumberOfNeighbors() >= c2.getNumberOfNeighbors()) {
            return mergeRealisation(c1, c2);
        } else {
            return mergeRealisation(c2, c1);
        }
    }

    private Cell mergeRealisation(Cell c1, Cell c2) {
        c1.setVolume(c1.getVolume() + c2.getVolume());
        if (c2.isCoast()) {
            c1.setCoast(true);
        }
        c1.setNumberOfCells(c1.getNumberOfCells() + c2.getNumberOfCells());
        mergeNeighbors(c1, c2);
        changeLink(c1, c2);
        return c1;
    }

    private void mergeNeighbors(Cell c1, Cell c2) {
        c1.remove(c2);
        c2.remove(c1);
        for (Cell cells : c2.getNeighbors()) {
            c1.addNeighbor(cells);
            cells.remove(c2);
            cells.addNeighbor(c1);
        }
        c2.clearNeighbors();
    }

    private void changeLink(Cell c1, Cell c2) {
        for (int i = 0; i < length; i++) {
            if (cells[i] == c2) cells[i] = c1;
        }
    }

    public int getVolume() {
        int volume = 0;
//        int cnt = 0; //Debug
        for (int i = N; i < length - N; i++) {
            Cell cell = cells[i];

            while (!cell.isCoast()) {
//                cnt++; //Debug
                Cell cell2 = cell.getMinNeighbor();
                int compare = cell.compareTo(cell2);

                if (compare > 0) {
                    cell = cell2;
                } else if (compare == 0) {
                    cell = mergeCells(cell, cell2);
                } else {
                    volume += cell.increase(cell2);
                    cell = mergeCells(cell, cell2);
                }
            }
        }
//        System.out.println(cnt); //Debug
        return volume;
    }

    public void setCells(int[][] array) {
        if (M != array.length || array[0].length != N) {
            throw new IllegalArgumentException();
        }
        length = M * N;
        cells = new Cell[length];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                boolean coast = false;
                if (i == 0 || i == M - 1 || j == 0 || j == N - 1) {
                    coast = true;
                }
                cells[i * N + j] = new Cell(array[i][j], coast);
            }
        }
        setNeighbors();
    }

    private void setNeighbors() {
        for (int i = 0; i < length; i++) {
            int top = i - N;
            int bottom = i + N;
            int right = i + 1;
            if (top >= 0) {
                cells[i].addNeighbor(cells[top]);
            }
            if (bottom < length) {
                cells[i].addNeighbor(cells[bottom]);
            }
            if (i % N != 0) {
                cells[i].addNeighbor(cells[i - 1]);
            }
            if (right % N != 0) {
                cells[i].addNeighbor(cells[right]);
            }
        }
    }
}

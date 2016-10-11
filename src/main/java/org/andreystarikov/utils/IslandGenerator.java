package org.andreystarikov.utils;

/**
 * Created by Andrey on 08.10.2016.
 */
public class IslandGenerator {
    public static int[][] generate(int M, int N) {
        int[][] array;
        array = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = (int) (Math.random() * 1000) + 1;
            }
        }
        return array;
    }
}
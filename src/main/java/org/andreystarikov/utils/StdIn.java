package org.andreystarikov.utils;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Andrey on 07.10.2016.
 */
public class StdIn {

    public static int[] readIntArray(BufferedReader reader, int number, int min, int max) {
        int[] result = new int[number];
        String[] tokens;
        try {
            String s = reader.readLine();
            tokens = s.split(" ");
            if (tokens.length != number) {
                throw new IOException("Неверное количество чисел");
            }
            try {
                for (int i = 0; i < number; i++) {
                    result[i] = Integer.parseInt(tokens[i]);
                    if (result[i] < min || result[i] > max) {
                        throw new IOException("Число вышло за границы:" + result[i]);
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("Неверный формат числа");
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int[] readIntArray(BufferedReader reader, int length) throws IOException {
        String s;
        int[] array = null;
        try {
            s = reader.readLine();
            array = s.chars()
                    .map(x -> x - '0')
                    .toArray();
            if (array.length > length) {
                throw new IOException("слишком длинная последовательность: " + array.length);
            }
        } catch (IOException e) {
            throw e;
        }
        return array;
    }

    public static int readInt(BufferedReader reader) {
        int result = 0;
        try {
            String s = reader.readLine();
            try {
                result = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.err.println("Неверный формат числа");
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

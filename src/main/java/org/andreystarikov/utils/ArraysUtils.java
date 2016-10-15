package org.andreystarikov.utils;

import java.util.ArrayList;

/**
 * Created by Andrey on 11.10.2016.
 */
public class ArraysUtils {
    public static boolean arrayCompare(int[] a, int[] a2) {
        if (a == a2)
            return true;
        if (a == null || a2 == null)
            return false;

        int length = a.length;
        if (a2.length != length)
            return false;

        for (int i = 0; i < length; i++)
            if (a[i] != a2[i])
                return false;

        return true;
    }

    public static int[] arrayDecrement(int[] a) {
        int length = a.length;
        if (a[length - 1] == 0) {
            int i = length - 1;
            while (true) {
                if (i < 0) throw new IllegalArgumentException("Массив начинается с 0!");
                if (a[i] == 0) {
                    a[i] = 9;
                    i--;
                } else {
                    a[i] = a[i] - 1;
                    break;
                }
            }
            if (a[0] == 0) {
                int[] result = new int[length - 1];
                System.arraycopy(a, 1, result, 0, length - 1);
                return result;
            } else return a;
        } else {
            a[length - 1] = a[length - 1] - 1;
            return a;
        }
    }

    public static int[] arrayIncrement(int[] a) {
        int overflow = 1;
        int c;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = a.length - 1; i >= 0; i--) {
            c = a[i] + overflow;
            if (c == 10) list.add(0);
            else {
                overflow = 0;
                list.add(c);
            }
        }
        if (overflow > 0) list.add(overflow);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(list.size() - 1 - i);
        }
        return result;
    }

    /**
     * состоит ли массив из одних нулей?
     */
    public static boolean isZeroArray(int[] subString) {
        boolean zeroes = true;
        for (int c : subString) {
            if (c != 0) {
                zeroes = false;
                break;
            }
        }
        return zeroes;
    }

    public static int[] generateArray(int length) {
        int[] array = new int[length];
        array[0] = 1;
        return array;
    }
}

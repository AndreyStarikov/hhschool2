package org.andreystarikov.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andrey on 11.10.2016.
 */
public class ArraysUtilsTest {
    @Test
    public void arrayCompare() throws Exception {
        int[] a = new int[]{1, 2, 1};
        int[] b = new int[]{1, 2, 1};
        assertEquals(true, ArraysUtils.arrayCompare(a, b));
    }

    @Test
    public void arrayDecrement1() throws Exception {
        int[] a = new int[]{1, 2, 1};
        int[] b = ArraysUtils.arrayDecrement(a);
        for (int c : b) {
            System.out.print(c);
        }
        System.out.println();
    }

    @Test
    public void arrayDecrement2() throws Exception {
        int[] a = new int[]{1, 2, 0};
        int[] b = ArraysUtils.arrayDecrement(a);
        for (int c : b) {
            System.out.print(c);
        }
        System.out.println();
    }

    @Test
    public void arrayDecrement3() throws Exception {
        int[] a = new int[]{1, 0, 0, 0, 0, 0, 0};
        int[] b = ArraysUtils.arrayDecrement(a);
        for (int c : b) {
            System.out.print(c);
        }
        System.out.println();
    }

    @Test
    public void arrayIncrement1() throws Exception {
        int[] a = new int[]{1, 0, 0};
        int[] b = ArraysUtils.arrayIncrement(a);
        for (int c : b) {
            System.out.print(c);
        }
        System.out.println();
    }

    @Test
    public void arrayIncrement2() throws Exception {
        int[] a = new int[]{1, 9, 9};
        int[] b = ArraysUtils.arrayIncrement(a);
        for (int c : b) {
            System.out.print(c);
        }
        System.out.println();
    }

    @Test
    public void arrayIncrement3() throws Exception {
        int[] a = new int[]{9, 9, 9, 9, 9, 9};
        int[] b = ArraysUtils.arrayIncrement(a);
        for (int c : b) {
            System.out.print(c);
        }
        System.out.println();
    }

    @Test
    public void generateArray() throws Exception {
        int[] a = ArraysUtils.generateArray(3);
        for (int c : a) {
            System.out.print(c);
        }
        System.out.println();
    }

}
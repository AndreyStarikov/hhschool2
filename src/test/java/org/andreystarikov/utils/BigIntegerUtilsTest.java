package org.andreystarikov.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by a.starikov on 12.10.2016.
 */
@RunWith(Parameterized.class)
public class BigIntegerUtilsTest {

    private int[] array;
    private BigInteger expected;

    public BigIntegerUtilsTest(int[] array, long exp) {
        this.array = array;
        expected = BigInteger.valueOf(exp);
    }

//    @Test
//    public void getResultFromFullSequence() throws Exception {
//        int[] a = new int[]{9, 8, 9, 9, 9, 1, 0, 0, 0};
//        BigInteger b = BigIntegerUtils.getResult(1, 4, a);
//        System.out.println(b);
//    }
//    @Test
//    public void g(){
//        int[] i = new int[]{9, 1, 9, 9};
//        System.out.println(BigIntegerUtils.getResult(i));
//    }

    @Test
    public void testGetResult() {
        BigInteger actual = BigIntegerUtils.getResult(array);
        assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static List<Object[]> generatedDataPoints() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 9, 3, 2, 4}, 85510},
                {new int[]{1, 2, 1, 2}, 3738},
                {new int[]{1, 0, 0, 0, 0}, 38890},
                {new int[]{1, 1, 1, 1}, 3334},
                {new int[]{9, 1, 9, 2, 0}, 448490},
                {new int[]{9, 9, 1, 9, 2}, 484850},
                {new int[]{1, 9, 2, 0, 0}, 84890},
                {new int[]{9, 1, 9, 9, 1}, 448845},
                {new int[]{2, 9, 9, 9, 9, 9, 9}, 19888883},
                {new int[]{1, 2, 9, 3}, 4062},
                {new int[]{1, 3}, 16},
                {new int[]{4}, 4}
        });
    }
}
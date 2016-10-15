package org.andreystarikov.infinitesequence;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrey on 11.10.2016.
 */
@RunWith(Parameterized.class)
public class SequenceTest {

    private int[] array;
    private BigInteger expected;

    public SequenceTest(int[] array, long exp){
        this.array = array;
        expected = BigInteger.valueOf(exp);
    }

    @Test
    public void testFindSequence() {
        BigInteger actual = Sequence.findSequence(array);
        assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static List<Object[]> findSequence() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 1, 2, 1, 2}, 3738},
                {new int[]{0, 0, 0, 0}, 38891},
                {new int[]{1, 1, 1, 1, 1, 1}, 3334},
                {new int[]{9, 1, 9, 9, 1, 9}, 84886},
                {new int[]{9, 9, 9, 9, 9}, 438886},
                {new int[]{2, 1, 1, 3, 1, 1}, 228},
                {new int[]{2, 1, 3, 1}, 15}
        });
    }
}
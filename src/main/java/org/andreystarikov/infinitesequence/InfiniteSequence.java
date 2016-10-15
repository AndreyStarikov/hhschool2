package org.andreystarikov.infinitesequence;

import org.andreystarikov.utils.StdIn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Andrey on 12.10.2016.
 */
public class InfiniteSequence {
    public static final int SEQUENCE_LENGTH = 50;

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] sequence = StdIn.readIntArray(reader, SEQUENCE_LENGTH);
            BigInteger position = Sequence.findSequence(sequence);
            System.out.println(position);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

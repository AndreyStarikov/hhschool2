package org.andreystarikov.infinitesequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 10.10.2016.
 */
public class Sequence extends InfiniteSequence {

    public List<String> GetOneExpectSequence(int minCapacity, int numMinCapacityVals, int start) {
        List<String> array;
        List<String> lseq = new ArrayList<>();
        String seq = inputString;
        if (start > 0) {
            lseq.add(seq.substring(0, start));
            seq = seq.substring(start);
            array = GetSequenceStartsFrom0(lseq, seq, minCapacity, numMinCapacityVals);
        } else {
            lseq.add(seq.substring(0, minCapacity));
            seq = seq.substring(minCapacity);
            array = GetSequenceStartsFrom0(lseq, seq, minCapacity, numMinCapacityVals);
        }
        if (array != null) {
            boolean flag = false;

            for (int i = 0; i < allSequences.size(); i++) {
                if (allSequences.get(i).equals(array)) {
                    flag = true;
                }
            }
            if (!flag) {
                allSequences.add(array);
                return array;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private List<String> GetSequenceStartsFrom0(List<String> lseq, String seq, int minCapacity, int numMinCapacityVals) {
        int i = 0;
        while (i < numMinCapacityVals) {
            if (seq.startsWith("0")) {
                return null;
            }
            if (seq.length() > minCapacity) {
                lseq.add(seq.substring(0, minCapacity));
                seq = seq.substring(minCapacity);
            } else {
                lseq.add(seq);
                seq = "";
            }
            i++;
        }
        if (seq.length() > 0) {
            i = 0;
            minCapacity++;
            while (seq.length() > 0) {
                if (seq.startsWith("0")) {
                    return null;
                }
                if (seq.length() > minCapacity) {
                    lseq.add(seq.substring(0, minCapacity));
                    seq = seq.substring(minCapacity);
                } else {
                    lseq.add(seq);
                    seq = "";
                }
                i++;
            }
        }
        return lseq;
    }
}
package org.andreystarikov.infinitesequence;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Andrey on 10.10.2016.
 */
public class SequenceOfThreeAndMoreNumbers extends InfiniteSequence {

    public boolean Check(List<String> array) {
        boolean isExtremeCorrect;
        isExtremeCorrect = checkExtremeValues(array);
        BigInteger newExpFirstCompleteValue = convertStringToBI(array.get(1)).subtract(new BigInteger("1"));
        if (isExtremeCorrect) {
            if (array.size() > 3) {
                if (checkInternalValues(array)) {
                    ExpFirstCompleteValue = newExpFirstCompleteValue;
                    ExpFirstInputValue = array.get(0);
                    return true;
                }
            } else {
                ExpFirstCompleteValue = newExpFirstCompleteValue;
                ExpFirstInputValue = array.get(0);
                return true;
            }
        }
        return false;
    }

    private boolean checkExtremeValues(List<String> array) {
        String endOfFirstValue = array.get(0);
        BigInteger neededValue = convertStringToBI(array.get(1)).subtract(new BigInteger("1"));
        String neededFirstValue = convertToString(neededValue);
        if (!neededFirstValue.endsWith(endOfFirstValue)) {
            return false;
        }
        String startOfLastValue = array.get(array.size() - 1);
        neededValue = convertStringToBI(array.get(array.size() - 2)).add(new BigInteger("1"));
        String neededLastValue = convertToString(neededValue);
        return neededLastValue.startsWith(startOfLastValue);
    }

    private boolean checkInternalValues(List<String> array) {
        for (int i = 1; i < array.size() - 2; i++) {
            if (!convertStringToBI(array.get(i)).add(new BigInteger("1")).equals(convertStringToBI(array.get(i + 1)))) {
                return false;
            }
        }
        return true;
    }
}

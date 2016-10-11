package org.andreystarikov.infinitesequence;

import java.math.BigInteger;

/**
 * Created by Andrey on 10.10.2016.
 */
public class SequencePosition extends InfiniteSequence {

    public static BigInteger Find() {
        BigInteger position = new BigInteger("0");
        String completeValue = convertToString(firstCompleteValue);
        String count = "9";
        if (completeValue.length() > 1) {
            for (int i = 1; i < completeValue.length(); i++) {
                position = position.add(convertStringToBI(count).multiply(convertStringToBI(String.valueOf(i))));
                count += "0";
            }
        }
        position = position.add(new BigInteger("1"));
        count = count.replace("9", "1");
        String help1 = String.valueOf(firstCompleteValue);
        String help2 = String.valueOf(convertToString(firstCompleteValue).length());
        position = position.add((new BigInteger(help1).subtract(new BigInteger(count))).multiply(new BigInteger(help2)));
        BigInteger sub = new BigInteger(String.valueOf(completeValue.length()));
        sub = sub.subtract(new BigInteger(String.valueOf(firstInputVal.length())));
        position = position.add(sub);
        return position;
    }
}

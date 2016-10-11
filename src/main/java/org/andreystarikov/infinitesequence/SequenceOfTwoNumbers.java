package org.andreystarikov.infinitesequence;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Andrey on 10.10.2016.
 */
public class SequenceOfTwoNumbers extends InfiniteSequence {


    private boolean createMinSequenceFromTwoValues(String st1, String st2) {
        if (st1.endsWith("9")) {
            return createSequenceFromTwoValuesWith9(st1, st2);
        } else {
            return createSeqFromTwoValuesWithout9(st1, st2);
        }
    }

    public boolean Check(List<String> array) {
        ExpFirstInputValue = array.get(0);
        boolean minSeqWasFind;

        if (((convertStringToBI(array.get(1))).subtract(convertStringToBI(array.get(0)))).equals(new BigInteger("1"))) {
            ExpFirstCompleteValue = convertStringToBI(array.get(0));
            return true;
        } else {
            minSeqWasFind = createMinSequenceFromTwoValues(array.get(0), array.get(1));
        }
        if (minSeqWasFind) return true;
        else {
            String st1 = array.get(0);
            String st2 = array.get(1);
            String concatStrings = st2 + st1;
            ExpFirstCompleteValue = convertStringToBI(concatStrings);
            return true;
        }
    }

    private boolean createSequenceFromTwoValuesWith9(String st1, String st2) {
        String v1p1 = st1;
        String v1p2 = "";
        String v2p1 = st2;
        String v2p2 = "";
        while (v1p1.length() > 0) {
            if (v1p1.charAt(v1p1.length() - 1) == '9') {
                v1p1 = v1p1.substring(0, v1p1.length() - 1);
                v1p2 = v1p2 + "9";
            } else break;
        }
        while (v2p1.length() > 0) {
            if (v2p1.charAt(v2p1.length() - 1) == '0') {
                v2p1 = v2p1.substring(0, v2p1.length() - 1);
                v2p2 = v2p2 + "0";
            } else break;
        }
        if (v1p1.length() == 0 && v2p2.length() == 0) {
            v1p1 = convertToString(convertStringToBI(v2p1).subtract(new BigInteger("1")));
            ExpFirstCompleteValue = convertStringToBI(v1p1 + v1p2);
            return true;
        } else if (v2p2.length() == 0) {
            if (v1p1.length() > v2p1.length()) {
                if (v1p1.startsWith(v2p1)) {
                    ExpFirstCompleteValue = convertStringToBI(st1);
                    return true;
                }
            } else if (v1p1.length() < v2p1.length()) {
                if (v2p1.startsWith(v1p1)) {
                    ExpFirstCompleteValue = convertStringToBI(v2p1 + v1p2);
                    return true;
                }
            } else {
                if (convertStringToBI(v2p1).subtract(convertStringToBI(v1p1)).equals(new BigInteger("1"))) {
                    ExpFirstCompleteValue = convertStringToBI(st1);
                    return true;
                }
            }
        } else if (v1p1.length() == 0) {
            if (v1p2.length() < v2p2.length()) {
                v1p2 = v2p2;
                v1p2 = v1p2.replace("0", "9");
                ExpFirstCompleteValue = convertStringToBI(convertStringToBI(v2p1).subtract(new BigInteger("1")) + v1p2);
                return true;
            }
            if (v1p2.length() >= v2p2.length()) {
                ExpFirstCompleteValue = convertStringToBI(convertStringToBI(v2p1).subtract(new BigInteger("1")) + v1p2);
                return true;
            }
        } else {
            if (v1p2.length() >= v2p2.length()) {
                if (v2p1.length() >= v1p1.length()) {
                    if (v2p1.endsWith(v1p1)) {
                        v1p1 = convertToString(convertStringToBI(v2p1).subtract(new BigInteger("1")));
                        ExpFirstCompleteValue = convertStringToBI(v1p1 + v1p2);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean createSeqFromTwoValuesWithout9(String st1, String st2) {
        if (st1.length() < st2.length()) {
            String full1 = convertToString(convertStringToBI(st2).subtract(new BigInteger("1")));
            if (full1.endsWith(st1)) {
                ExpFirstCompleteValue = convertStringToBI(st2).subtract(new BigInteger("1"));
                return true;
            }
        } else {
            String full2 = convertToString(convertStringToBI(st1).add(new BigInteger("1")));
            if (full2.startsWith(st2)) {
                ExpFirstCompleteValue = convertStringToBI(st1);
                return true;
            }
        }
        if (st1.length() < st2.length()) {
            boolean find = false;
            String st2Ends = st1;
            while (st2Ends.length() > 0 && !find) {
                if (st2.endsWith(st2Ends)) {
                    find = true;
                } else st2Ends = st2Ends.substring(0, st2Ends.length() - 1);
            }
            if (find) {
                BigInteger completeValue1 = convertStringToBI(st2.substring(0, st2.lastIndexOf(st2Ends)) + st1);
                BigInteger completeValue2 = convertStringToBI(st1 + st2.substring(st2.lastIndexOf(st2Ends)));
                if (completeValue1.add(new BigInteger("1")).equals(completeValue2)) {
                    ExpFirstCompleteValue = completeValue1;
                    return true;
                }
            }
        } else {
            boolean find = false;
            String st1starts = st2;
            while (st1starts.length() > 0 && !find) {
                if (st1.startsWith(st1starts)) {
                    find = true;
                } else st1starts = st1starts.substring(1);
            }
            if (find) {
                BigInteger completeValue1 = convertStringToBI(st2.substring(0, st2.lastIndexOf(st1starts)) + st1);
                BigInteger completeValue2 = convertStringToBI(st1 + st2.substring(0, st2.lastIndexOf(st1starts)));
                if (completeValue1.add(new BigInteger("1")).equals(completeValue2)) {
                    ExpFirstCompleteValue = completeValue1;
                    return true;
                }
            }
        }
        return false;
    }
}

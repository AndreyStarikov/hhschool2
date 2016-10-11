package org.andreystarikov.infinitesequence;

import java.util.*;
import java.math.*;
import java.util.regex.Pattern;

/**
 * Created by Andrey on 10.10.2016.
 */
public class InfiniteSequence {
    public static String inputString;
    public static String ExpFirstInputValue;
    public static int inputStringLength;
    public static BigInteger ExpFirstCompleteValue;
    public static String firstInputVal;
    public static BigInteger firstCompleteValue;
    public static List<List<String>> allSequences = new ArrayList<>();

    private boolean IsInputStringConsistOnlyZeroes(String inStr) {
        inStr = inStr.replaceAll("0", "");
        return inStr.length() == 0;
    }

    public static String convertToString(BigInteger bi) {
        try {
            return String.valueOf(bi);
        } catch (NumberFormatException e) {
            return new String("-10");
        }
    }

    public static BigInteger convertStringToBI(String str) {
        try {
            return new BigInteger(str);
        } catch (NumberFormatException e) {
            return new BigInteger("-10");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext(Pattern.compile("[0-9]*"))) {
            if (inputString == null) System.out.println();

            inputString = s.next().trim();
            inputStringLength = inputString.length();
            firstCompleteValue = convertStringToBI(inputString);
            firstInputVal = inputString;
            ExpFirstCompleteValue = convertStringToBI(inputString);
            ExpFirstInputValue = inputString;
            allSequences = new ArrayList<>();

            if (new InfiniteSequence().IsInputStringConsistOnlyZeroes(inputString)) {
                firstCompleteValue = convertStringToBI("1" + inputString);
                firstInputVal = inputString;
            } else {
                for (int minCapacity = 1; minCapacity <= inputStringLength; minCapacity++) {
                    for (int start = 0; start < minCapacity; start++) {
                        for (int numMinVals = 0; numMinVals < inputStringLength / minCapacity; numMinVals++) {
                            new Sequence().GetOneExpectSequence(minCapacity, numMinVals, start);
                        }
                    }
                }
                boolean find = false;
                for (int i = 0; i < allSequences.size(); i++) {
                    if (allSequences.get(i).size() > 2) {
                        find = new SequenceOfThreeAndMoreNumbers().Check(allSequences.get(i));
                    } else if (allSequences.get(i).size() == 2) {
                        find = new SequenceOfTwoNumbers().Check(allSequences.get(i));
                    }
                    if (find) {
                        if (firstCompleteValue.compareTo(ExpFirstCompleteValue) > 0) {
                            firstCompleteValue = ExpFirstCompleteValue;
                            firstInputVal = ExpFirstInputValue;
                            find = false;
                        }
                    }
                }
            }
            BigInteger position = SequencePosition.Find();
            System.out.println(position);
        }
    }
}

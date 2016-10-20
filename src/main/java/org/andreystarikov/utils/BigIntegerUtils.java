package org.andreystarikov.utils;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Andrey on 11.10.2016.
 */
public class BigIntegerUtils {
    public static BigInteger getResult(int next, int current, int[] subString) {
        int length = current - next;
        int[] number = new int[length];
        System.arraycopy(subString, next + 1, number, 0, length);
        BigInteger result = getResult(number);

        result = result.subtract(BigInteger.valueOf(next + 1));
        //присоединить разряды от next
        return result;
    }

    public static BigInteger getResult(int current, int[] subString) {
        return getResult(Arrays.copyOfRange(subString, 0, current + 1)); //проверить гарницы
    }

    public static BigInteger getResult(int[] subString) {
//        for(int out:subString){
//            System.out.print(out);
//        }
//        System.out.println(" - ответ");

        int signum = subString.length; //количество разрядов
        if (signum == 1) return BigInteger.valueOf(subString[0]);

        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < signum - 1; i++) {
            BigInteger subtotal = BigInteger.valueOf((i + 1) * 9); //9*(n+1);
            BigInteger ten = BigInteger.TEN;
            ten = ten.pow(i); //10^n
            subtotal = subtotal.multiply(ten); //9*(n+1)*10^n
            result = result.add(subtotal);
        }
        StringBuilder str = new StringBuilder();
        for (int k : subString) {
            str.append(k);
        }
//        System.out.println(str.toString());
        BigInteger subStrBi = new BigInteger(str.toString());
        BigInteger minNumberOfMaxSignum = BigInteger.TEN;
//        example: subString = 23435, minNumberPfMaxSignum = 10000
        minNumberOfMaxSignum = minNumberOfMaxSignum.pow(signum - 1);
        subStrBi = subStrBi.subtract(minNumberOfMaxSignum);
        BigInteger signumBI = BigInteger.valueOf(signum);
        subStrBi = subStrBi.multiply(signumBI);
        result = result.add(subStrBi);
        return result;
    }
}

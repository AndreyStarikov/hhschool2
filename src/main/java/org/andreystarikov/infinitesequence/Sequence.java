package org.andreystarikov.infinitesequence;

import org.andreystarikov.utils.ArraysUtils;
import org.andreystarikov.utils.BigIntegerUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrey on 11.10.2016.
 */
public class Sequence {

    public static BigInteger findSequence(int[] subString) {
        BigInteger position = BigInteger.ZERO;
        int length = subString.length;
        //если массив состоит из одних нулей
        if (ArraysUtils.isZeroArray(subString)) {
            position = BigIntegerUtils.getResult(ArraysUtils.generateArray(length + 1));
            position = position.add(BigInteger.ONE);
            return position;
        }

        boolean found = false;
        //цикл по шагам
        ArrayList<BigInteger> options = new ArrayList<>();
        for (int step = 1; step <= length; step++) {
            int currentstep;
            int nextstep;
            int current;
            int next;
            //цикл по позициям/разрядам
            for (int j = length - 1; j >= length - step; j--) {
                boolean positionBreak = true; //для выхода из цикла, если число плохое
                current = j;
                currentstep = step;
                //проход по числам последовательности
                while (!found && positionBreak && current - currentstep >= 0) {
                    boolean isEnd = false;
                    next = current - currentstep;
                    //проверить current на нуль в старшем разряде
                    //или если числа в младших разрядах совпадают
                    if (subString[next + 1] == 0 || subString[next] == subString[current]) {
                        positionBreak = false;
                    } else {
                        nextstep = getNextStep(current, currentstep, subString);//получаем длину следующего числа
                        //создаём массив из текущего числа
                        int[] currentArray = Arrays.copyOfRange(subString, current + 1 - currentstep, current + 1);
                        //уменьшаем текущее число на 1
                        currentArray = ArraysUtils.arrayDecrement(currentArray);
                        if (next - nextstep + 1 == 0) isEnd = true; //конец подстроки
                        if (next - nextstep + 1 < 0) { //конец подстроки недоходя до конца следующего числа
                            nextstep = next + 1;//длина следующего числа - расстояние до начала массива
                            currentstep = nextstep; //делаем текущий шаг как следующий
                            currentArray = Arrays.copyOfRange(currentArray,
                                    currentArray.length - currentstep, currentArray.length);
                            isEnd = true;
                        }
                        //создаём массив из следующего числа
                        int[] nextArray = Arrays.copyOfRange(subString, next + 1 - nextstep, next + 1);
                        //сравниваем текущее число и следующее
                        if (ArraysUtils.arrayCompare(currentArray, nextArray)) {
                            if (isEnd) {
                                //остались ли непроверенные разряды справа от j?
                                if (j == length - 1) {
                                    //нашли
                                    found = true;
                                    position = BigIntegerUtils.getResult(next, current, subString);
                                    options.add(position);
                                } else {
                                    //проверить те элементы, что стоят справа от j
                                    int[] previousArray = Arrays.copyOfRange(subString, j + 1, length);
                                    int[] curArray = Arrays.copyOfRange(subString, j + 1 - step, j + 1);
                                    curArray = ArraysUtils.arrayIncrement(curArray);
                                    curArray = Arrays.copyOfRange(curArray, 0, previousArray.length);
                                    if (ArraysUtils.arrayCompare(curArray, previousArray)) {
                                        //нашли элемент!!!!
                                        found = true;
                                        //берём текущий и позицию первое вхождение следующего
                                        position = BigIntegerUtils.getResult(next, current, subString);
                                        options.add(position);
                                    } else {
                                        positionBreak = false;
                                    }
                                }
                            } else {
                                //смотрим дальше с теми же шагами
                                current = next;
                                currentstep = nextstep;
                            }
                        } else {
                            positionBreak = false;
                        }
                    }
                }//конец while
                //если самым левым является старший разряд текущего
                if (j - step == -1) {
                    boolean findRight = true;
                    int[] currentArray = Arrays.copyOf(subString, j + 1);
                    currentArray = ArraysUtils.arrayIncrement(currentArray);
                    for (int k = 0; k < length - 1 - j; k++) {
                        if (currentArray[k] != subString[j + k + 1]) {
                            findRight = false;
                            break;
                        }
                    }
                    //если сравнение прошло успешно, то нашли элемент
                    if (findRight) {
                        position = BigIntegerUtils.getResult(j, subString);
                        options.add(position);
                    }
                }
                if (j - step < -1) {
                    int[] leftArray = Arrays.copyOf(subString, j + 1);
                    leftArray = ArraysUtils.arrayIncrement(leftArray);
                    int[] rightArray = new int[step];
                    System.arraycopy(subString, j + 1, rightArray, 0, length - 1 - j);
                    //дополнение правого массива числами из левого
                    for (int k = 1; k <= step + 1 + j - length; k++) {
                        rightArray[step - k] = leftArray[leftArray.length - k];
                    }
                    //сравнение правой части правого массива и стем что есть в левом
                    boolean findRight = true;
                    for (int k = 0; k <= j; k++) {
                        if (leftArray[leftArray.length - 1 - k] != rightArray[rightArray.length - 1 - k]) {
                            findRight = false;
                            break;
                        }
                    }
                    //если сравнение прошло успешно, то нашли элемент
                    if (findRight) {
                        position = BigIntegerUtils.getResult(rightArray);
                        position = position.subtract(BigInteger.valueOf(j + 1));
                        options.add(position);
                    }
                }

            }//тут нужно сделать проверку по всем найденым последовательностям и взять меньшее
            if (options.size() == 1) {
                position = options.get(0);
                break;
            }
            if (options.size() > 1) {
                BigInteger minimal = options.get(0);
                for (int k = 1; k < options.size(); k++) {
                    if (minimal.compareTo(options.get(k)) > 0) {
                        minimal = options.get(k);
                    }
                }
                position = minimal;
                break;
            }
        }
        return position;
    }


    /**
     * пролучаем следующий шаг
     */
    public static int getNextStep(int current, int step, int[] subString) {
        int nextStep = step;
        if (subString[current] == 0) {
            if (subString[current - step + 1] == 1) {
                boolean flag = true;
                for (int i = current - 1; i > current - step + 1; i--) {
                    if (subString[i] != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) nextStep = --step;
            }
        }
        return nextStep;
    }
}

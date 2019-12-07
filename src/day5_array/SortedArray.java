package day5_array;

import java.util.Arrays;

/**
 * 实现两个有序数组合并为一个有序数组
 */
class SortedArray {
    public static void main(String[] args) {
        int[] aArray = new int[] { 1, 6, 7, 8, 9 };
        int[] bArray = new int[] { 2, 3, 4, 5 };
        int[] resultArray = new int[aArray.length + bArray.length];

        for (int a = 0, b = 0, resultIndex = 0; resultIndex < resultArray.length;) {
            if (a < aArray.length && b < bArray.length) {
                int aValue = aArray[a];
                int bValue = bArray[b];
                if (aValue <= bValue) {
                    resultArray[resultIndex++] = aValue;
                    a++;
                } else {
                    resultArray[resultIndex++] = bValue;
                    b++;
                }
            } else if (a < aArray.length) {
                for (; a < aArray.length; a++) {
                    resultArray[resultIndex++] = aArray[a];
                }
            } else {
                for (; b < bArray.length; b++) {
                    resultArray[resultIndex++] = bArray[b];
                }
            }

        }

        System.out.println("" + Arrays.toString(resultArray));
    }
}
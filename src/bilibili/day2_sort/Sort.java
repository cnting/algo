package bilibili.day2_sort;

import java.util.Arrays;

/**
 * Created by cnting on 2021/11/21
 */
class Sort {
    public static void main(String[] args) {
        smallSum();
    }

    /**
     * 求小和
     */
    public static void smallSum() {
        int[] arr = new int[]{1, 3, 4, 2, 5};
        System.out.println(mergeSort(arr, 0, arr.length - 1));
    }

    private static int mergeSort(int[] arr, int start, int end) {
        if (start >= end) return 0;
        int mid = start + ((end - start) >> 1);
        return mergeSort(arr, start, mid) + mergeSort(arr, mid + 1, end) + merge(arr, start, mid, end);
    }

    private static int merge(int[] arr, int start, int mid, int end) {
        int i = start, j = mid + 1;
        int result = 0;
        int[] tempArr = new int[end - start + 1];
        int index = 0;
        while (i <= mid && j <= end) {
            //i位置比j位置大，说明i到mid位置上都比j大
            result += arr[i] > arr[j] ? (mid - i + 1) : 0;

            //正常的排序
            tempArr[index++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            tempArr[index++] = arr[i++];
        }
        while (j <= end) {
            tempArr[index++] = arr[j++];
        }
        for (int k = 0; k < tempArr.length; k++) {
            arr[start + k] = tempArr[k];
        }
        return result;
    }
}

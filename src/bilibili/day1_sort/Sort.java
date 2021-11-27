package bilibili.day1_sort;

import java.util.Arrays;

/**
 * Created by cnting on 2021/11/20
 */
class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 8, 4, 3, 9, 1, 5, 4, 5, 2, 5};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 选择排序
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
                if (min != i) {
                    swap(arr, min, i);
                }
            }
        }
    }

    /**
     * 插入排序
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 归并排序
     */
    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = start + ((end - start) >> 1);
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start, j = mid + 1;
        int p = 0;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[p++] = arr[i++];
            } else {
                temp[p++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[p++] = arr[i++];
        }
        while (j <= end) {
            temp[p++] = arr[j++];
        }

        for (int k = 0; k < temp.length; k++) {
            arr[start + k] = temp[k];
        }
    }

    /**
     * 快排
     */
    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int partition = partition(arr, start, end);
        quickSort(arr, start, partition - 1);
        quickSort(arr, partition + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int value = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] <= value) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }
}

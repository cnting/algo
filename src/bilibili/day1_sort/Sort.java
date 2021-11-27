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

//        for (int k = 0; k < 20; k++) {
//            int[] arr = new int[10000000];
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = (int) (Math.random() * 10000000);
//            }
//
//            long start = System.currentTimeMillis();
//            quickSort(arr, 0, arr.length - 1);
//            System.out.println("耗时:" + (System.currentTimeMillis() - start));
//        }

//        int[] arr = new int[]{3, 2, 4, 1, 4, 2};
//        System.out.println(Arrays.toString(partition(arr, 0, arr.length - 1)));
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
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    /**
     * 选择排序
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex)
                swap(arr, i, minIndex);
        }
    }

    /**
     * 插入排序
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
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
        //快排3.0，随机选一个位置和最后一个位置的值交换
        int random = start + (int) (Math.random() * (end - start + 1));
        swap(arr, random, end);
        int[] partition = partition(arr, start, end);
        quickSort(arr, start, partition[0] - 1);
        quickSort(arr, partition[1] + 1, end);
    }

    /**
     * 这个一个处理arr[start..end]的函数
     * 默认以arr[end]作为划分值，arr[end] = p，要划分出：小于p、等于p、大于p三个区域
     * 返回 等于区域 的左右边界
     */
    private static int[] partition(int[] arr, int start, int end) {
        int less = start - 1;  //小于区域的右边界
        int more = end; //大于区域的左边界，注意此时只有[start..end-1]位置进行划分,end位置没有参与

        //start位置表示当前值
        while (start < more) {
            if (arr[start] < arr[end]) {
                //当前数和 小于区的下一个交换，小于区右扩，当前位置++
                swap(arr, ++less, start++);
            } else if (arr[start] > arr[end]) {
                //当前数和 大于区的前一个交换，大于区左扩，当前位置因为是没比较的值，所以不动
                swap(arr, --more, start);
            } else {
                start++;
            }
        }
        //此时more指向的是大于区域的左边界，跟end交换，就变成了等于区域的最后一个值
        swap(arr, more, end);
        return new int[]{less + 1, more};
    }
}

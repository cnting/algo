package bilibili.day2_sort;

import java.util.Arrays;

public class HeapSort {
    static int arrLength = 10;
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[arrLength];
        arr[count++] = 1;
        arr[count++] = 5;
        arr[count++] = 2;
        arr[count++] = 3;
        arr[count++] = 7;

        buildHeap1(arr, count);
        System.out.println("堆化:" + Arrays.toString(arr));

//        sort1(arr, count - 1);
//        System.out.println("对堆进行排序:" + Arrays.toString(arr));

        insertHeapify1(arr, 8);
        System.out.println("插入数据8:" + Arrays.toString(arr));
        insertHeapify1(arr, 5);
        System.out.println("插入数据5:" + Arrays.toString(arr));
//
        removeHeapify1(arr);
        System.out.println("移除堆顶元素:" + Arrays.toString(arr));
        removeHeapify1(arr);
        System.out.println("移除堆顶元素:" + Arrays.toString(arr));
    }

    /**
     * 移除堆顶元素，并保持堆
     */
    private static void removeHeapify(int[] arr) {
        arr[0] = arr[count--];
        heapify(arr, count, 0);
    }

    /**
     * 往堆中插入一个值，将值放到数组最后，
     *
     * @param arr
     * @param data 插入数据
     */
    private static void insertHeapify(int[] arr, int data) {
        if (count >= arrLength) return;
        arr[count] = data;
        int i = count;
        count++;
        //从下往上堆化
        while ((i - 1) / 2 >= 0 && arr[(i - 1) / 2] < arr[i]) {
            swap(arr, (i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }


    /**
     * 将一个数组变成一个堆
     * 找到最后一个非叶子节点，从后往前遍历，并从上往下堆化
     */
    private static void buildHeap(int[] arr, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }


    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPosition = i;
            if (i * 2 + 1 <= n && arr[i * 2 + 1] > arr[maxPosition]) maxPosition = i * 2 + 1;
            if (i * 2 + 2 <= n && arr[i * 2 + 2] > arr[maxPosition]) maxPosition = i * 2 + 2;
            if (maxPosition == i) break;
            swap(arr, maxPosition, i);
            i = maxPosition;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 对堆排序
     */
    private static void sort(int[] arr, int n) {
        int k = n;
        while (k > 0) {
            //将第一个元素和最后一个元素交换，最后一个元素变成了堆顶元素，也就是最大值
            swap(arr, k, 0);
            //未排序范围减小
            k--;
            //将剩下区域继续堆化
            heapify(arr, k, 0);
        }
    }

    /**
     * 从最后一个非叶子节点开始，从上往下堆化
     *
     * @param arr
     * @param n
     */
    private static void buildHeap1(int[] arr, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify1(arr, n, i);
        }
    }

    private static void heapify1(int[] arr, int n, int i) {
        while (true){
            int maxPosition = i;
            if (i * 2 + 1 < n && arr[i * 2 + 1] > arr[maxPosition]) maxPosition = i * 2 + 1;
            if (i * 2 + 2 < n && arr[i * 2 + 2] > arr[maxPosition]) maxPosition = i * 2 + 2;
            if (maxPosition == i) break;
            swap(arr, i, maxPosition);
            i = maxPosition;
        }

    }

    private static void sort1(int[] arr, int n) {
        int k = n;
        while (k > 0) {
            swap(arr, k, 0);
            k--;
            heapify1(arr, k, 0);
        }
    }

    private static void insertHeapify1(int[] arr, int n) {
        if (count >= arrLength) return;
        arr[count] = n;
        int k = count;
        count++;
        while ((k - 1) / 2 >= 0 && arr[(k - 1) / 2] < arr[k]) {
            swap(arr, k, (k - 1) / 2);
            k = (k - 1) / 2;
        }
    }

    private static void removeHeapify1(int[] arr){
        if(count==0) return;
        arr[0] = arr[count-1];
        arr[count-1] = 0;
        count--;
        heapify1(arr,count,0);
    }
}

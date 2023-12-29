package geekbang.day15_binary;

import java.util.Arrays;

/**
 * Created by cnting on 2023/12/29
 */
class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        System.out.println(Arrays.toString(arr));
        System.out.println("查找第一个8：" + search1(arr, 8));
        System.out.println("查找最后一个8：" + search2(arr, 8));
        System.out.println("查找第一个>=7：" + search3(arr, 7));
        System.out.println("查找最后一个<=7：" + search4(arr, 7));
    }

    /**
     * 查找第一个等于给定值的元素
     */
    public static int search1(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != target) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个等于给定值
     */
    public static int search2(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != target) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    public static int search3(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] < target) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     */
    public static int search4(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] > target) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

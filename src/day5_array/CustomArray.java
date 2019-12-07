package day5_array;

import java.util.Arrays;

/**
 * 实现一个大小固定的数组，支持动态增删改操作
 */
class CustomArray {

    int[] data;
    int useCount = 0;

    CustomArray(final int size) {
        data = new int[size];
    }

    boolean add(final int value) {
        if (useCount == data.length) {
            System.out.println("没有多余空间");
            return false;
        }
        int i;
        for (i = 0; i < useCount; i++) {
            if (data[i] >= value) {
                break;
            }
        }
        for (int j = useCount; j >= i && j > 0; j--) {
            data[j] = data[j - 1];
        }
        data[i] = value;
        ++useCount;
        return true;
    }

    boolean delete(final int index) {
        if (!checkIndex(index)) {
            return false;
        }
        for (int i = index; i < data.length - 1; i++) {
            data[index] = data[index + 1];
        }
        data[data.length-1] = 0;
        --useCount;
        return true;
    }

    boolean update(final int index, final int value) {
        if (!checkIndex(index)) {
            return false;
        }
        data[index] = value;
        return true;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index <= data.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(final String[] args) {
        final CustomArray array = new CustomArray(5);
        array.add(0);
        array.add(3);
        array.add(1);
        array.add(4);
        array.add(2);
        System.out.println(array.toString());
        array.update(4, 40);
        System.out.println(array.toString());
        array.delete(3);
        System.out.println(array.toString());
    }
}
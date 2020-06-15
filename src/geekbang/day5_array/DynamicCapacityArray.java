package geekbang.day5_array;

import java.util.Arrays;

/**
 * 动态扩容
 */
class DynamicCapacityArray<T> {
    public static void main(String[] args) {
        DynamicCapacityArray<Integer> array = new DynamicCapacityArray<Integer>(2);
        array.add(1);
        System.out.println("array.add(1)===>" + array.toString());
        array.add(2);
        System.out.println("array.add(2)===>" + array.toString());
        array.add(3);
        System.out.println("array.add(3)===>" + array.toString());
        array.add(1, 4);
        System.out.println("array.add(1, 4)===>" + array.toString());
        array.add(9, 5);
        System.out.println("array.add(9, 5)===>" + array.toString());
        array.delete(19);
        System.out.println("array.delete(19)===>" + array.toString());
        array.delete(4);
        System.out.println("array.delete(4)===>" + array.toString());
        array.delete(2);
        System.out.println("array.delete(2)===>" + array.toString());
        array.delete(1);
        System.out.println("array.delete(1)===>" + array.toString());
    }

    T[] data;
    int size; // 当前元素的个数

    public DynamicCapacityArray(int size) {
        data = (T[]) new Object[size];
        size = 0;
    }

    public void add(T node) {
        add(size + 1, node);
    }

    /**
     * 如果容量不够，数组变为原来的两倍
     * 
     * @param index
     * @param node
     */
    public void add(int index, T node) {
        if (index < 0) {
            return;
        }
        // 容量不够了，需要扩容
        if (size == data.length) {
            addCapacity();
        }
        // 插到最后
        if (index > size) {
            data[size] = node;
        } else {
            for (int i = size - 1; i > index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = node;
        }
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        // 容量有两倍，缩小容量为原来一半
        if (size <= data.length / 2) {
            reduceCapacity();
        }
    }

    private void addCapacity() {
        T[] newData = (T[]) new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void reduceCapacity() {
        T[] newData = (T[]) new Object[data.length / 2];
        for (int i = 0; i < newData.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
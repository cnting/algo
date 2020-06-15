package geekbang.day8_stack;

import java.util.Arrays;

/**
 * 数组实现栈
 */
class ArrayStack<T> {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        System.out.println(stack.toString());
        stack.push(100);
        System.out.println(stack.toString());
        stack.push(200);
        stack.push(200);
        System.out.println(stack.toString());
    }

    int size; // 栈长度
    int useCount; // 使用容量
    T[] data;

    ArrayStack(int size) {
        this.size = size;
        useCount = 0;
        data = (T[]) (new Object[size]);
    }

    void push(T element) {
        if (useCount == size) {
            changeCapacity(size * 2);
        }
        data[useCount++] = element;
    }

    void pop() {
        data[--useCount] = null;

        if (useCount < size / 2) {
            changeCapacity(size / 2);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    private void changeCapacity(int newSize) {
        T[] newData = (T[]) (new Object[newSize]);
        int length = Math.min(size, newSize);
        for (int i = 0; i < length; i++) {
            newData[i] = data[i];
        }
        data = newData;
        size = data.length;
    }

}
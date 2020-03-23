package day9_queue;

import java.util.Queue;

/**
 * 用数组实现队列，先进先出，需要在两头进行操作，记录当前的头部和尾部
 *
 */
class ArrayQueue<T> {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.println();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.println();
        queue.enqueue(7);
        queue.println();


    }

    int size;
    int head, tail;
    T[] array;

    ArrayQueue(int size) {
        this.size = size;
        array = (T[]) (new Object[size]);
    }

    /**
     * 入队，在尾部进行操作
     */
    void enqueue(T element) {
        if (tail == size && head == 0) {
            System.out.println("队列满了");
            return;
        } else if (tail == size) { // 需要把数据往前移
            for (int i = head; i < tail; i++) {
                array[i - head] = array[i];
            }
            tail = size - head;
            head = 0;
        }
        array[tail++] = element;
    }

    /**
     * 出队，在头部进行操作
     */
    T dequeue() {
        if (head == tail) {
            System.out.println("当前是空队列");
            return null;
        }
        T t = array[head];
        array[head] = null;
        head++;
        return t;
    }

    void println() {
        StringBuffer stringBuffer = new StringBuffer();
        for (T t : array) {
            stringBuffer.append(t + "->");
        }
        System.out.println(stringBuffer.toString());
    }
}

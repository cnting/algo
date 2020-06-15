package geekbang.day9_queue;

/**
 * 用链表实现队列，先进先出，需要在两头进行操作，记录当前的头部和尾部
 */
class LinkedListQueue<T> {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
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
    Node<T> headNode, tailNode;

    /**
     * 入队，在尾部进行操作
     */
    void enqueue(T element) {
        if (headNode == null) {
            headNode = tailNode = new Node<T>(element);
        } else if(headNode==tailNode){ //头结点和尾结点指向同
            
        }else {
            tailNode.next = new Node<T>(element);
            if (headNode == tailNode) {
                headNode.next = tailNode;
            }
            tailNode = tailNode.next;
        }
        size++;
    }

    /**
     * 出队，在头部进行操作
     */
    T dequeue() {
        if (headNode == null) {
            return null;
        }
        Node<T> node = headNode;
        headNode = headNode.next;
        size--;
        return node.element;
    }

    void println() {
        StringBuffer stringBuffer = new StringBuffer();
        Node<T> node = headNode;
        while (node != null) {
            stringBuffer.append(node.element + "->");
            node = node.next;
        }
        System.out.println(stringBuffer.toString());
    }
}

class Node<T> {
    T element;
    Node<T> next;

    Node(T element) {
        this.element = element;
    }
}
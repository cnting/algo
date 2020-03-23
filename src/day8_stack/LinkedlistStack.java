package day8_stack;

/**
 * 用链表实现一个链式栈，后进先出，所以只需要在一头进行操作
 */
class LinkedlistStack<T> {
    public static void main(String[] args) {
        LinkedlistStack<Integer> stack = new LinkedlistStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.printNode(stack.headNode);
        int node = stack.pop();
        System.out.println("popNode:" + node);
        node = stack.peek();
        System.out.println("peekNode:" + node);
        stack.printNode(stack.headNode);
        System.out.println("栈长度:" + stack.size());
    }

    private Node<T> headNode;
    private int size;

    void push(T element) {
        if (headNode == null) {
            headNode = new Node<T>(element);
        } else {
            Node<T> node = new Node<>(element);
            node.next = headNode;
            headNode = node;
        }
        size++;
    }

    T pop() {
        if (headNode == null) {
            return null;
        }
        Node<T> node = headNode;
        headNode = headNode.next;
        size--;
        return node.element;
    }

    T peek() {
        if (headNode == null) {
            return null;
        }
        return headNode.element;
    }

    int size() {
        return size;
    }

    void printNode(Node<T> n) {
        while (n != null) {
            System.out.println(n.element);
            n = n.next;
        }
    }
}

class Node<T> {
    T element;
    Node<T> next;

    Node(T element) {
        this.element = element;
    }
}
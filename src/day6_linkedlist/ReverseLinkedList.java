package day6_linkedlist;

/**
 * 实现单链表反转
 */
class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        Node headNode = reverseLinkedList.generateNode(new int[] { 1, 2, 3, 4, 5 });
        System.out.println("-------反转前-------");
        reverseLinkedList.print(headNode);
        headNode = reverseLinkedList.reverse(headNode);
        System.out.println("-------反转后-------");
        reverseLinkedList.print(headNode);
    }

    Node generateNode(int[] array) {
        Node headNode = null;
        Node node = null;
        for (int i : array) {
            Node n = new Node(i);
            if (headNode == null) {
                node = headNode = n;
            } else {
                node.next = n;
                node = n;
            }
        }
        return headNode;
    }

    void print(Node n) {
        while (n != null) {
            System.out.println(n.element);
            n = n.next;
        }
    }

    Node reverse(Node headNode) {
        Node next, pre = null;
        while (headNode != null) {
            next = headNode.next;
            headNode.next = pre;
            pre = headNode;
            headNode = next;
        }
        return pre;
    }

    class Node {
        int element;
        Node next;

        Node(int element) {
            this.element = element;
        }
    }
}
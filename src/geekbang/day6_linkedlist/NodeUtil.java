package geekbang.day6_linkedlist;

class NodeUtil{

    static Node generateNode(int[] array) {
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

    static void printNode(Node n) {
        while (n != null) {
            System.out.println(n.element);
            n = n.next;
        }
    }
}

class Node {
    int element;
    Node next;

    Node(int element) {
        this.element = element;
    }
}
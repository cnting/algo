package geekbang.day6_linkedlist;

/**
 * 实现单链表反转
 */
class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        Node headNode = NodeUtil.generateNode(new int[] { 1, 2, 3, 4, 5 });
        System.out.println("-------反转前-------");
        NodeUtil.printNode(headNode);
        headNode = reverseLinkedList.reverse(headNode);
        System.out.println("-------反转后-------");
        NodeUtil.printNode(headNode);
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

    
}
package day6_linkedlist;

/**
 * 实现两个有序的链表合并为一个有序链表
 */
class SortedLinkedList {
    public static void main(String[] args) {
        Node headA = generateLinkedList(new int[] { 1, 5, 6, 7, 8, 9 });
        Node headB = generateLinkedList(new int[] { 2, 3, 4, 5 });

        SortedLinkedList sortedLinkedList = new SortedLinkedList();
        Node resultHead = sortedLinkedList.sort(headA, headB);

        Node n = resultHead;
        while (n != null) {
            System.out.println(n.element);
            n = n.next;
        }
    }

    private Node sort(Node headA, Node headB) {
        Node resultHead = null, resultCurNode = null;

        Node curNodeA = headA, curNodeB = headB;
        while (curNodeA != null || curNodeB != null) {
            if (curNodeA != null && curNodeB != null) {
                Node cur = curNodeA.element <= curNodeB.element ? curNodeA : curNodeB;
                if (resultHead == null) {
                    resultCurNode = resultHead = cur;
                } else {
                    resultCurNode.next = cur;
                    resultCurNode = resultCurNode.next;
                }
                if (cur == curNodeA) {
                    curNodeA = curNodeA.next;
                } else {
                    curNodeB = curNodeB.next;
                }
            } else if (curNodeA != null) {
                if (resultHead == null) {
                    resultCurNode = resultHead = curNodeA;
                } else {
                    resultCurNode.next = curNodeA;
                }
                break;
            } else {
                if (resultHead == null) {
                    resultCurNode = resultHead = curNodeB;
                } else {
                    resultCurNode.next = curNodeB;
                }
                break;
            }

        }
        return resultHead;
    }

    private static Node generateLinkedList(int[] array) {
        Node head = null;
        Node curNode = null;
        for (int i = 0; i < array.length; i++) {
            if (head == null) {
                curNode = head = new SortedLinkedList().new Node(array[i]);
            } else {
                Node next = new SortedLinkedList().new Node(array[i]);
                curNode.next = next;
                curNode = curNode.next;
            }
        }
        return head;
    }

    public class Node {
        int element;
        Node next;

        public Node(int element) {
            this.element = element;
        }
    }
}

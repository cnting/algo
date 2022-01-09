package bilibili.day3_linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cnting on 2022/1/9
 * 判断两个链表是否相交，并求相交节点
 */
class Intersection {

    public static void main(String[] args) {
        Map<Integer, ListNode> someNodes = createSomeListNode(20);
        //情况一
//        ListNode head1 = create(new int[]{1,2,3,4,5},someNodes,-1);
//        ListNode head2 = create(new int[]{6,7,8},someNodes,-1);

        //情况二
//        ListNode head1 = create(new int[]{1,2,3,4,5},someNodes,2);
//        ListNode head2 = create(new int[]{6,7,8},someNodes,-1);

        //情况三 (a)
//        ListNode head1 = create(new int[]{1, 2, 3, 4, 5}, someNodes, 2);
//        ListNode head2 = create(new int[]{6, 7, 8}, someNodes, 1);

        //情况三 (b)
//        ListNode head1 = create(new int[]{1, 2, 3, 4, 5, 9}, someNodes, 3);
//        ListNode head2 = create(new int[]{6, 7, 3, 4, 5, 9}, someNodes, 3);

        //情况三 (c)
        ListNode head1 = create(new int[]{1, 2, 3, 4, 5, 9}, someNodes, 2);
        ListNode head2 = create(new int[]{6, 7, 3, 4, 5, 9}, someNodes, 4);

        //获取入环节点
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);

        if (loop1 == null && loop2 == null) {
            //情况一：如果两个链表都无环
            System.out.println("两个链表都无环，相交节点:" + getIntersectNodeForNoLoop(head1, head2));
        } else if ((loop1 == null && loop2 != null) || (loop1 != null && loop2 == null)) {
            //情况二：一个有环一个无环
            System.out.println("一个有环，一个无环，没有相交节点");
        } else {
            //情况三：两个都有环

            if (loop1.equals(loop2)) {
                System.out.println("两个链表都有环，入环节点一致(b):" + getIntersectNodeForNoLoop(head1, head2));
            } else {
                ListNode node = loop1.next;
                while (node != loop1) {
                    if (node.equals(loop2)) {
                        System.out.println("两个链表都有环，入环节点一致(c)：" + loop1);
                        return;
                    }
                    node = node.next;
                }
                System.out.println("两个链表都有环，入环节点一致(a)：没有相交节点");
            }
        }
    }


    private static Map<Integer, ListNode> createSomeListNode(int length) {
        Map<Integer, ListNode> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(i, new ListNode(i));
        }
        return map;
    }

    /**
     * 对两个无环链表求相交点
     */
    private static ListNode getIntersectNodeForNoLoop(ListNode head1, ListNode head2) {
        ListNode a = head1, b = head2;
        while (a != b) {
            a = a == null ? head2 : a.next;
            b = b == null ? head1 : b.next;
        }
        return a;
    }

    /**
     * 返回入环节点
     *
     * @param head 链表头节点
     * @return 如果无环，返回null
     */
    public static ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) return null;
        fast = head;
        slow = slow.next;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 创建链表
     *
     * @param arr       链表中的值
     * @param loopIndex 入环节点位置
     * @return 头节点
     */
    private static ListNode create(int[] arr, Map<Integer, ListNode> hasCreateNodes, int loopIndex) {
        if (loopIndex >= arr.length) throw new IllegalArgumentException("loopIndex要小于size");
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode intersectNode = null;
        for (int i = 0; i < arr.length; i++) {
            cur.next = hasCreateNodes.get(arr[i]);
            cur = cur.next;
            if (i == loopIndex) {
                intersectNode = cur;
            }
        }
        cur.next = intersectNode;
        return dummy.next;
    }

    /**
     * 打印链表，链表可能有环，所以需要控制打印长度
     *
     * @param head      头节点
     * @param printSize 打印长度
     */
    static void print(ListNode head, int printSize) {
        ListNode node = head;
        while (node != null && printSize > 0) {
            System.out.print(node.val + "->");
            node = node.next;
            printSize--;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof ListNode && this.val == ((ListNode) obj).val;
        }

        @Override
        public int hashCode() {
            return val;
        }
    }
}

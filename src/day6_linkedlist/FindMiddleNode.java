package day6_linkedlist;

/**
 * 实现求链表的中间结点:如果链表中节点总数为奇数，返回中间结点，如果结点总数是偶数，返回中间两个结点的任意一个。 结题思路:
 * 设置快慢两个指针，快指针一次走两步，慢指针一次走一步，但快指针走到最后时，慢指针在中间节点
 */
class FindMiddleNode {
    public static void main(String[] args) {
        Node headNode = NodeUtil.generateNode(new int[] { 1, 2, 3, 4, 5, 6 });
        Node fastNode = headNode, slowNode = headNode;
        while (fastNode != null) {
            fastNode = fastNode.next;
            if (fastNode != null) {
                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }
        }
        System.out.println("中间节点:" + slowNode.element);
    }
}
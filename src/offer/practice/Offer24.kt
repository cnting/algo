package offer.practice

/**
 * Created by cnting on 2020/6/24
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
class Offer24 {
    fun reverseList(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var node = head
        while (node != null) {
            val next = node.next
            node.next = pre
            pre = node
            node = next
        }
        return pre
    }
}

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    val node = Offer24().reverseList(node1)
    node?.printNode()
}
package offer.practice

import java.util.*

/**
 * Created by cnting on 2020/5/25
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
class Offer6 {
    fun reversePrint(head: ListNode?): IntArray {
        val stack = Stack<Int>()
        var node = head
        while (node != null) {
            stack.push(node.`val`)
            node = node.next
        }
        val arr = IntArray(stack.size)
        var i = 0
        while (stack.isNotEmpty()){
            arr[i++] = stack.pop()
        }
        return arr
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

fun main() {
    val node1 = Offer6.ListNode(1)
    val node2 = Offer6.ListNode(3)
    val node3 = Offer6.ListNode(2)
    node1.next = node2
    node2.next = node3

    val result = Offer6().reversePrint(node1)
    print(result.contentToString())
}
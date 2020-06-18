package offer.practice

/**
 * Created by cnting on 2020/6/18
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 */
class Offer18 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
        var node = head
        var preNode: ListNode? = null
        while (node != null) {
            if (node.`val` == `val`) {
                //删除头节点
                if (preNode == null) {
                    return node.next
                } else {
                    preNode.next = node.next
                }
                break
            }
            preNode = node
            node = node.next
        }
        return head
    }

    fun generateNode(array: IntArray): ListNode? {
        if (array.isEmpty()) {
            return null
        }
        var head: ListNode? = null
        var node: ListNode? = null
        array.forEach {
            if (head == null) {
                head = ListNode(it)
                node = head
            } else {
                node?.next = ListNode(it)
                node = node?.next
            }
        }
        return head
    }

    fun printNode(head: ListNode?) {
        if (head == null) {
            println("head is null")
        } else {
            var node = head
            while (node != null) {
                print("${node.`val`} ")
                node = node.next
            }
        }
        println()
    }
}

fun main() {
    val offer18 = Offer18()
    val head = offer18.generateNode(intArrayOf())
    offer18.printNode(head)
    val newHead = Offer18().deleteNode(head, 7)
    offer18.printNode(newHead)
}
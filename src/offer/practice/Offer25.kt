package offer.practice

/**
 * Created by cnting on 2020/6/24
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
class Offer25 {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2
        var newNodeHead: ListNode? = null
        var newNode: ListNode? = null
        while (node1 != null && node2 != null) {
            val nextNode: ListNode?
            if (node1.`val` <= node2.`val`) {
                nextNode = node1
                node1 = node1.next
            } else {
                nextNode = node2
                node2 = node2.next
            }

            if (newNodeHead == null) {
                newNodeHead = nextNode
                newNode = newNodeHead
            } else {
                newNode?.next = nextNode
                newNode = newNode?.next
            }
        }
        if (node1 != null) {
            if (newNodeHead == null) {
                newNodeHead = node1
            } else {
                newNode?.next = node1
            }
        } else if (node2 != null) {
            if (newNodeHead == null) {
                newNodeHead = node2
            } else {
                newNode?.next = node2
            }
        }
        return newNodeHead
    }

    //方式2：简化版，增加一个伪头节点
    fun mergeTwoLists2(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2
        val newNodeHead = ListNode(0)
        var newNode = newNodeHead
        while (node1 != null && node2 != null) {
            if (node1.`val` <= node2.`val`) {
                newNode.next = node1
                node1 = node1.next
            } else {
                newNode.next = node2
                node2 = node2.next
            }
            newNode = newNode.next!!
        }
        if (node1 != null) {
            newNode.next = node1
        } else if (node2 != null) {
            newNode.next = node2
        }
        return newNodeHead.next
    }
}

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(4)
    node1.next = node2
    node2.next = node3


    val nodeA = ListNode(1)
    val nodeB = ListNode(3)
    val nodeC = ListNode(4)
//    nodeA.next = nodeB
//    nodeB.next = nodeC

    val node = Offer25().mergeTwoLists2(null, nodeA)
    node?.printNode()
}

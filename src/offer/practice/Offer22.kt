package offer.practice

/**
 * Created by cnting on 2020/6/24
 *
 */
class Offer22 {
    //方式1
    fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
        var size = 0
        var node = head
        while (node != null) {
            size++
            node = node.next
        }
        var i = 0
        node = head
        while (i < size - k && node != null) {
            i++
            node = node.next
        }
        return node
    }

    //方式2：快慢指针
    fun getKthFromEnd2(head: ListNode?, k: Int): ListNode? {
        var former = head
        var latter = head
        var i = 0
        while (i < k && former != null) {
            i++
            former = former.next
        }
        while (former != null) {
            former = former.next
            latter = latter?.next
        }
        return latter
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun printNode() {
        var node: ListNode? = this
        while (node != null) {
            print("${node.`val`}->")
            node = node.next
        }
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

    val node = Offer22().getKthFromEnd2(node1, 2)
    node?.printNode()
}
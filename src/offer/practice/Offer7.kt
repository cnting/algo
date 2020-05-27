package offer.practice

import java.util.*

/**
 * Created by cnting on 2020/5/26
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
class Offer7 {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) {
            return null
        }
        val size = preorder.size
        val map = mutableMapOf<Int, Int>()
        inorder.forEachIndexed { index, i -> map.put(i, index) }
        return buildTree(preorder, 0, size - 1, inorder, 0, size - 1, map)
    }

    private fun buildTree(preorder: IntArray, preStart: Int, preEnd: Int, inorder: IntArray, inStart: Int, inEnd: Int, map: Map<Int, Int>): TreeNode? {
        if (preStart > preEnd || preStart >= preorder.size) {
            return null
        }
        //根节点
        val rootValue = preorder[preStart]
        val rootNode = TreeNode(rootValue)
        if (preStart == preEnd) {
//            println("$rootNode preStart==preEnd")
            return rootNode
        }
        //找到中序遍历中的根节点，在它之前的都是左节点，在它之后的都是右节点
        val middleIndex = map[rootValue] ?: return rootNode
        //左节点个数
        val leftCount = middleIndex - inStart
        val leftNode = buildTree(preorder, preStart + 1, preStart + leftCount, inorder, inStart, middleIndex-1, map)
        val rightNode = buildTree(preorder, preStart + leftCount+1, preEnd, inorder, middleIndex + 1, inEnd, map)
        rootNode.left = leftNode
        rootNode.right = rightNode
//        println(rootNode.toString())
        return rootNode
    }
}

class TreeNode(var `val`: Int?) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "root:${`val`},left:${left?.`val`},right:${right?.`val`}"
    }
}

fun main() {
    val node = Offer7().buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))
//    val node = Offer7().buildTree(intArrayOf(3, 9, 8, 12, 4, 10, 20, 15, 7), intArrayOf(12, 8, 4, 9, 10, 3, 15, 20, 7))
    printNode(node)
}

fun printNode(node: TreeNode?) {
    if (node == null) {
        return
    }
    val queue = ArrayDeque<TreeNode>()
    queue.add(node)
    while (queue.isNotEmpty()) {
        val n = queue.poll()
        print("${n.`val`} ")
        if (n.`val` != null) {
            queue.add(n.left ?: TreeNode(null))
            queue.add(n.right ?: TreeNode(null))
        }
    }
}
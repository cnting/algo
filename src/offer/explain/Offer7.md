### 题目描述
##### 面试题07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如，给出
```kotlin
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
```

返回如下的二叉树：
```kotlin
    3
   / \
  9  20
    /  \
   15   7
```
限制：
```kotlin
0 <= 节点个数 <= 5000
```
### 题解

#### 介绍二叉树
* 先序：根左右
* 中序：左根右

具体二叉树遍历方式可以看这篇文章:[【图解数据结构】 二叉树遍历](https://www.cnblogs.com/songwenjie/p/8955856.html)

这里提一点：leetcode在判这道题的时候是按照层序遍历的

#### 方式1
[来源:leetcode](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-by-leetcode-s/)

先序遍历的每个节点都是根节点，只要找到根节点在中序遍历中的位置，在根节点之前被访问的节点都位于左子树，在根节点之后被访问的节点都位于右子树，由此可知左子树和右子树分别有多少个节点。
然后使用递归就好了
```kotlin
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
```
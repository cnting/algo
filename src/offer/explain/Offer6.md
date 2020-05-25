### 题目描述
##### 面试题06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例1：
```kotlin
输入：head = [1,3,2]
输出：[2,3,1]
```
限制：
`0 <= 链表长度 <= 10000`

### 题解
#### 方式1
使用list存遍历的内容，然后`reversed()`反转内容
```kotlin
fun reversePrint(head: ListNode?): IntArray {
        val list = mutableListOf<Int>()
        var node = head
        while (node!=null){
            list.add(node.`val`)
            node = node.next
        }
        return list.reversed().toIntArray()
    }
```
结果
```kotlin
执行用时 :200 ms, 在所有 Kotlin 提交中击败了100.00%的用户
内存消耗 :35.1 MB, 在所有 Kotlin 提交中击败了100.00%的用户
```
#### 方式2
使用栈存遍历的内容
```kotlin
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
```
结果
```kotlin
执行用时 :228 ms, 在所有 Kotlin 提交中击败了94.44%的用户
内存消耗 :35.3 MB, 在所有 Kotlin 提交中击败了100.00%的用户
```
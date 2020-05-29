### 题目描述
##### 面试题09. 用两个栈实现队列
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

提示：
* `1 <= values <= 10000`
* `最多会对 appendTail、deleteHead 进行 10000 次调用`

### 题解
#### 方式1：
stack1都用来增加，stack2都用来删除，当调用`appendTail()`时，将所有元素放到stack1中，然后在末尾插入整数。当调用`deleteHead()`时，将所有元素都放到stack2，然后`pop`顶部元素
```kotlin
//用来增加
val stack1 = Stack<Int>()
//用来删除
val stack2 = Stack<Int>()

fun appendTail(value: Int) {
    while (stack2.isNotEmpty()) {
        stack1.push(stack2.pop())
    }
    stack1.push(value)
}

fun deleteHead(): Int {
    while (stack1.isNotEmpty()) {
        stack2.push(stack1.pop())
    }
    if (stack2.isEmpty()) {
        return -1;
    }
    return stack2.pop()
}
```
结果：
```kotlin
执行用时 :1292 ms, 在所有 Kotlin 提交中击败了19.05%的用户
内存消耗 :60.4 MB, 在所有 Kotlin 提交中击败了100.00%的用户
```
#### 方式2：
来源：[leetcode官方题解](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-3/)
每次插入元素时，判断stack1是否为空，如果不为空，将stack1数据压入stack2中，然后将value压入stack1，然后将stack2中元素再压入stack1。删除时，直接stack1.pop就好
```kotlin
 //用来增加
val stack1 = Stack<Int>()
//用来删除
val stack2 = Stack<Int>()

fun appendTail(value: Int) {
    while (stack1.isNotEmpty()) {
        stack2.push(stack1.pop())
    }
    stack1.push(value)
    while (stack2.isNotEmpty()) {
        stack1.push(stack2.pop())
    }
}

fun deleteHead(): Int {
    if (stack1.isEmpty()) {
        return -1
    }
    return stack1.pop()
}
```
结果：
```kotlin
执行用时 :1456 ms, 在所有 Kotlin 提交中击败了14.29%的用户
内存消耗 :60.3 MB, 在所有 Kotlin 提交中击败了100.00%的用户
```
#### 方式3：
来源：[Krahets大佬题解](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-2/)
每次插入元素时，直接push到stack1。删除时，先判断stack2是否为空，不为空的话直接stack2.pop，否则将stack1的数据压入stack2中，再stack2.pop
```kotlin
 //用来增加
val stack1 = Stack<Int>()
//用来删除
val stack2 = Stack<Int>()

fun appendTail(value: Int) {
    stack1.push(value)
}

fun deleteHead(): Int {
    if (stack2.isNotEmpty()){
        return stack2.pop()
    }
    if(stack1.isEmpty()){
        return -1
    }
    while (stack1.isNotEmpty()){
        stack2.push(stack1.pop())
    }
    return stack2.pop()
}
```
结果：
```kotlin
执行用时 :724 ms, 在所有 Kotlin 提交中击败了95.24%的用户
内存消耗 :60.8 MB, 在所有 Kotlin 提交中击败了100.00%的用户
```
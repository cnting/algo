### 题目描述
##### 面试题11. 旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

示例 1：
```kotlin
输入：[3,4,5,1,2]
输出：1
```

示例 2：
```kotlin
输入：[2,2,2,0,1]
输出：0
```

### 题解
#### 方式1：遍历数组
遍历数组，和num[0]比较，如果`num[i]<[0]`,说明是旋转数组，num[i]就是最小值。否则num[0]就是最小值
```kotlin
fun minArray(numbers: IntArray): Int {
    val first = numbers[0]
    (1 until numbers.size).forEach {
        val value = numbers[it]
        if (first > value) {
            return value
        }
    }
    return first
}
```
结果：
```kotlin
执行用时 :216 ms, 在所有 Kotlin 提交中击败了91.67%的用户
内存消耗 :35.2 MB, 在所有 Kotlin 提交中击败了100.00%的用户
```

#### 方式2：二分法
来自[Krahets大佬的解法](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/)
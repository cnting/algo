### 题目描述
#### 21. 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

示例：
```kotlin
输入：nums = [1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。
```
### 题解
#### 方式1：快慢指针
设置两个指针`i`和`j`，`j`用来遍历数组，`i`用来记录当前奇数的最后一位位置。当遇到奇数时，`i++`；当遇到偶数时，如果`i!=j`，则进行交换
```kotlin
fun exchange(nums: IntArray): IntArray {
    var i = 0
    var j = 0
    while (j < nums.size) {
        if (nums[j] % 2 != 0) {
            if (i != j) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
            }
            i++
        }
        j++
    }
    return nums
}
```
#### 方式2：首尾双指针
来自[大佬的题解](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/solution/mian-shi-ti-21-diao-zheng-shu-zu-shun-xu-shi-qi-4/)
这种方式会比方式1更快一点
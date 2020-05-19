package leetcode

/**
 * Created by cnting on 2020/5/19
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
class Leetcode26 {
    fun removeDuplicates(nums: IntArray): Int {
        var j = 0
        nums.forEachIndexed { _, item ->
            val value = nums[j]
            if (value < item) {
                nums[++j] = item
            } else if (value > item) {
                return@forEachIndexed
            }
        }
        return j + 1
    }
}

fun main() {
    val result = Leetcode26().removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4))
    println(result)
}
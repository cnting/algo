package day11_sort

/**
 * Created by cnting on 2020/5/19
 *
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
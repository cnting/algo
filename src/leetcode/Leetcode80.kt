package leetcode

/**
 * Created by cnting on 2020/5/19
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
class Leetcode80 {
    fun removeDuplicates(nums: IntArray): Int {
        var j = 0
        var count = 1
        val size = nums.size
        (1 until size).forEach {
            val item = nums[it]
            val jValue = nums[j]
            when {
                jValue < item -> {
                    nums[++j] = item
                    count = 1
                }
                jValue == item -> {
                    count++
                    if (count < 3 && size > 1) {
                        nums[++j] = item
                    }
                }
                jValue > item -> {
                    return@forEach
                }
            }
        }
        return (j + 1).coerceAtMost(size)
    }
}

fun main() {
    val result = Leetcode80().removeDuplicates(intArrayOf(1,1,1,2,2,3))
    println(result)
}
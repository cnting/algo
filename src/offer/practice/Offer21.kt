package offer.practice

/**
 * Created by cnting on 2020/6/23
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
class Offer21 {
    //快慢指针
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
}

fun main() {
    println(Offer21().exchange(intArrayOf(2,2,2,4,5,6,7)).contentToString())
}
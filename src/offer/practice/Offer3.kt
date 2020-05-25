package offer.practice

/**
 * Created by cnting on 2020/5/20
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
class Offer3 {
    fun findRepeatNumber(nums: IntArray): Int {
        var temp: Int
        (nums.indices).forEachIndexed { index, _ ->
            while (nums[index] != index) {
                if (nums[index] == nums[nums[index]]) {
                    return nums[index]
                }
                temp = nums[index]
                nums[index] = nums[temp]
                nums[temp] = temp
            }
        }
        return -1
    }
}

fun main() {
    val result = Offer3().findRepeatNumber(intArrayOf(0, 3, 2, 5, 3, 2))
    print(result)
}
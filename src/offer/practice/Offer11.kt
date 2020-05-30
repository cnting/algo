package offer.practice

/**
 * Created by cnting on 2020/5/30
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 */
class Offer11 {
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
}

fun main() {
    print(Offer11().minArray(intArrayOf(3, 4, 5, 1, 2)))
}
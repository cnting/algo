package offer.practice

/**
 * Created by cnting on 2020/5/22
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
class Offer4 {
    /**
     * 方式2
     */
    fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }
        val rows = matrix.size
        val columns = matrix[0].size
        var row = 0
        var column = columns - 1
        while (row < rows && column >= 0) {
            val num = matrix[row][column]
            when {
                num == target -> {
                    return true
                }
                num > target -> {
                    column--
                }
                else -> {
                    row++
                }
            }
        }
        return false
    }

    /**
     * 方式1：暴力解
     */
//    fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
//        matrix.forEach {
//            if (it.isNotEmpty() && it.last() >= target) {
//                if (it.binarySearch(target, 0, it.size) >= 0) {
//                    return true
//                }
//            }
//        }
//        return false
//    }
}

fun main() {
//    val arr = arrayOf(
//            intArrayOf(1, 4, 7, 11, 15),
//            intArrayOf(2, 5, 8, 12, 19),
//            intArrayOf(3, 6, 9, 16, 22),
//            intArrayOf(10, 13, 14, 17, 24),
//            intArrayOf(18, 21, 23, 26, 30)
//    )
    val arr = arrayOf(intArrayOf())
    print(Offer4().findNumberIn2DArray(arr, 5))
}
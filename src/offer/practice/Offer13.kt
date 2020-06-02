package offer.practice

/**
 * Created by cnting on 2020/6/1
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
class Offer13 {
    fun movingCount(m: Int, n: Int, k: Int): Int {
        var num = 0
        val array = Array(m) { IntArray(n) }
        (0 until m).forEach { i ->
            (0 until n).forEach { j ->
                array[i][j] = mod(i) + mod(j)
            }
        }
        num = moving(m, n, k, 0, 0, num, array)
        return num
    }

    /**
     * 是从(0,0)开始遍历，向左和向上不用再考虑
     */
    private fun moving(m: Int, n: Int, k: Int, x: Int, y: Int, num: Int, array: Array<IntArray>): Int {
        if (x >= m || y >= n || x < 0 || y < 0 || array[x][y] > k || array[x][y] < 0) return num
        array[x][y] = -1
        var newNum = num
        ++newNum
        newNum = moving(m, n, k, x, y + 1, newNum, array)
        newNum = moving(m, n, k, x + 1, y, newNum, array)
        return newNum
    }

    /**
     * 条件里1 <= value <= 100
     */
    private fun mod(value: Int): Int {
        var result = 0
        var v = value
        while (v > 0) {
            result += v % 10
            v /= 10
        }
        return result
    }
}

fun main() {
    val offer13 = Offer13()
    println(offer13.movingCount(0, 0, 0))
//    println(offer13.movingCount(38, 15, 9))  //135
//    println(offer13.movingCount(14, 14, 5))  //21
//    println(offer13.movingCount(1, 2, 1))  //2
//    println(offer13.movingCount(3, 2, 17))  //6

//    (0 until 38).forEach { i ->
//        (0 until 15).forEach { j ->
//            if (offer13.mod(i) + offer13.mod(j) <= 9) {
//                print("$$i,$j$ ")
//            } else {
//                print("($i,$j) ")
//            }
//        }
//        println()
//    }
}
package day5_array

import kotlin.math.abs

/**
 * Created by cnting on 2020/3/30
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 */

class ArrayQuestion2 {
    fun largestPerimeter(array: IntArray): Int {
        array.sortDescending()
        var result = 0
        for (i in 0..array.size - 3) {
            val max = array[i]
            val min1 = array[i + 1]
            val min2 = array[i + 2]
            if (min1 + min2 > max && abs(min1 - min2) < max) {
                result = max + min1 + min2
                break
            }
        }
        return result
    }
}

fun main() {
    print(ArrayQuestion2().largestPerimeter(intArrayOf(1,2,1)))
}
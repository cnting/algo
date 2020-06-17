package offer.practice

import kotlin.math.abs

/**
 * Created by cnting on 2020/6/17
 *
 */
class Offer16 {
    //快速幂二进制法
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }
        if (n == 1) {
            return x
        }
        var n1 = abs(n)
        var result = 1.0
        var lastValue = x
        while (n1 != 0) {
            if ((n1 and 1) > 0) {
                result *= lastValue
            }
            lastValue *= lastValue
            n1 = n1 ushr 1
        }
        return if (n > 0) result else 1 / result
    }

    //快速幂二分法
    fun myPow1(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }
        if (n == 1) {
            return x
        }
        var n1 = abs(n)
        var res = 1.0
        var b = x
        while (n1 != 0) {
            if (n1 and 1 == 1) {
                res *= b
            }
            b *= b
            n1 = n1 ushr 1
        }
        return if (n > 0) res else 1 / res
    }
}

fun main() {
    println(Offer16().myPow1(2.10000, 3))
}
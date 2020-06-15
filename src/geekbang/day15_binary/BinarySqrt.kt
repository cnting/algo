package geekbang.day15_binary

import kotlin.math.abs
import kotlin.math.sqrt

/**
 * Created by cnting on 2020/6/15
 * 实现“求一个数的平方根”，要求精确到小数点后 6 位。
 */
class BinarySqrt {
    /**
     * 每次除以2，求上限和下限
     */
    fun sqrt(num: Int): Double {
        var x = num / 2.0
        var value = x * x
        var low = 0.0
        var high: Double = x
        while (abs(num - value) > 0.000001) {
            if (value > num) {
                high = x
            } else if (value < num) {
                low = x
            }
            x = low + (high - low) / 2
            value = x * x
        }
        return x
    }

}

fun main() {
    println(BinarySqrt().sqrt(101))
    println("正确结果：${sqrt(101.0)}")
}
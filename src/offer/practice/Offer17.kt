package offer.practice

import kotlin.math.pow

/**
 * Created by cnting on 2020/6/17
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
class Offer17 {
    fun printNumbers(n: Int): IntArray {
        val size = 10.toDouble().pow(n.toDouble()).toInt() - 1
        val array = IntArray(size)
        (1..size).forEach {
            array[it - 1] = it
        }
        return array
    }
}

fun main() {
    println(Offer17().printNumbers(1))
}
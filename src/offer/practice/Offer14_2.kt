package offer.practice

import kotlin.math.pow

/**
 * Created by cnting on 2020/6/4
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
class Offer14_2 {
    fun cuttingRope(n: Int): Int {
        if (n <= 3) {
            return n - 1
        }
        val a = n / 3
        return when (val b = n % 3) {   //可能为0、1、2
            0 -> {
                //如果为0，直接返回3^a
                3.0.pow(a.toDouble()).toInt()
            }
            1 -> {
                //如果为1，将一个3拆为2+1，比如10=3+3+3+1，应该拆为3+3+2+2
                3.0.pow((a - 1).toDouble()).toInt() * 4
            }
            else -> {
                //如果为2，不拆
                (3.0.pow(a) * b).toInt()
            }
        }
    }
}

fun main() {
    println("输入2：${Offer14_1().cuttingRope(2)}")
    println("输入10：${Offer14_1().cuttingRope(10)}")
}
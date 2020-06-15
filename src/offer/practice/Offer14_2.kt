package offer.practice

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
        var len = n
        val mod = (1e9 + 7).toInt()
        var result = 1
        while (len > 4) {
            result *= 3
            result %= mod
            len -= 3
        }
        return result * len % mod
    }
}

fun main() {
    println("输入2：${Offer14_2().cuttingRope(2)}")
    println("输入10：${Offer14_2().cuttingRope(10)}")
    println("输入120：${Offer14_2().cuttingRope(120)}")   //953271190
}
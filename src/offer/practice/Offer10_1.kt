package offer.practice

/**
 * Created by cnting on 2020/5/29
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项
 */
class Offer10_1 {
    var a = 0
    var b = 1
    var sum = 0
    fun fib(n: Int): Int {
        (0 until n).forEach { _ ->
            sum = (a + b) % 1000000007
            a = b
            b = sum
        }
        return a
    }
}

fun main() {
    val n = 100
    print(Offer10_1().fib(n))
}
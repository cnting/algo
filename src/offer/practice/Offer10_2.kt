package offer.practice

/**
 * Created by cnting on 2020/5/29
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
class Offer10_2 {
    /**
     * f(n)=1
     * f(n-1)=2
     * f(n-2)=f(n)+f(n-1)
     */
    fun numWays(n: Int): Int {
        if(n<2){
            return 1
        }
        var a = 1   //f(n)
        var b = 1   //f(n-1)
        var num = 0
        for (i in n downTo 2) {
            num = (a + b) % 1000000007
            a = b
            b = num
        }
        return num
    }
}

fun main() {
    print(Offer10_2().numWays(0))
}
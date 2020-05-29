### 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

提示：`0 <= n <= 100`

### 题解
#### 方式1
这个是[Offer10_1](https://github.com/cnting/algo/blob/master/src/offer/explain/Offer10_1.md)的变形

* 青蛙跳第n个台阶时，只能有一种跳法；
* 跳第n-1个台阶时，也只能有一种跳法；
* 跳第n-2个台阶时，可以选择跳到第n-1个台阶，也可以选择跳到第n个台阶
* 跳第n-3个台阶时，可以选择跳到第n-2个台阶，也可以选择跳到第n-1个台阶
...

可以找到规则
```kotlin
f(n)=1
f(n-1)=1
f(n-2)=f(n-1)+f(n)
```
代码如下：
```kotlin
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
```
#### 方式2
还是[Krahets大佬的题解](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/mian-shi-ti-10-ii-qing-wa-tiao-tai-jie-wen-ti-dong/)，思维逻辑稍微变下
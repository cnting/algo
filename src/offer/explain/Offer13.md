### 题目描述
##### 面试题13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

示例 1：
```kotlin
输入：m = 2, n = 3, k = 1
输出：3
```

示例 2：
```kotlin
输入：m = 3, n = 1, k = 0
输出：1
```

提示：
* `1 <= n,m <= 100`
* `0 <= k <= 20`

### 题解
#### 方式1：深度优先
从左上角开始，向右和向下遍历，并初始化一个二维数组，记录遍历到的格子
```kotlin
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
    if (value == 0) {
        return 0
    }
    var v = value
    val a = v / 100
    v %= 100
    val b = v / 10
    v %= 10
    return a + b + v
}
```
#### 方式2： 广度优先
这个还没搞明白，看[Krahets大佬题解](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/)



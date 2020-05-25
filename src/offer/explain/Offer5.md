### 题目描述
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：

```kotlin
输入：s = "We are happy."
输出："We%20are%20happy."
```
限制：

`0 <= s 的长度 <= 10000`

### 题解
#### 方式1
以空格来分割，然后用`%20`来拼接
```kotlin
fun replaceSpace(s: String): String {
    val list = s.split(" ")
    return list.joinToString("%20")
}
```
结果：
```kotlin
执行用时 : 204 ms, 在所有 Kotlin 提交中击败了40.32%的用户
内存消耗 : 34.4 MB, 在所有 Kotlin 提交中击败了100.00%的用户
```

#### 方式2
使用StringBuilder来保存替换后的内容
```kotlin
fun replaceSpace(s: String): String {
        val sb = StringBuilder()
        s.toCharArray().forEach {
            if (it == ' ')
                sb.append("%20")
            else sb.append(it)
        }
        return sb.toString()
    }
```
结果：
```kotlin
执行用时 :144 ms, 在所有 Kotlin 提交中击败了95.16%的用户
内存消耗 :32.2 MB, 在所有 Kotlin 提交中击败了100.00%的用户
```

#### 方式3
直接使用`String`的`replace()`方法，但这样就不算是自己实现了吧，而且用时比较长
结果:
```kotlin
执行用时 :260 ms, 在所有 Kotlin 提交中击败了16.13%的用户
内存消耗 :35.3 MB, 在所有 Kotlin 提交中击败了100.00%的用户
```
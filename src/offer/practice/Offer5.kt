package offer.practice


/**
 * Created by cnting on 2020/5/25
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
class Offer5 {
    fun replaceSpace(s: String): String {
        val sb = StringBuilder()
        for (c in s) {
            if (c == ' ')
                sb.append("%20")
            else sb.append(c)
        }
        return sb.toString()
    }
}

fun main() {
    val result = Offer5().replaceSpace("We are  happy.")
    print(result)
}
package offer.practice

/**
 * Created by cnting on 2020/6/22
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 */
class Offer20 {
    fun isNumber(s: String): Boolean {
        val map = arrayOf(
                mapOf(Pair(' ', 0), Pair('s', 1), Pair('d', 2), Pair('.', 4)),
                mapOf(Pair('d', 2), Pair('.', 4)),
                mapOf(Pair('d', 2), Pair('.', 3), Pair('e', 5), Pair(' ', 8)),
                mapOf(Pair('d', 3), Pair('e', 5), Pair(' ', 8)),
                mapOf(Pair('d', 3)),
                mapOf(Pair('s', 6), Pair('d', 7)),
                mapOf(Pair('d', 7)),
                mapOf(Pair('d', 7), Pair(' ', 8)),
                mapOf(Pair(' ', 8))
        )
        var p = 0
        val cChar = s.toCharArray()
        for (c in cChar) {
            val type =
                    if (c in '0'..'9') 'd'
                    else if (c == '+' || c == '-') 's'
                    else c
            p = map[p][type] ?: return false
        }
        return p == 2 || p == 3 || p == 7 || p == 8
    }
}

fun main() {
    val offer = Offer20()
    var value = "3.1416"
    println("$value 是否是数值${offer.isNumber(value)}，正确答案:true")
    value = "+100"
    println("$value 是否是数值${offer.isNumber(value)}，正确答案:true")
    value = "5e2"
    println("$value 是否是数值${offer.isNumber(value)}，正确答案:true")
    value = "-123"
    println("$value 是否是数值${offer.isNumber(value)}，正确答案:true")
    value = "0123"
    println("$value 是否是数值${offer.isNumber(value)}，正确答案:true")
    value = "12e"
    println("$value 是否是数值${offer.isNumber(value)}，正确答案:false")
    value = "1a3.14"
    println("$value 是否是数值${offer.isNumber(value)}，正确答案:false")
    value = "1.2.3"
    println("$value 是否是数值${offer.isNumber(value)}，正确答案:false")
    value = "+-5"
    println("$value 是否是数值${offer.isNumber(value)}，正确答案:false")
    value = "-1E-16"
    println("$value 是否是数值${offer.isNumber(value)}，正确答案:false")
    value = "12e+5.4"
    println("$value 是否是数值${offer.isNumber(value)}，正确答案:false")
}
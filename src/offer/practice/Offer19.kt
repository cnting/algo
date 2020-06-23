package offer.practice

/**
 * Created by cnting on 2020/6/19
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
class Offer19 {
    fun isMatch(s: String, p: String): Boolean {
        if (s.isEmpty() && p.isEmpty()) {
            return true
        }
        if (p.isEmpty()) {
            return false
        }
        val sArr = s.toCharArray()
        val pArr = p.toCharArray()
        var sIndex = sArr.size - 1
        var pIndex = pArr.size - 1

        var lastPChar: Char? = null

        while (sIndex >= 0 && pIndex >= 0) {
            val sChar = sArr[sIndex]
            val pChar = pArr[pIndex]
            if (lastPChar != '*' && (pChar == '.' || sChar == pChar)) {
                sIndex--
                pIndex--
                lastPChar = pChar
            } else {
                if (pChar == '*') {
                    pIndex--
                    lastPChar = pChar
                } else if (sChar != pChar && pChar != '.') {  //匹配0次
                    sIndex--
                    pIndex--
                    lastPChar = pChar
                } else {
                    sIndex--
                }
            }
        }

        return sIndex < 0 && pIndex < 0
    }
}

fun main() {
    val offer19 = Offer19()
    var s = "aa"
    var p = "a"
    println("s:$s,p:$p ===>${offer19.isMatch(s, p)}，正确答案：false")
    s = "aa"
    p = "a*"
    println("s:$s,p:$p ===>${offer19.isMatch(s, p)}，正确答案：true")
    s = "ab"
    p = ".*"
    println("s:$s,p:$p ===>${offer19.isMatch(s, p)}，正确答案：true")
    s = "aab"
    p = "c*a*b"
    println("s:$s,p:$p ===>${offer19.isMatch(s, p)}，正确答案：true")
    s = "mississippi"
    p = "mis*is*ip*."
    println("s:$s,p:$p ===>${offer19.isMatch(s, p)}，正确答案：true")
    s = ""
    p = "s*s*p*."
    println("s:$s,p:$p ===>${offer19.isMatch(s, p)}，正确答案：false")
    s = "aaaa"
    p = ""
    println("s:$s,p:$p ===>${offer19.isMatch(s, p)}，正确答案：false")
    s = "ab"
    p = ".*c"
    println("s:$s,p:$p ===>${offer19.isMatch(s, p)}，正确答案：false")
    s = "aaa"
    p = "a*a"
    println("s:$s,p:$p ===>${offer19.isMatch(s, p)}，正确答案：true")
    s = "ab"
    p = ".*c"
    println("s:$s,p:$p ===>${offer19.isMatch(s, p)}，正确答案：false")
    s = "a"
    p = ".*..a*"
    println("s:$s,p:$p ===>${offer19.isMatch(s, p)}，正确答案：false")
}
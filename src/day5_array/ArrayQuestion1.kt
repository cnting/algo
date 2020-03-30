package day5_array

import kotlin.math.pow

/**
 * Created by cnting on 2020/3/26
 * 给出数组['aaa','bbb','ccc','aaa','bbb']
 * 要求输出['1aaa','1bbb','ccc','2aaa','2bbb]
 */

class ArrayQuestion1 {

    val SHIFT = 16
    val MASK = (2.0.pow(16.0) - 1).toInt() shl SHIFT    //前16位存上一个的位置，后16位存总共次数  (2^16-1)<<16

    fun change(array: Array<String>) {
        println("转换前:${array.contentToString()}")
        val map = mutableMapOf<String, Int>()
        array.forEachIndexed { index, key ->
            val realIndex = index + 1
            val lastTimes: Int
            if (map.containsKey(key)) {
                val value: Int = map[key]!!
                val lastIndex = value shr SHIFT      //右移16位
                lastTimes = value and MASK.inv()  //value & ~MASK
                if (lastTimes == 1) {
                    array[lastIndex - 1] = "$lastTimes${array[lastIndex - 1]}"
                }
                array[index] = "${lastTimes + 1}${array[index]}"
            } else {
                lastTimes = 0
            }
            map[key] = (realIndex shl SHIFT) or ((lastTimes + 1) and MASK.inv())
        }
        println("转换后:${array.contentToString()}")
    }

    //简化版
    fun change2(array: Array<String>) {
        println("转换前:${array.contentToString()}")
        val map = mutableMapOf<String, Int>()
        array.forEachIndexed { index, key ->
            val newValue: Int
            if (map.containsKey(key)) {
                val value: Int = map[key]!!
                val lastTimes = if (value <= 0) 1 else value
                if (value <= 0) {  //小于0说明上次是第一次，记录的是上次的位置
                    array[-value] = "$lastTimes${array[-value]}"
                }
                array[index] = "${lastTimes + 1}${array[index]}"
                newValue = lastTimes + 1
            } else {
                newValue = -index
            }
            map[key] = newValue
        }
        println("转换后:${array.contentToString()}")
    }
}

fun main() {
    ArrayQuestion1().change2(arrayOf("aaa", "bbb", "ccc", "aaa", "bbb", "aaa", "bbb", "aaa", "bbb", "aaa", "bbb", "aaa", "bbb"))
}
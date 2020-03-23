package day11_sort

/**
 * Created by cnting on 2020/3/23
 * 插入排序
 */
class InsertSort {
    fun sort(array: IntArray) {
        for (i in 1 until array.size) {
            val temp = array[i]
            var j = i - 1
            while (j >= 0) {
                if (array[j] > temp) {
                    array[j + 1] = array[j]
                } else {
                    break
                }
                j--
            }
            array[j + 1] = temp
        }
//        print(array.contentToString())
    }
}

fun main() {
    InsertSort().sort(intArrayOf(4, 5, 6, 1, 3, 2))
}
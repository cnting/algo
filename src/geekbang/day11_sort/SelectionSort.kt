package geekbang.day11_sort

/**
 * Created by cnting on 2020/3/23
 * 选择排序
 */
class SelectionSort {
    fun sort(array: IntArray) {
        for (i in 0 until array.size - 1) {
            var min = array[i + 1]
            var minIndex = i + 1
            for (j in i + 2 until array.size) {
                //找最小的值
                if (min > array[j]) {
                    min = array[j]
                    minIndex = j
                }
            }
            if (array[i] > array[minIndex]) {
                val temp = array[i]
                array[i] = array[minIndex]
                array[minIndex] = temp
            }
        }
//        print(array.contentToString())
    }
}

fun main() {
    SelectionSort().sort(intArrayOf(4, 5, 6, 3, 2, 1))
}
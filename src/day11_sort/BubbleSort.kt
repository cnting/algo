package day11_sort

/**
 * Created by cnting on 2020/3/23
 * 冒泡排序
 */
class BubbleSort {
    fun sort(array: IntArray) {
        for (i in array.size - 1 downTo 0) {
            var hasSwap = false
            for (j in 0 until i) {
                if (array[j] > array[j + 1]) {
                    val temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                    hasSwap = true
                }
            }
            if (!hasSwap) {
                break
            }
        }
//        print(array.contentToString())
    }
}

fun main() {
    val arrayList = mutableListOf<IntArray>()
    for (i in 0..10000) {
        val arr = IntArray(200)
        for (j in 0 until 200) {
            arr[j] = (Math.random() * 1000).toInt()
        }
        arrayList.add(arr)
    }

    val bubbleSort = BubbleSort()
    var start = System.currentTimeMillis()
    arrayList.forEach { bubbleSort.sort(it) }
    println("冒泡耗时:${System.currentTimeMillis() - start}")

    val insertSort = InsertSort()
    start = System.currentTimeMillis()
    arrayList.forEach { insertSort.sort(it) }
    println("插入耗时:${System.currentTimeMillis() - start}")

    val selectionSort = SelectionSort()
    start = System.currentTimeMillis()
    arrayList.forEach { selectionSort.sort(it) }
    print("选择耗时:${System.currentTimeMillis() - start}")
//    BubbleSort().sort(intArrayOf(4, 5, 6, 3, 2, 1))
}

package offer.practice

/**
 * Created by cnting on 2020/5/30
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 */
class Offer12 {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val charArray = word.toCharArray()
        board.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                if (find(board, charArray, i, j, 0)) return true
            }
        }
        return false
    }


    private fun find(board: Array<CharArray>, charArray: CharArray, i: Int, j: Int, k: Int): Boolean {
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || board[i][j] != charArray[k]) return false
        if (k == charArray.size - 1) return true
        val temp = board[i][j]
        board[i][j] = ' '
        val result = (find(board, charArray, i - 1, j, k + 1)
                || find(board, charArray, i + 1, j, k + 1)
                || find(board, charArray, i, j - 1, k + 1)
                || find(board, charArray, i, j + 1, k + 1))
        board[i][j] = temp
        return result
    }
}

fun main() {
    val board = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
    )
    val word = "ABCCED"
//    val board = arrayOf(
//            charArrayOf('C', 'A', 'A'),
//            charArrayOf('A', 'A', 'A'),
//            charArrayOf('B', 'C', 'D')
//    )
//    val word = "AAB"
    val result = Offer12().exist(board, word)
    print(result)
}
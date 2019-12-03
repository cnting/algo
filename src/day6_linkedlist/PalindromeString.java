package day6_linkedlist;

/**
 * 回文字符串，正读和反读一样的字符串 问题：字符串使用单链表存储，如何判断一个字符串是否是回文字符串
 */
class PalindromeString {
    public static void main(String[] args) {
        Letter firstLetter = generateList("level");
        System.out.println("level:" + isPalindrome(firstLetter));
        firstLetter = generateList("abccba");
        System.out.println("abccba:" + isPalindrome(firstLetter));
        firstLetter = generateList("aab");
        System.out.println("aab:" + isPalindrome(firstLetter));
    }

    /**
     * 生成链表
     * 
     * @param content
     * @return
     */
    private static Letter generateList(String content) {
        char[] chars = content.toCharArray();
        Letter node = null;
        Letter firstNode = null;
        for (char c : chars) {
            if (node == null) {
                node = new Letter(c);
                firstNode = node;
            } else {
                Letter nextNode = new Letter(c);
                node.nextNode = nextNode;
                node = nextNode;
            }
        }
        return firstNode;
    }

    private static boolean isPalindrome(Letter firstLetter) {
        // 举例：leaeeael
        int sum = 0;
        Letter letter = firstLetter;
        while (letter != null) {
            sum++;
            letter = letter.nextNode;
        }
        // 取得中间位置
        int middle = (sum / 2);
        int count = 0;
        letter = firstLetter;
        // 找到中间node
        while (count < middle) {
            count++;
            letter = letter.nextNode;
        }
        char[] array = new char[sum - middle];
        count = 0;
        // 存到数组中
        while (letter != null) {
            array[count++] = letter.letter;
            letter = letter.nextNode;
        }
        // 倒置链表 
        Letter reverseFirstLetter = null;
        Letter reverseLetter = null;
        count = array.length - 1;
        while (count >= 0) {
            if (reverseFirstLetter == null) {
                reverseFirstLetter = new Letter(array[count]);
                reverseLetter = reverseFirstLetter;
            } else {
                Letter nextNode = new Letter(array[count]);
                reverseLetter.nextNode = nextNode;
                reverseLetter = nextNode;
            }
            --count;
        }
        letter = firstLetter;
        reverseLetter = reverseFirstLetter;
        count = 0;
        while (count < middle) {
            if (letter.letter != reverseLetter.letter) {
                return false;
            } else {
                count++;
                letter = letter.nextNode;
                reverseLetter = reverseLetter.nextNode;
            }
        }
        return true;
    }

}

class Letter {
    char letter;
    Letter nextNode;

    public Letter(char letter) {
        this.letter = letter;
    }
}
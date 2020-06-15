package geekbang.day6_linkedlist;

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

    /**
     * 先找到单链表的中间位置，然后将后半段链表反转。然后设置两个指针，从【开始位置】和【反转过的后半段的开始位置】开始遍历，看内容是否相同
     * 
     * @param firstLetter
     * @return
     */
    private static boolean isPalindrome(Letter firstLetter) {
        // 找到中间节点
        Letter fastNode = firstLetter, slowNode = firstLetter;
        while (fastNode != null) {
            fastNode = fastNode.nextNode;
            if (fastNode != null) {
                fastNode = fastNode.nextNode;
                slowNode = slowNode.nextNode;
            }
        }
        // 倒置链表
        Letter pre = null, next;
        while (slowNode != null) {
            next = slowNode.nextNode;
            slowNode.nextNode = pre;
            pre = slowNode;
            slowNode = next;
        }
        // 从【开始位置】和【反转过的后半段的开始位置】开始遍历，看内容是否相同
        while (pre != null) {
            if (firstLetter.letter != pre.letter) {
                return false;
            }
            firstLetter = firstLetter.nextNode;
            pre = pre.nextNode;
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
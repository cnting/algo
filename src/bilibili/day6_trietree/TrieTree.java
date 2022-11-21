package bilibili.day6_trietree;

/**
 * Created by cnting on 2022/6/9
 * 前缀树
 */
class TrieTree {

    public static void main(String[] args) {
        TrieTree tree = new TrieTree();
        tree.addWord("abc");
        tree.addWord("abe");
        tree.addWord("bc");
        System.out.println("是否添加 abc：" + tree.search("abc"));
        System.out.println("是否添加 abe：" + tree.search("abe"));
        System.out.println("是否添加 aa：" + tree.search("aa"));
        System.out.println("以ab为前缀出现次数:" + tree.searchPre("ab"));
        tree.delete("abc");
        System.out.println("是否添加 abc：" + tree.search("abc"));
        System.out.println("是否添加 abe：" + tree.search("abe"));
    }

    TrieNode root;

    TrieTree() {
        root = new TrieNode();
    }

    /**
     * 添加一个单词
     */
    public void addWord(String word) {
        TrieNode cur = root;
        char[] arr = word.toCharArray();
        root.pass++;
        for (char c : arr) {
            int index = c - 'a';
            //如果未经过下一个字符，创建
            if (cur.nexts[index] == null) {
                cur.nexts[index] = new TrieNode();
            }
            //移到下一个字符
            cur = cur.nexts[index];
            cur.pass++;
        }
        //最后一个字符
        cur.end++;
    }

    /**
     * 判断一个单词被加入几次
     */
    public int search(String word) {
        TrieNode cur = root;
        char[] arr = word.toCharArray();
        for (char c : arr) {
            int index = c - 'a';
            //没被加入
            if (cur.nexts[index] == null) {
                return 0;
            }
            //移到下一个字符
            cur = cur.nexts[index];
        }
        return cur.end;
    }

    /**
     * 判断以word为前缀加入几次
     */
    public int searchPre(String word) {
        TrieNode cur = root;
        char[] arr = word.toCharArray();
        for (char c : arr) {
            int index = c - 'a';
            //没被加入
            if (cur.nexts[index] == null) {
                return 0;
            }
            //移到下一个字符
            cur = cur.nexts[index];
        }
        return cur.pass;
    }

    /**
     * 删除单词，沿途的pass--，最后一个字符的end--
     */
    public void delete(String word) {
        //未加入
        if (search(word) == 0) {
            return;
        }
        TrieNode cur = root;
        char[] arr = word.toCharArray();
        for (char c : arr) {
            int index = c - 'a';
            //说明这个节点要被删除
            if (--cur.nexts[index].pass == 0) {
                cur.nexts[index] = null;
                return;
            }
            //移到下一个字符
            cur = cur.nexts[index];
        }
        cur.end--;
    }
}

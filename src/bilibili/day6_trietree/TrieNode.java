package bilibili.day6_trietree;

/**
 * Created by cnting on 2022/6/9
 * 前缀树节点
 */
class TrieNode {
    //经过这个节点几次
    int pass;
    //以这个节点结尾几次
    int end;
    //查询下级节点
    TrieNode[] nexts;

    TrieNode() {
        pass = 0;
        end = 0;
        //26个字母
        nexts = new TrieNode[26];
    }
}

package geekbang.day6_linkedlist;

/**
 * 单链表实现LRU（最近最少使用缓存策略）
 */
class LRULinkedList {
    public static void main(String[] args) {
        LRU<Integer> lru = new LRU<>();
        int searchContent = 1;
        lru.searchNode(searchContent);
        System.out.println("查找内容："+searchContent+" ===>"+lru.toString());
        searchContent = 2;
        lru.searchNode(searchContent);
        System.out.println("查找内容："+searchContent+" ===>"+lru.toString());
        searchContent = 3;
        lru.searchNode(searchContent);
        System.out.println("查找内容："+searchContent+" ===>"+lru.toString());
        searchContent = 1;
        lru.searchNode(searchContent);
        System.out.println("查找内容："+searchContent+" ===>"+lru.toString());
        searchContent = 3;
        lru.searchNode(searchContent);
        System.out.println("查找内容："+searchContent+" ===>"+lru.toString());
    }

}

class LRU<T> {

    Node<T> headNode = null;

    Node<T> searchNode(T searchContent) {
        Node<T> resultNode = null, curNode = headNode;
        while (curNode != null) {
            // 找到，把当前节点插入到head
            if (curNode.element == searchContent) {
                resultNode = curNode;
                Node<T> preNode = getPreNode(curNode);
                if(preNode!=null){
                    preNode.next = curNode.next;
                }
                // 移到head
                curNode.next = headNode;
                headNode = curNode;
                break;
            } else {
                curNode = curNode.next;
            }
        }
        if (headNode == null) {
            resultNode = new Node<T>(searchContent);
            headNode = resultNode;
        } else if (resultNode == null) { // 没找到，插入head
            resultNode = new Node<T>(searchContent);
            resultNode.next = headNode;
            headNode = resultNode;
        }
        return resultNode;
    }

    private Node<T> getPreNode(Node<T> node) {
        Node<T> curNode = headNode;
        while (curNode.next != null) {
            if (curNode.next.element == node.element) {
                return curNode;
            }else{
                curNode = curNode.next;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> curNode = headNode;
        while (curNode != null) {
            sb.append(curNode.element + ",");
            curNode = curNode.next;
        }
        return sb.toString();
    }

    class Node<T> {
        T element;
        Node<T> next;
    
        Node(T element) {
            this.element = element;
        }
    }
}


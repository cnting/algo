package bilibili.day5_graph;

import bilibili.day5_graph.model.Graph;
import bilibili.day5_graph.model.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * ~~~~~ 1
 * ~~~~~/|\
 * ~~~~/ | \
 * ~~~2  3  4
 * ~~~~\ | /
 * ~~~~~\|/
 * ~~~~~ 5
 */
public class GraphTraverse {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 0},
                {1, 3, 0},
                {1, 4, 0},
                {2, 5, 0},
                {3, 5, 0},
                {4, 5, 0}
        };
        Graph graph = CreateGraph.createGraph(arr);
        graph.printGraph();
//        bfs(graph.nodes.get(1)); //获取1这个节点
        dfs(graph.nodes.get(1)); //获取1这个节点
    }

    //图的广度优先遍历，遍历后结果为 1[2\3\4]5，2\3\4三个位置可互换
    public static void bfs(Node node) {
        if (node == null) return;
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.println(n.value);
            for (Node next : n.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }

    /**
     * 深度优先遍历
     */
    public static void dfs(Node node) {
        if (node == null) return;
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    System.out.println(next.value);
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    break;
                }
            }
        }
    }
}

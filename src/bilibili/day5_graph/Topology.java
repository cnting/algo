package bilibili.day5_graph;

import bilibili.day5_graph.model.Graph;
import bilibili.day5_graph.model.Node;

import java.util.*;

/**
 * 拓扑排序
 */
public class Topology {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 0},
                {2, 3, 0},
                {3, 4, 0},
                {4, 5, 0},
                {1, 3, 0},
                {3, 5, 0}
        };
        Graph graph = CreateGraph.createGraph(arr);
        List<Node> result = topology(graph);
        for(Node node : result){
            System.out.println(node.value);
        }
    }

    public static List<Node> topology(Graph graph) {
        List<Node> result = new ArrayList<>();
        //记录每个节点的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        LinkedList<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            //入度都减一
            for (Node next : cur.nexts) {
                int newIn = inMap.get(next) - 1;
                inMap.put(next, newIn);
                if (newIn == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}

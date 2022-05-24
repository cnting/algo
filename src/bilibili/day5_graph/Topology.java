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
        for (Node node : result) {
            System.out.println(node.value);
        }
    }

    public static List<Node> topology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        LinkedList<Node> zeroInMap = new LinkedList<>();
        List<Node> result = new ArrayList<>();

        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInMap.add(node);
            }
        }
        while (!zeroInMap.isEmpty()) {
            Node cur = zeroInMap.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInMap.add(next);
                }
            }
        }
        return result;
    }
}

package bilibili.day5_graph;

import bilibili.day5_graph.model.Edge;
import bilibili.day5_graph.model.Graph;
import bilibili.day5_graph.model.Node;

/**
 * 将源数据转成图结构
 */
public class CreateGraph {
    public static void main(String[] args) {
        //[from节点的值，to节点的值,weight]
        int[][] array = new int[][]{
                {5, 1, 2},
                {8, 2, 3},
                {7, 1, 3}
        };
        Graph graph = createGraph(array);
        graph.printGraph();
    }

    public static Graph createGraph(int[][] array) {
        Graph graph = new Graph();
        for (int[] a : array) {
            int from = a[0];
            int to = a[1];
            int weight = a[2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(fromNode, toNode, weight);
            graph.edges.add(edge);
            fromNode.edges.add(edge);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
        }
        return graph;
    }
}

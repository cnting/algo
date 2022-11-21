package bilibili.day5_graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import bilibili.day5_graph.model.Edge;
import bilibili.day5_graph.model.Graph;
import bilibili.day5_graph.model.Node;

/**
 * Created by cnting on 2022/5/31
 * 从一个节点开始，计算从出发点到每个点的距离
 */
class Dijkstra {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 1, 9},
                {0, 3, 8},
                {0, 4, 5},
                {1, 2, 2},
                {4, 5, 6},
                {3, 5, 2},
                {2, 5, 1}
        };
        Graph graph = CreateGraph.createGraph(arr);
        Map<Node, Integer> result = dijkstra(graph.nodes.get(0));
        for (Map.Entry<Node, Integer> entry : result.entrySet()) {
            System.out.println("0到" + entry.getKey().value + "的距离:" + entry.getValue());
        }
    }

    public static Map<Node, Integer> dijkstra(Node node) {
        //记录距离，如果不在map中，表示从head到当前节点的距离为正无穷
        Map<Node, Integer> distanceMap = new HashMap<>();
        //锁住的节点
        HashSet<Node> lockNodes = new HashSet<>();
        //开始节点距离为0
        distanceMap.put(node, 0);
        Node minNode = getMinDistanceAndUnlockedNode(distanceMap, lockNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            //更新相连节点的距离
            for (Edge edge : minNode.edges) {
                Node to = edge.to;
                //如果不在map中，表示正无穷
                if (!distanceMap.containsKey(to)) {
                    distanceMap.put(to, distance + edge.weight);
                } else {
                    //在map中，取最小距离
                    distanceMap.put(to, Math.min(distanceMap.get(to), distance + edge.weight));
                }
            }
            lockNodes.add(minNode);
            minNode = getMinDistanceAndUnlockedNode(distanceMap, lockNodes);
        }

        return distanceMap;
    }

    private static Node getMinDistanceAndUnlockedNode(Map<Node, Integer> distanceMap, HashSet<Node> lockNodes) {
        Node result = null;
        int distance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            if (!lockNodes.contains(node) && distance > entry.getValue()) {
                result = node;
                distance = entry.getValue();
            }
        }
        return result;
    }
}

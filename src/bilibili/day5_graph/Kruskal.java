package bilibili.day5_graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import bilibili.day5_graph.model.Edge;
import bilibili.day5_graph.model.Graph;
import bilibili.day5_graph.model.Node;

/**
 * Created by cnting on 2022/5/24
 * 根据无向图，生成最小生成树
 */
class Kruskal {

    private Comparator<Edge> comparator = Comparator.comparingInt(o -> o.weight);

    public HashSet<Edge> kruskalMST(Graph graph) {
        UnionSet unionSet = new UnionSet(graph.nodes.values());
        PriorityQueue<Edge> queue = new PriorityQueue<>(comparator);
        //边的权重从小到大排
        queue.addAll(graph.edges);
        HashSet<Edge> result = new HashSet<>();
        while (!queue.isEmpty()){
            //当前最小的边
            Edge edge = queue.poll();
            if(!unionSet.isSameSet(edge.from,edge.to)){
                unionSet.union(edge.from,edge.to);
                result.add(edge);
            }
        }
        return result;
    }
}

/**
 * 仿并查集，判断两个节点是否在同一个集合中
 */
class UnionSet {
    private Map<Node, List<Node>> map = new HashMap<>();

    public UnionSet(Collection<Node> nodes) {
        for (Node node : nodes) {
            //刚开始每个节点对应一个List
            List<Node> list = new ArrayList<>();
            list.add(node);
            map.put(node, list);
        }
    }

    /**
     * 判断两个节点是否在同一个集合中
     */
    public boolean isSameSet(Node from, Node to) {
        List<Node> fromSet = map.get(from);
        List<Node> toSet = map.get(to);
        return fromSet == toSet;
    }

    /**
     * 合并两个节点到同一个集合中
     */
    public void union(Node from, Node to) {
        List<Node> fromSet = map.get(from);
        List<Node> toSet = map.get(to);
        for (Node node : toSet) {
            fromSet.add(node);
            toSet.remove(node);
            map.put(node, fromSet);
        }
    }
}

package bilibili.day5_graph;

import bilibili.day5_graph.model.Edge;
import bilibili.day5_graph.model.Graph;
import bilibili.day5_graph.model.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Prim {
    public HashSet<Edge> primMST(Graph graph) {
        //记录遍历过的节点
        HashSet<Node> set = new HashSet<>();
        HashSet<Edge> result = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        for (Node cur : graph.nodes.values()) {
            //遍历所有节点
            if(!set.contains(cur)){
                //解锁节点相连的边
                queue.addAll(cur.edges);
                set.add(cur);

                while (!queue.isEmpty()){
                    //找最小边
                    Edge edge = queue.poll();
                    Node to = edge.to;
                    if(!set.contains(to)){
                        //解锁to节点所有的边
                        queue.addAll(to.edges);
                        set.add(to);
                        result.add(edge);
                    }
                }
            }
        }
        return result;
    }
}

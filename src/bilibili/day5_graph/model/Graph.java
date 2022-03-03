package bilibili.day5_graph.model;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

    public void printGraph(){
        for (Edge edge : edges) {
            System.out.println("边:" + edge);
        }
    }
}

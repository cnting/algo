package bilibili.day5_graph.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int value;
    //入度
    public int in;
    //出度
    public int out;
    //从当前节点出去的节点
    public List<Node> nexts;
    //从当前节点出去的边
    public List<Edge> edges;

    public Node(int value){
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", in=" + in +
                ", out=" + out +
//                ", nexts=" + nexts +
//                ", edges=" + edges +
                '}';
    }
}

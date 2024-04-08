import java.util.ArrayList;
import java.util.List;

// Define the floor plan graph
public class Graph {
    List<Node> nodes; // List of nodes in the graph

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void connectNodes(Node node1, Node node2) {
        node1.addConnection(node2);
        node2.addConnection(node1);
    }
}

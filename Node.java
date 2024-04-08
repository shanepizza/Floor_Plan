import java.util.ArrayList;
import java.util.List;

// Define a node in the floor plan graph
public class Node {
    NodeType type; // The type of the node (e.g., door, hallway, staircase)
    Position position; // The position of the node on the floor plan
    List<Node> connections; // List of adjacent nodes (connected via edges)

    public Node(NodeType type, Position position) {
        this.type = type;
        this.position = position;
        this.connections = new ArrayList<>();
    }

    Node(NodeType type){
        this.type = type;
    }

    public void addConnection(Node node) {
        connections.add(node);
    }
}

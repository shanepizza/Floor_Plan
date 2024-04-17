import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Define the floor plan graph
public class Graph implements Serializable {
    List<Node> nodes; // List of nodes in the graph
    String Name;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public Graph(String name) {
        this.nodes = new ArrayList<>();
        this.Name = name;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void connectNodes(Node node1, Node node2) {
        node1.addConnection(node2);
        node2.addConnection(node1);
    }

    public String getName(){
        return Name;
    }

    public void setName(String name){
        this.Name = name;
    }


}

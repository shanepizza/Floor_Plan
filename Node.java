import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Define a node in the floor plan graph
public class Node implements Serializable{
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

    public Position[] getNeighbors(){
        Position[] neighbors = new Position[4];

        neighbors[0] = new Position(this.position.x, this.position.y+1);
        neighbors[1] = new Position(this.position.x-1, this.position.y);
        neighbors[2] = new Position(this.position.x+1, this.position.y);
        neighbors[3] = new Position(this.position.x, this.position.y-1);

        return neighbors;
    }


    public boolean isNeighbor(Node neighbor){
        if(this.position.x == neighbor.position.x+1 ||this.position.x == neighbor.position.x-1  && this.position.y == neighbor.position.y+1 || this.position.y == neighbor.position.y-1){
            return true;
        }
        return false;
    }

    
}

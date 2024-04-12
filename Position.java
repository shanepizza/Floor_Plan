// Define the position of a node on the floor plan

import java.io.Serializable;

public class Position implements Serializable{
    int x; // X-coordinate of the node's position
    int y; // Y-coordinate of the node's position

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

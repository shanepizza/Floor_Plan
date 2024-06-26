// Define the types of nodes in the floor plan

import java.io.Serializable;

public enum NodeType implements Serializable{
    DOOR,       // Constant representing a door node
    HALLWAY,    // Constant representing a hallway node
    STAIRCASE,   // Constant representing a staircase node
    DELIMITER   //Used to keep things organized when connecting things automatically
}

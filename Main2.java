import java.util.ArrayList;

public class Main2 {
    static ArrayList<Node> AllNodes = new ArrayList<Node>();
    public static void main(String[] args) {
        createHallway(new Position(2, 3), new Position(20, 3));
        createHallway(new Position(4, 2), new Position(4, 20));
        Graph floorplan = createFloorPlan();
        visualizeFloorPlan(floorplan);
    }//End Main

//Final Form
    public static void createHallway(Position startingposition, Position stoppingPossition){
        
        Node hallwayStart = new Node(NodeType.HALLWAY, startingposition);
        Node hallwayEnd = new Node(NodeType.HALLWAY, stoppingPossition);
        AllNodes.add(hallwayStart);
        


        if(startingposition.y == stoppingPossition.y){
            //if the 'Y' value is the same it is a horizontal Hallway
            for (int x = startingposition.x; x < stoppingPossition.x; x++){
                AllNodes.add(new Node(NodeType.HALLWAY, new Position(x,startingposition.y)));
                //if(AllNodes.get(AllNodes.size()-1) != null && AllNodes.get(AllNodes.size()-2).type != NodeType.DELIMITER){
                    AllNodes.get(AllNodes.size()-1).addConnection(AllNodes.get(AllNodes.size()-2));
                    AllNodes.get(AllNodes.size()-2).addConnection(AllNodes.get(AllNodes.size()-1));
                //}
                
            }//End For
            AllNodes.add(hallwayEnd);
            AllNodes.get(AllNodes.size()-1).addConnection(AllNodes.get(AllNodes.size()-2));
            AllNodes.get(AllNodes.size()-2).addConnection(AllNodes.get(AllNodes.size()-1));
            AllNodes.add(new Node(NodeType.DELIMITER));
        }
        if(startingposition.x == stoppingPossition.x){
            //If the 'X' value is the same it is a vertical Hallway
            for (int y = startingposition.y; y < stoppingPossition.y; y++){
                AllNodes.add(new Node(NodeType.HALLWAY, new Position(startingposition.x, y)));
                //if(AllNodes.get(AllNodes.size()-1) != null && AllNodes.get(AllNodes.size()-2).type != NodeType.DELIMITER){
                    AllNodes.get(AllNodes.size()-1).addConnection(AllNodes.get(AllNodes.size()-2));
                    AllNodes.get(AllNodes.size()-2).addConnection(AllNodes.get(AllNodes.size()-1));
                //}
            }//End For
            AllNodes.add(hallwayEnd);
            AllNodes.get(AllNodes.size()-1).addConnection(AllNodes.get(AllNodes.size()-2));
            AllNodes.get(AllNodes.size()-2).addConnection(AllNodes.get(AllNodes.size()-1));
            AllNodes.add(new Node(NodeType.DELIMITER));
        }

        //AllNodes.add(hallwayEnd);
        //AllNodes.get(AllNodes.size()-1).addConnection(AllNodes.get(AllNodes.size()-2));
        //AllNodes.get(AllNodes.size()-2).addConnection(AllNodes.get(AllNodes.size()-1));


        //TODO: We could add in some code to clarify what happens when positions do not line up perfectly but I will do this later if at all.
    }//Create Hallway
//Final Form
    static Graph createFloorPlan(){
        Graph floorplan = new Graph();

        for (int size = 0; size<AllNodes.size();size++){
            if(AllNodes.get(size).position != null){
                floorplan.addNode(AllNodes.get(size));
            }
            
        }

        System.out.println(floorplan.nodes.get(0));
        return floorplan;
    }//End Create
//Final Form
    public static void visualizeFloorPlan(Graph floorPlan) {
        // Find the maximum x and y coordinates of the nodes
        
        
        int maxX = 0;
        int maxY = 0;
        for (Node node : floorPlan.nodes) {
            maxX = Math.max(maxX, node.position.x);
            maxY = Math.max(maxY, node.position.y);
        }
        
        // Define the size of the grid
        int rows = maxX + 1; // Add 1 to include position 0
        int cols = maxY + 1; // Add 1 to include position 0
    
        // Initialize the grid with empty spaces
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = '.';
            }
        }
    
        // Mark the positions of nodes on the grid
        for (Node node : floorPlan.nodes) {
            int x = node.position.x;
            int y = node.position.y;
    
            if (node.type == NodeType.DOOR) {
                grid[x][y] = 'D';
            } else if (node.type == NodeType.HALLWAY) {
                grid[x][y] = 'H';
            } else if (node.type == NodeType.STAIRCASE) {
                grid[x][y] = 'S';
            }
        }
    
        // Print the grid with flipped rows and columns
        for (int j = cols - 1; j >= 0; j--) {
            for (int i = 0; i < rows; i++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

//WIP
    static void createSmallRoom(){
        //find a hallways node and then create a node right next to it that is of door Type
    }    
    static void createlargeRoom(){
        //Simply connect small room doors that are next to eachother
    }
//WIP
    
//WIP
    static void createGroupOfRooms(int number_of_LargeRooms, int number_of_SmallRooms){
        //Use small rooms 
    }

}



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Main2 {
    static ArrayList<Node> AllNodes = new ArrayList<Node>();
    static ArrayList<Node> Rooms = new ArrayList<Node>();
    public static String filename = "FloorPlan.ser";

    public static void main(String[] args) {
        

    //Create floorplan hides all the code for the nodes
        Graph floorplan = createFloorPlan();
        
        visualizeFloorPlan(floorplan);

    //Serialize//
        SerializeGraph(floorplan, filename);

    //Deserialize//
        visualizeFloorPlan(retrievGraph(filename));

    }//End Main

//Final Form
    public static void createHallway(Position startingposition, Position stoppingPossition){
        if(startingposition.y == stoppingPossition.y){
            //if the 'Y' value is the same it is a horizontal Hallway
            for (int x = startingposition.x; x < stoppingPossition.x; x++){
                AllNodes.add(new Node(NodeType.HALLWAY, new Position(x,startingposition.y)));
            }//End For
        }
        if(startingposition.x == stoppingPossition.x){
            //If the 'X' value is the same it is a vertical Hallway
            for (int y = startingposition.y; y < stoppingPossition.y; y++){
                AllNodes.add(new Node(NodeType.HALLWAY, new Position(startingposition.x, y)));
            }//End For
        }
        //TODO: We could add in some code to clarify what happens when positions do not line up perfectly but I will do this later if at all.
    }//Create Hallway
//Final Form
    static Graph createFloorPlan(){
        Graph floorplan = new Graph();
        createNodes();


        for (int size = 0; size<AllNodes.size();size++){
            for (Node node : AllNodes) {
                for (Node node2 : AllNodes) {
                    if(node.isNeighbor(node2)){
                        node.addConnection(node2);
                        node2.addConnection(node);
                    }
                }
            }
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
    static void createSmallRoom(int size){
        int hallwayNodes = AllNodes.size();
        Random random = new Random();
        int side;
        int node;
        
        
        for(int i = 0; i < size; i++){
            //which side?
            side = random.nextInt(4); 
            //left or top = 0
            //right or bottom = 1
            node = random.nextInt(hallwayNodes);
            //which node do we build on?
                if(!isNode(AllNodes.get(node).getNeighbors()[side], AllNodes)){
                    AllNodes.add(new Node(NodeType.DOOR, AllNodes.get(node).getNeighbors()[side]));
                }//End If
                
        }//End For
            
    }//End createSmallRoom
//WIP
    static void createlargeRoom(){
        //Simply connect small room doors that are next to eachother
    }
//WIP
    static void createGroupOfRooms(int number_of_LargeRooms, int number_of_SmallRooms){
        createSmallRoom(number_of_SmallRooms);
    }

    static boolean isNode(Position spotToCheck, ArrayList<Node> allTheNodes){
        for(int i = 0; i < allTheNodes.size(); i++){
            if( spotToCheck.x == allTheNodes.get(i).position.x && spotToCheck.y == allTheNodes.get(i).position.y){
                return true;
            }
        }
        return false;
       
    }

    static Graph retrievGraph(String fileName){
    Graph ObjectFloor = null;
    
    try {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);


        ObjectFloor = (Graph)in.readObject();

        in.close();
        file.close();

        
    } catch (Exception e) {
        System.out.println("Did you serialize each class?");
    }

    return ObjectFloor;
}

    static void SerializeGraph(Graph serializeThis, String fileName){
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject((Object)serializeThis);

            out.close();
            file.close();

            System.out.println("\n\nFloor Plan has been Serialized\n\n");

        } catch (Exception e) {
            System.out.println("Did you serialize the class above?");
            e.printStackTrace();
        }
    }
//Final Form
    static void createNodes(){
    //Do not cross these hallways pls
        createHallway(new Position(2, 3), new Position(20, 3));
        createHallway(new Position(4, 4), new Position(4, 20));
        createHallway(new Position(15, 4), new Position(15, 20));
        createGroupOfRooms(0, 50);
    }

}//End Class



import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class Re_A_Star extends Thread {
    //static ArrayList<Node> _path = new ArrayList<Node>();

    public static void main(String[] args) {
        
        File[] floors = getAllFiles("C:\\Users\\adamj\\OneDrive\\Documents\\College\\SUU\\Winter2024\\CS3000\\Floor_Plan\\Floor_Plans");
        if(floors != null){
            for(File file : floors){
                //This still needs to be Threaded{
                    Graph thefloor = retrievGraph(file.getName()); 
                    //Not this part though.
                    visualizeFloorPlan(thefloor);
                    begin_Astar(thefloor, thefloor.nodes.get(1), thefloor.nodes.get(0));
                //}
            }//End for
        }//End if
    }//End Main

    public static void begin_Astar(Graph graphWeSearch, Node start, Node goal){
        ArrayList<Node> OpenList = new ArrayList<Node>();
        ArrayList<Node> ClosedList = new ArrayList<Node>();
        ArrayList<Node> ChildrenList = new ArrayList<Node>();
        
        //Add the first element into or array of Nodes to be searched. 
        OpenList.add(start);
        
        //If there are still nodes to search, keep searching
        while(!OpenList.isEmpty()){
            
            //Pop the front of Open list off and begin working with it.
            //By way of how we add nodes, the front of Open list will always have the smalles F value. 
            Node curretnNode = OpenList.remove(0);
            
            //Add current node to the Closedlist (Searched) so that we do not overwrite it's parent.
            ClosedList.add(curretnNode); 

            //Base case!!! Check if this is the goal Node
                if(curretnNode == goal){
                    System.out.println("Found a way out!");
                    printParents(curretnNode);
                    //Currently, it does not print the last spot needed to arrive at the stairs. I manually have it print the lost location. 
                    System.out.println(start.getPositions());
                    return;
                }

            //All connections to the current node COULD be a child of currentNode. whether it actually is depends on which direction we are traveling.
            for(int i = 0; i < curretnNode.connections.size();i++){
                ChildrenList.add(curretnNode.connections.get(i));
            }

            /*
                We itterate through ecah child in the childrenlist. if the child has already been visited, we skip it. 
                **Technically, we should update the closed and opened lists if our path to child is shorter than the path we found in either lists.***
                We then assign an F, G, and H value 
                we put the child node into Open list based on its F value. 
            */
                for(Node child : ChildrenList){
                    if(ClosedList.contains(child) || OpenList.contains(child)) continue;
                    child.parent = curretnNode;
                    child.g = find_traversed(child);
                    child.h = find_distance(goal, child);
                    child.f = calculate_next(child, goal);
                    OpenList.add(compare(OpenList, child.f), child);    
                }
                
                //Clear the Children list so that the next current node can have a clean list
                ChildrenList.clear();
        }
    }//End A*

    public static int compare(ArrayList<Node> listToOrganize, int f_value){
        int result = listToOrganize.size();
        for(int i = 0; i < listToOrganize.size(); i++){
            if(listToOrganize.get(i).f > f_value){
                return i;
            }
        }

        return result;
    }

   public static File[] getAllFiles(String directoryPath){
    File directory = new File(directoryPath);
    File[] floors = directory.listFiles();

    return floors;
    }
//This is H
    static int find_distance(Node child, Node goalNode) {
        int distance_score = 0;
        // Manhattan distance aproach to calculate distance

        int cX = Math.abs(child.position.x);
        int cY = Math.abs(child.position.y);
        int gX = Math.abs(goalNode.position.x);
        int gY = Math.abs(goalNode.position.y);


        distance_score = cX - gX + cY - gY;


        // [ ] return the proper h-score
        return distance_score;
    }
//This is G?
    static int find_traversed(Node child) {
        int traversed_score = 0;
        // get the traversed value of the parent node.
        if(child.type == NodeType.HALLWAY){
            traversed_score = child.parent.g + 1;
        } else{
            traversed_score = child.parent.g + 2;
        }
        

        // [ ] return the proper traversed-score
        return traversed_score;
    }
//This is F
    static int calculate_next(Node child, Node goalNode) {
        int next = find_traversed(child) + find_distance(goalNode, child);


        // [ ] return the proper next-score
        return next;
    }
//No editing needed
    static Graph retrievGraph(String fileName){
        Graph ObjectFloor = null;
        
        try {
            FileInputStream file = new FileInputStream("Floor_Plans\\"+ fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            //BufferedReader br = new BufferedReader(new FileReader(file));

            ObjectFloor = (Graph)in.readObject();

            in.close();
            file.close();

            
        } catch (Exception e) {
            System.out.println("Did you serialize each class?");
            e.printStackTrace();
        }

        return ObjectFloor;
    }//End Retrieve
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
//Might need Editing
    public static void printParents(Node endOfPath){
        Node currentNode = endOfPath;
        while(currentNode.parent != null){
        //Not all nodes have a name right now. Either stop printing the name or make a use case where there is no name. 
            System.out.println("Node: "+ currentNode.name+", Position: "+ currentNode.getPositions());
            currentNode = currentNode.parent;
        }
    }

}//End Class

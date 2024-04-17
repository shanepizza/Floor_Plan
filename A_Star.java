import java.io.File;
import java.util.ArrayList;

public class A_Star extends Thread {
    // [ ] Nodes will all need a variable called parent and a getter and setter for the variable. 

    public static void main(String[] args) {
        
        File[] floors = getAllFiles("Folder to pull from");
        //for(files in folder)
        ArrayList<ArrayList<Position>> Paths = new ArrayList<ArrayList<Position>>();
        if(floors != null){
            for(File file : floors){

            }
        }
            //load in serialized graph class
            // create a thread
            //run A* on the thread with the current graph class

            //print floor name and path.
            //should we add a name variable to each Graph?
        //}





    }

    public static void begin_Astar(Graph graphToSearch, Node start, Node goal){
        //Add start to open list
        ArrayList<Node> OpenList = new ArrayList<Node>();
        ArrayList<Node> ClosedList = new ArrayList<Node>();
        ArrayList<Node> ChildrenList = new ArrayList<Node>();

        while(!OpenList.isEmpty()){
            //[ ] Check (is this node the goal?) {
                //if so, begin to print the path by printing the current node then switch current node to parent node and repeat.
            //}


            //[ ] find the lowest f score in the openlist. (We can either organize the list or check the whole list each time for the lowest f score)
            //[ ] pop the node with the lowest f-score off the list and call it current node 
            
            //[ ] find the children of current node and put them in current children ArrayList

            
            //cycle through the list of children nodes:
                // [ ] set their parent node to current_node (This is used for the path tracing later)
                // [ ] assign a g value to current_child using find_g();
                // [ ] assign an h value to current_child using find_h();
                // [ ] assign an f value by adding g and h or using calculate_f();
                
                //if check both Open and Closed lists (if either have the same node with a lower F score ignore this current_child.)
                
                    //Add to OpenList in the proper spot so the whole list stays in order based on its f score
                //}
                

          
                //Notes* there is no need to worry about the case where current child has a lowerscore than the same node in either the open or closed list because 
        }
    }

    


//Instead of static these methods could all be added to the Node class. might be cleaner

// H is our predetermined heuristic. For the sake of this program we will call it the distance between start and end. 
//feed it the actual distance formula or use the Manhattan distance approach.
    static int find_h(){
    int h_score =0;
        //Manhattan distance aproach to calculate h
    //  h = abs (current_cell.x – goal.x) + abs (current_cell.y – goal.y)
        
    //Distance Formula
    //h = sqrt[(x_2-x_1)^2 + (y_2 - y_1)^2] 
    
    // [ ] return the proper h-score
    return h_score;
    }


//our g variable is going to 1*n where n is the number of moves we make from the beggining
//since there is no difference in cost for moving between hallway nodes, doornodes, etc.
    static int find_g(){
        int g_score =0;
        //get the g value of the parent node. 
        //add 1 to that and call it g for current node.
        
        // [ ] return the proper g-score
        return g_score;
    }

//This is what we will use to determine which node to visit next/where it goes in the list.
    static int calculate_f(){
        int distance = find_g()+find_h();

        // [ ] return the proper f-score
        return distance;
    }

    public static File[] getAllFiles(String directoryPath){
        File directory = new File(directoryPath);
        File[] floors = directory.listFiles();

        return floors;
    }
}


import java.io.File;
import java.util.ArrayList;
import java.util.*;
import java.math.*;


public class A_Star extends Thread {

  public static void main(String[] args) {
        
        File[] floors = getAllFiles("Folder to pull from");
        //for(files in folder)
        ArrayList<ArrayList<Object>> Paths = new ArrayList<ArrayList<Object>>();
        if(floors != null){
            for(File file : floors){

        }
   }
            //load in serialized graph class
            // create a thread
            //run A* on the thread with the current graph class


    static ArrayList<Node> Path;
    // [ ] Nodes will all need a variable called parent and a getter and setter for the variable.

    public A_Star () {
        Path = new ArrayList<>();
    }

    public static void main(String[] args) {

        // for(files in folder)
        // load in serialized graph class
        // create a thread
        // run A* on the thread with the current graph class

        // print floor name and path.
        // should we add a name variable to each Graph?
        // }

    }

    public static void begin_Astar(Graph graphToSearch, Node start, Node goal) {
        // Add start to open list
        ArrayList<Node> OpenList = new ArrayList<Node>();
        ArrayList<Node> ClosedList = new ArrayList<Node>();
        ArrayList<Node> ChildrenList = new ArrayList<Node>();

        start.g = 0;
        start.h = find_distance(start, goal);
        start.f = start.h;

        Node currentNode = start;
        OpenList.add(currentNode);

        while(!OpenList.isEmpty()){
            if (currentNode.equals(goal)) {
                Path.add(currentNode);
                return;
            }
            // sorts the Open List by lowest f value, adds that node to the closed list and removes it from the open list. Adds lowest f val to path list.
            OpenList.sort(Comparator.comparingInt(Node -> Node.f));
            currentNode = OpenList.get(0);
            ClosedList.add(OpenList.get(0));
            OpenList.remove(0);
            Path.add(currentNode);

            for (int i = 0; i < currentNode.connections.size(); i++) {
                // if a child of the current node is the goal node, add it to the path and exit
                if (currentNode.connections.get(i).equals(goal)) {
                    Path.add(currentNode.connections.get(i));
                    return;
                }
                // if a child node is already in the closed list, skip and move on.
                if (ClosedList.contains(currentNode.connections.get(i))) continue;
                ChildrenList.add(currentNode.connections.get(i));
                currentNode.connections.get(i).parent = currentNode;
                ChildrenList.get(i).g = find_traversed(currentNode);
                ChildrenList.get(i).h = find_distance(currentNode, goal);
                ChildrenList.get(i).f = calculate_next(currentNode, goal);
                // if child isn't in open list, add it
                if (!OpenList.contains(ChildrenList.get(i))) {
                    OpenList.add(ChildrenList.get(i));
                } // if the child IS already in the list, check to see which f value is lower. Update the element in OpenList to the lower value and adjust the parent.
                else {
                    for (int j = 0; j < OpenList.size(); j ++) {
                        if (OpenList.get(j).position.equals(ChildrenList.get(i).position)) {
                            if (OpenList.get(j).f > ChildrenList.get(i).f) {
                                OpenList.get(j).f = ChildrenList.get(i).f;
                                OpenList.get(j).parent = ChildrenList.get(i).parent;
                                break;
                            }
                        }
                    }
                }
            }
            // sorts list by lowest f value and sets current node to lowest f val. Adds currentNode to path. Clears children list for next node
            ChildrenList.clear();

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

    // Instead of static these methods could all be added to the Node class. might
    // be cleaner

    // Distance is our predetermined heuristic. For the sake of this program we will
    // call it the distance between start and end.
    // feed it the actual distance formula or use the Manhattan distance approach.
    static int find_distance(Node currentNode, Node goalNode) {
        int distance_score = 0;
        // Manhattan distance aproach to calculate distance

        int cX = Math.abs(currentNode.position.x);
        int cY = Math.abs(currentNode.position.y);
        int gX = Math.abs(goalNode.position.x);
        int gY = Math.abs(goalNode.position.y);


        distance_score = cX - gX + cY - gY;


        // [ ] return the proper h-score
        return distance_score;
    }

    // our traversed variable is going to 1*n where n is the number of moves we make
    // from
    // the beginning
    // since there is no difference in cost for moving between hallway nodes,
    // doornodes, etc.
    static int find_traversed(Node currentNode) {
        int traversed_score = 0;
        // get the traversed value of the parent node.
        traversed_score = currentNode.parent.g + 1;

        // [ ] return the proper traversed-score
        return traversed_score;
    }

    // This is what we will use to determine which node to visit next/where it goes
    // in the list.
    static int calculate_next(Node currentNode, Node goalNode) {
        int next = find_traversed(currentNode) + find_distance(currentNode, goalNode);


        // [ ] return the proper next-score
        return next;
    }

    public static File[] getAllFiles(String directoryPath){
        File directory = new File(directoryPath);
        File[] floors = directory.listFiles();

        return floors;
    }
}

import java.util.ArrayList;

import java.math.*;

public class A_Star {

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


        Node currentNode = start;
        OpenList.add(start);

        while(!OpenList.isEmpty()){
            OpenList.remove(start);

            for (int i = 0; i < currentNode.connections.size(); i++) {
                ChildrenList.add(currentNode.connections.get(i));
                currentNode.connections.get(i).parent = currentNode;
                ChildrenList.get(i).g = find_traversed(currentNode);
                ChildrenList.get(i).h = find_distance(currentNode, goal);
                ChildrenList.get(i).f = calculate_next(currentNode, goal);
            }


            for (int i = 0; i < OpenList.size(); i++) {
                if (OpenList.get(i) == goal) {
                    Path.add(OpenList.get(i));
                    currentNode = OpenList.get(i).parent;
                }
            }




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
}

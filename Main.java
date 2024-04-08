public class Main {
    public static void main(String[] args) {
        // first column of doors
        Node door1 = new Node(NodeType.DOOR, new Position(4, 14));
        Node door2 = new Node(NodeType.DOOR, new Position(4, 12));
        Node door3 = new Node(NodeType.DOOR, new Position(4, 10));
        Node door4 = new Node(NodeType.DOOR, new Position(4, 8));
        Node door5 = new Node(NodeType.DOOR, new Position(4, 6));
        Node door6 = new Node(NodeType.DOOR, new Position(4, 4));
        Node door7 = new Node(NodeType.DOOR, new Position(4, 2));
        //column 2 of doors 
        Node door8 = new Node(NodeType.DOOR, new Position(6, 1));
        Node door9 = new Node(NodeType.DOOR, new Position(6, 8 ));
        Node door10 = new Node(NodeType.DOOR, new Position(6, 13));
        //column 3 of doors 
        Node door11 = new Node(NodeType.DOOR, new Position(10, 9));
        Node door12 = new Node(NodeType.DOOR, new Position(10, 5));
        Node door13 = new Node(NodeType.DOOR, new Position(10, 3));
        //column 4 of doors 
        Node door14 = new Node(NodeType.DOOR, new Position(15, 11));
        Node door15 = new Node(NodeType.DOOR, new Position(15, 6));
        Node door16 = new Node(NodeType.DOOR, new Position(15, 1));
        
        //column 5 of doors 
        Node door17 = new Node(NodeType.DOOR, new Position(17, 11));
        //column 6 of doors
        Node door18 = new Node(NodeType.DOOR, new Position(19, 6));

        //vertical hallway column 1
        Node hallway1 = new Node(NodeType.HALLWAY, new Position(5, 15)); 
        Node hallway2 = new Node(NodeType.HALLWAY, new Position(5, 14));
        Node hallway3 = new Node(NodeType.HALLWAY, new Position(5, 13));
        Node hallway4 = new Node(NodeType.HALLWAY, new Position(5, 12));
        Node hallway5 = new Node(NodeType.HALLWAY, new Position(5, 11));
        Node hallway6 = new Node(NodeType.HALLWAY, new Position(5, 10));
        Node hallway7 = new Node(NodeType.HALLWAY, new Position(5, 9)); 
        Node hallway8 = new Node(NodeType.HALLWAY, new Position(5, 8)); 
        Node hallway9 = new Node(NodeType.HALLWAY, new Position(5, 7)); 
        Node hallway10 = new Node(NodeType.HALLWAY, new Position(5, 6)); 
        Node hallway11 = new Node(NodeType.HALLWAY, new Position(5, 5)); 
        Node hallway12 = new Node(NodeType.HALLWAY, new Position(5, 4)); 
        Node hallway13 = new Node(NodeType.HALLWAY, new Position(5, 3)); 
        Node hallway14 = new Node(NodeType.HALLWAY, new Position(5, 2)); 
        Node hallway15 = new Node(NodeType.HALLWAY, new Position(5, 1));
        
        //horizontal hallway row 1 
        Node hallway16 = new Node(NodeType.HALLWAY, new Position(6, 4)); 
        Node hallway17 = new Node(NodeType.HALLWAY, new Position(7, 4)); 
        Node hallway18 = new Node(NodeType.HALLWAY, new Position(8, 4)); 
        Node hallway19 = new Node(NodeType.HALLWAY, new Position(9, 4)); 
        Node hallway20 = new Node(NodeType.HALLWAY, new Position(10, 4)); 
        Node hallway21 = new Node(NodeType.HALLWAY, new Position(11, 4)); 
        Node hallway22 = new Node(NodeType.HALLWAY, new Position(12, 4)); 
        Node hallway23 = new Node(NodeType.HALLWAY, new Position(13, 4)); 
        Node hallway24 = new Node(NodeType.HALLWAY, new Position(14, 4)); 
        Node hallway25 = new Node(NodeType.HALLWAY, new Position(15, 4)); 
        Node hallway26 = new Node(NodeType.HALLWAY, new Position(16, 4)); 

        //vertical hallway column 2 
        Node hallway27 = new Node(NodeType.HALLWAY, new Position(16, 3)); 
        Node hallway28 = new Node(NodeType.HALLWAY, new Position(16, 5)); 
        Node hallway29 = new Node(NodeType.HALLWAY, new Position(16, 6)); 
        Node hallway30 = new Node(NodeType.HALLWAY, new Position(16, 7)); 
        Node hallway31 = new Node(NodeType.HALLWAY, new Position(16, 8)); 
        Node hallway32 = new Node(NodeType.HALLWAY, new Position(16, 9)); 
        Node hallway33 = new Node(NodeType.HALLWAY, new Position(16, 10)); 
        Node hallway34 = new Node(NodeType.HALLWAY, new Position(16, 11)); 
        Node hallway35 = new Node(NodeType.HALLWAY, new Position(16, 12)); 
        Node hallway36 = new Node(NodeType.HALLWAY, new Position(16, 13)); 
        Node hallway37 = new Node(NodeType.HALLWAY, new Position(16, 14)); 
        Node hallway38 = new Node(NodeType.HALLWAY, new Position(16, 15)); 
        
        //horizontal hallway row 2 
        Node hallway39 = new Node(NodeType.HALLWAY, new Position(17, 5)); 
        Node hallway40 = new Node(NodeType.HALLWAY, new Position(18, 5)); 
        Node hallway41 = new Node(NodeType.HALLWAY, new Position(19, 5)); 

        Node staircase = new Node(NodeType.STAIRCASE, new Position(16, 1));

        // Create a graph
        Graph floorPlan = new Graph();

        // Add nodes to the graph
        floorPlan.addNode(door1);
        floorPlan.addNode(door2);
        floorPlan.addNode(door3);
        floorPlan.addNode(door4);
        floorPlan.addNode(door5);
        floorPlan.addNode(door6);
        floorPlan.addNode(door7);
        floorPlan.addNode(door8);
        floorPlan.addNode(door9);
        floorPlan.addNode(door10);
        floorPlan.addNode(door11);
        floorPlan.addNode(door12);
        floorPlan.addNode(door13);
        floorPlan.addNode(door14);
        floorPlan.addNode(door15);
        floorPlan.addNode(door16);
        floorPlan.addNode(door17);
        floorPlan.addNode(door18);

        floorPlan.addNode(hallway1);
        floorPlan.addNode(hallway2);
        floorPlan.addNode(hallway3);
        floorPlan.addNode(hallway4);
        floorPlan.addNode(hallway5);
        floorPlan.addNode(hallway6);
        floorPlan.addNode(hallway7);
        floorPlan.addNode(hallway8);
        floorPlan.addNode(hallway9);
        floorPlan.addNode(hallway10);
        floorPlan.addNode(hallway11);
        floorPlan.addNode(hallway12);
        floorPlan.addNode(hallway13);
        floorPlan.addNode(hallway14);
        floorPlan.addNode(hallway15);
        floorPlan.addNode(hallway16);
        floorPlan.addNode(hallway17);
        floorPlan.addNode(hallway18);
        floorPlan.addNode(hallway19);
        floorPlan.addNode(hallway20);
        floorPlan.addNode(hallway21);
        floorPlan.addNode(hallway22);
        floorPlan.addNode(hallway23);
        floorPlan.addNode(hallway24);
        floorPlan.addNode(hallway25);
        floorPlan.addNode(hallway26);
        floorPlan.addNode(hallway27);
        floorPlan.addNode(hallway28);
        floorPlan.addNode(hallway29);
        floorPlan.addNode(hallway30);
        floorPlan.addNode(hallway31);
        floorPlan.addNode(hallway32);
        floorPlan.addNode(hallway33);
        floorPlan.addNode(hallway34);
        floorPlan.addNode(hallway35);
        floorPlan.addNode(hallway36);
        floorPlan.addNode(hallway37);
        floorPlan.addNode(hallway38);
        floorPlan.addNode(hallway39);
        floorPlan.addNode(hallway40);
        floorPlan.addNode(hallway41);

        floorPlan.addNode(staircase);

        // Connect doors to hallways 
        floorPlan.connectNodes(door1, hallway2);
        floorPlan.connectNodes(door2, hallway4);
        floorPlan.connectNodes(door3, hallway6);
        floorPlan.connectNodes(door4, hallway8);
        floorPlan.connectNodes(door5, hallway10);
        floorPlan.connectNodes(door6, hallway12);
        floorPlan.connectNodes(door7, hallway14);
        floorPlan.connectNodes(door8, hallway15);
        floorPlan.connectNodes(door9, hallway8);
        floorPlan.connectNodes(door10, hallway3);//11 is a room connecting door (no halway access)
        floorPlan.connectNodes(door12, hallway20);
        floorPlan.connectNodes(door13, hallway20);
        floorPlan.connectNodes(door14, hallway34);
        floorPlan.connectNodes(door15, hallway29);//16 connects to room and stairs ( no hallway access)
        floorPlan.connectNodes(door17, hallway34);
        floorPlan.connectNodes(door18, hallway41);
        
        //room 8 - room 9 door connections 
        floorPlan.connectNodes(door11, door10);
        floorPlan.connectNodes(door11, door14);
        floorPlan.connectNodes(door11, door9);
        floorPlan.connectNodes(door11, door12);
        floorPlan.connectNodes(door11, door15);
        //room 8 door connections
        floorPlan.connectNodes(door15, door9);
        floorPlan.connectNodes(door15, door12);
        floorPlan.connectNodes(door12, door9);

        //room 10 door connections 
        floorPlan.connectNodes(door8, door13);
        floorPlan.connectNodes(door8, door16);
        floorPlan.connectNodes(door13, door16);

        //room 11 door connections 
        floorPlan.connectNodes(door18, door17);


        // HALLWAY CONNECTIONS //

         //vertical hallway column 1
        floorPlan.connectNodes(hallway1, hallway2);
        floorPlan.connectNodes(hallway2, hallway3);
        floorPlan.connectNodes(hallway3, hallway4);
        floorPlan.connectNodes(hallway4, hallway5);
        floorPlan.connectNodes(hallway5, hallway6);
        floorPlan.connectNodes(hallway6, hallway7);
        floorPlan.connectNodes(hallway7, hallway8);
        floorPlan.connectNodes(hallway8, hallway9);
        floorPlan.connectNodes(hallway9, hallway10);
        floorPlan.connectNodes(hallway10, hallway11);
        floorPlan.connectNodes(hallway11, hallway12);
        floorPlan.connectNodes(hallway12, hallway13);
        floorPlan.connectNodes(hallway13, hallway14);
        floorPlan.connectNodes(hallway14, hallway15);

        //horizontal hallway row 1 
        floorPlan.connectNodes(hallway12, hallway16);
        floorPlan.connectNodes(hallway16, hallway17);
        floorPlan.connectNodes(hallway17, hallway18);
        floorPlan.connectNodes(hallway18, hallway19);
        floorPlan.connectNodes(hallway19, hallway20);
        floorPlan.connectNodes(hallway20, hallway21);
        floorPlan.connectNodes(hallway21, hallway22);
        floorPlan.connectNodes(hallway22, hallway23);
        floorPlan.connectNodes(hallway23, hallway24);
        floorPlan.connectNodes(hallway24, hallway25);
        floorPlan.connectNodes(hallway25, hallway26);

        //vertical hallway column 2 
        floorPlan.connectNodes(hallway26, hallway27);
        floorPlan.connectNodes(hallway26, hallway28);
        floorPlan.connectNodes(hallway28, hallway29);
        floorPlan.connectNodes(hallway29, hallway30);
        floorPlan.connectNodes(hallway30, hallway31);
        floorPlan.connectNodes(hallway31, hallway32);
        floorPlan.connectNodes(hallway32, hallway33);
        floorPlan.connectNodes(hallway33, hallway34);
        floorPlan.connectNodes(hallway34, hallway35);
        floorPlan.connectNodes(hallway35, hallway36);
        floorPlan.connectNodes(hallway36, hallway37);
        floorPlan.connectNodes(hallway37, hallway38);

        //horizontal hallway column 2 
        floorPlan.connectNodes(hallway38, hallway39);
        floorPlan.connectNodes(hallway39, hallway40);
        floorPlan.connectNodes(hallway40, hallway41);
        
        //connections to staircase
        floorPlan.connectNodes(hallway27, staircase);
        floorPlan.connectNodes(door16, staircase);


        // Visualize the floor plan
        visualizeFloorPlan(floorPlan);
    }

    // Method to visualize the floor plan
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

    
}

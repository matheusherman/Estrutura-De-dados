//MATHEUS HERMAN BERNARDIM ANDRADE

import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra {

    public static void main(String[] args) {

        final int inf = 9999; //Represents the inifinite value

        //Defines Start Node and End Node - In this case, nodes go from 0 to 5
        final Integer startNode = 0;
        final Integer endNode = 5;

        //Represents the graph with the costs between each link
        int[][] costs ={{inf, 3, 5, 9,inf,inf},
                {inf,inf, 4,inf, 4,inf},
                {inf,inf,inf,inf,inf,10},
                {inf,inf, 6,inf,inf,14},
                {inf,inf,inf,inf, inf, 6},
                {inf,inf,inf,inf,inf, inf}};

        Integer visitingNode = NULL; //Actual visiting node

        ArrayList<Integer> visitedNode = new ArrayList<Integer>();  //Unvisited and visited nodes lists
        ArrayList<Integer> unvisitedNode = new ArrayList(Arrays.asList(0,1,2,3,4,5));

        int[] distance = {inf,inf,inf,inf,inf,inf}; //Information about the distance of each node and its previous node
        int[] previous = new int[6];

        //initialize with the start node, detting its distance to 0
        distance[0] = 0;

        //Checks if there is a negative cost
        for(int i=0; i<costs.length; i++)
            for(int j=0; j<costs.length; j++)
                if(costs[i][j] < 0){
                    System.out.println("The graph cannot have negative costs");
                    return;
                }

        while(!unvisitedNode.isEmpty()){ // While there are unvisited nodes
            visitingNode = unvisitedNode.get(0); //Get an unvisited node to compare and select the one which has the shortest distance value
            for(int i=0; i<unvisitedNode.size(); i++){
                Integer testNode = unvisitedNode.get(i);
                if(distance[visitingNode] > distance[testNode]){
                    visitingNode = testNode;  //Set the selected node as the actual visting node
                    break;
                }
            }
            unvisitedNode.remove(visitingNode); //After selecting the node with the shortest distance, removes it.

            for(int i=0; i<costs.length; i++){  // Calculates the distance for all adjacent nodes
                int dist = distance[visitingNode] + costs[visitingNode][i];
                if(dist < distance[i]){  //If its lower than the one stored, it updates.
                    distance[i]= dist;
                    previous[i] = visitingNode;
                }

            }
            visitedNode.add(visitingNode);
        }

        //Goes reversely onto the path array generated, starting from the end node and going to the previous one.
        //until the start node is reached./
        //So I can reverse the path generated.
        int node = endNode;
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(node);
        while(node != startNode){
            node = previous[node];
            path.add(0,node);
        }

        //Prints the generated pathZ
        System.out.print("Path:");
        for(int a:path)
            System.out.print("  "+(a+1));

        System.out.println();
    }
}

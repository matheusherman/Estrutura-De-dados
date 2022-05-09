//MATHEUS HERMAN BERNARDIM ANDRADE

import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.Arrays;

public class Bellman {

    public static void main(String[] args) {

        final int inf = 999; //Represents the infinite value Integer.MAX_VALUE

        //Defines Start Node and End Node - In this case, nodes go from 0 to 5
        final Integer startNode = 0;
        final Integer endNode = 5;

        //Represents the graph with the costs between each link
        int[][] costs ={{inf, 3, 5, 9,inf,inf},
                {inf, inf, -1,inf, 4,inf},
                {inf,inf,inf,inf,inf,10},
                {inf,inf, -5,inf,inf,14},
                {inf,inf,inf,inf,inf, 6},
                {inf,inf,inf,inf,inf,inf}};

        Integer visitingNode = NULL; //Actual visiting node

        ArrayList<Integer> Nodes = new ArrayList(Arrays.asList(0,1,2,3,4,5));
        int n = Nodes.size();

        int[] distance = {inf,inf,inf,inf,inf,inf}; //Information about the distance of each node and its previous node
        int[] previous = new int[6];

        //initialize with the start node, detting its distance to 0
        distance[startNode] = 0;

        //relax edges
        for(int i=0; i<n; i++){
            for(int j=0; j<costs.length; j++){
                int dist = distance[i] + costs[i][j];
                if(dist < distance[j]){
                    distance[j] = dist;
                    previous[j] = i;
                }
            }
        }

        //check for negative-costs loops
        for(int i=0; i<n; i++){
            for(int j=0; j<costs.length; j++){
                int dist = distance[i] + costs[i][j];
                if(dist < distance[j])
                    System.out.print("Graph contais a negative-cost loop");
            }
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
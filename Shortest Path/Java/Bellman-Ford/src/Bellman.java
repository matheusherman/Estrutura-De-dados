//MATHEUS HERMAN BERNARDIM ANDRADE

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.sql.Types.NULL;

public class Bellman {

    public static void main(String[] args) {

        final int inf = 9999; //Represents the infinite value

        Random generator = new Random();
        generator.setSeed(System.currentTimeMillis());

        //Defines Start Node and End Node - In this case, nodes go from 0 to 29
        final Integer startNode = 0;
        final Integer endNode = 29;

        //Represents the graph with the costs between each link
        int[][] costs = new int[30][30];

        for (int[] row : costs) // Fill each row with inf.
            Arrays.fill(row, inf);

        for (int i = 0; i < costs.length; i++) {
            int edge = generator.nextInt(0, 4); //Generate the number of connections for each node
            while (edge != 0) {
                int link = generator.nextInt(0, costs.length); //Select the node to connect
                int cost = generator.nextInt(21); //Generate the cost of the link
                if (cost == 0 || i == link) {
                    cost = inf;
                }
                if (link == i) {
                    costs[i][link] = inf; //Insert the infinite value when a node link on himself
                }
                //Insert the value of the costs on the node position
                costs[i][link] = cost;
                if (costs[i][link] != 9999) {
                    costs[link][i] = costs[i][link]; //Provides the connection from both sides in a node
                }
                edge--;
            }
        }

        Integer visitingNode = NULL; //Actual visiting node

        ArrayList<Integer> Nodes = new ArrayList();

        for (int i = 0; i < costs.length; i++) {
            Nodes.add(i);
        }
        int n = Nodes.size();

        int[] distance = new int[30]; //Information about the distance of each node and its previous node
        Arrays.fill(distance, inf);
        int[] previous = new int[30];

        //initialize with the start node, detting its distance to 0
        distance[startNode] = 0;

        //relax edges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < costs.length; j++) {
                int dist = distance[i] + costs[i][j];
                if (dist < distance[j]) {
                    distance[j] = dist;
                    previous[j] = i;
                }
            }
        }

        //check for negative-costs loops
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < costs.length; j++) {
                int dist = distance[i] + costs[i][j];
                if (dist < distance[j])
                    System.out.print("Graph contais a negative-cost loop");
                break;
            }
        }

        //Goes reversely onto the path array generated, starting from the end node and going to the previous one.
        //until the start node is reached./
        //So I can reverse the path generated.
        int node = endNode;
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(node);
        while (node != startNode) {
            node = previous[node];
            path.add(0, node);
        }

        //Prints the generated pathZ
        System.out.print("Path:");
        for (int a : path)
            System.out.print("  " + (a + 1));

        System.out.println();


    }
}
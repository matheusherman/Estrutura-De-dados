//MATHEUS HERMAN BERNARDIM ANDRADE

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.sql.Types.NULL;

public class Dijkstra {

    public static void main(String[] args) {

        final int inf = 9999; //Represents the infinite value

        Random generator = new Random();
        generator.setSeed(System.currentTimeMillis());

        //Defines Start Node and End Node - In this case, nodes go from 0 to 29
        final Integer startNode = 0;
        final Integer endNode = 29;

        //Represents the graph with the costs between each link
        int[][] costs = new int[30][30];

        // Fill each row with 10.
        for (int[] row : costs)
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

        ArrayList<Integer> visitedNode = new ArrayList<Integer>();  //Unvisited and visited nodes lists
        ArrayList<Integer> unvisitedNode = new ArrayList();

        for (int i = 0; i < costs.length; i++) {
            unvisitedNode.add(i);
        }

        int[] distance = new int[30]; //Information about the distance of each node and its previous node
        Arrays.fill(distance, inf);
        int[] previous = new int[30];

        //initialize with the start node, detting its distance to 0
        distance[0] = 0;

        //Checks if there is a negative cost
        for (int i = 0; i < costs.length; i++)
            for (int j = 0; j < costs.length; j++)
                if (costs[i][j] < 0) {
                    System.out.println("The graph cannot have negative costs");
                    return;
                }

        while (!unvisitedNode.isEmpty()) { // While there are unvisited nodes
            visitingNode = unvisitedNode.get(0); //Get an unvisited node to compare and select the one which has the shortest distance value
            for (int i = 0; i < unvisitedNode.size(); i++) {
                Integer testNode = unvisitedNode.get(i);
                if (distance[visitingNode] > distance[testNode]) {
                    visitingNode = testNode;  //Set the selected node as the actual visting node
                    break;
                }
            }
            unvisitedNode.remove(visitingNode); //After selecting the node with the shortest distance, removes it.

            for (int i = 0; i < costs.length; i++) {  // Calculates the distance for all adjacent nodes
                int dist = distance[visitingNode] + costs[visitingNode][i];
                if (dist < distance[i]) {  //If its lower than the one stored, it updates.
                    distance[i] = dist;
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
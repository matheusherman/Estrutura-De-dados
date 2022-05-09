//MATHEUS HERMAN BERNARDIM ANDRADE

import static java.sql.Types.NULL;
import java.util.ArrayList;

public class Suurballe {
    static final int inf = 999;
    static int[] distance;

    public static void main(String[] args) {
        int startNode = 0;
        int endNode = 11;
        //                 1   2   3    4    5   6    7    8   9   10   11   12
        int[][] graph = {{inf, 1, inf, inf, inf, inf, inf, 2, inf, inf, inf, inf},  //1
                        {inf, inf, 1, inf, inf, inf, inf, inf, 3, inf, inf, inf},   //2
                        {inf, inf, inf, 1, inf, inf, inf, inf, inf, inf, inf, inf}, //3
                        {inf, inf, inf, inf, 1, inf, inf, inf, inf, 3, inf, inf},   //4
                        {inf, inf, inf, inf, inf, 1, inf, inf, inf, inf, inf, inf}, //5
                        {inf, inf, inf, inf, inf, inf, 1, inf, inf, inf, 2, inf},   //6
                        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 1}, //7
                        {inf, inf, 1, inf, inf, inf, inf, inf, inf, inf, inf, inf}, //8
                        {inf, inf, inf, inf, 1, inf, inf, inf, inf, inf, inf, inf}, //9
                        {inf, inf, inf, inf, inf, inf, 1, inf, inf, inf, inf, inf}, //10
                        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 1}, //11
                        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf}};//12

        int[][] modGraph = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++)
            for (int j = 0; j < graph.length; j++)
                modGraph[i][j] = graph[i][j];
        //1st step
        ArrayList<Integer> firstShortestPath = Dijkstra(graph, startNode, endNode);
        //2nd step
        //Calculating the new costs of the links
        for (int i = 0; i < graph.length; i++)
            for (int j = 0; j < graph.length; j++)
                if (graph[i][j] != inf)
                    modGraph[i][j] = graph[i][j] - distance[j] + distance[i];
        //Reversing the direction of the links
        for (int i = 0; i < firstShortestPath.size() - 1; i++) {
            int a = firstShortestPath.get(i);
            int b = firstShortestPath.get(i + 1);
            modGraph[b][a] = modGraph[a][b] * -1;
            modGraph[a][b] = inf;
        }
        //3rd step
        ArrayList<Integer> secondShortestPath = Dijkstra(modGraph, startNode, endNode);
        //4th step
        for (int i = 0; i < firstShortestPath.size() - 1; i++) {
            int s1 = firstShortestPath.get(i);          //Start node of the link
            int d1 = firstShortestPath.get(i + 1);      //End node of the link
            for (int j = 0; j < secondShortestPath.size() - 1; j++) {
                int s2 = secondShortestPath.get(j);     //Start node of the link
                int d2 = secondShortestPath.get(j + 1); //End node of the link
                if (s1 == d2 && d1 == s2)               //Check if the link is the same, but in different directions
                graph[s1][d1] = inf;                    //Deletes the link from the modified graph
            }
        }
        //5th step
        //Runs Dijkstra algorithm again to find the best route. Then removes that rout from the graph.
        //After removing, runs Dijkstra again to find the second best route.
        ArrayList<Integer> firstDisjointPath = Dijkstra(graph, startNode, endNode);
        for (int i = 0; i < firstDisjointPath.size() - 1; i++)
            graph[firstDisjointPath.get(i)][firstDisjointPath.get(i + 1)] = inf;
        ArrayList<Integer> secondDisjointPath = Dijkstra(graph, startNode, endNode);

        System.out.println("1st Path: ");
        for (int a : firstDisjointPath)
            System.out.print(a + 1 + " ");
        System.out.println("\n\n2nd Path: ");
        for (int a : secondDisjointPath)
            System.out.print(a + 1 + " ");
        System.out.println();
    }

    public static ArrayList<Integer> Dijkstra(int[][] graph, int startNode, int endNode) {
        //Represents the graph with the costs between each link
        int[][] costs = graph;
        Integer visitingNode = NULL; //Actual visiting node
        ArrayList<Integer> visitedNode = new ArrayList<Integer>(); //Unvisited and visited nodes lists
        ArrayList<Integer> unvisitedNode = new ArrayList<Integer>();
        int[] previous = new int[costs.length];
        int[] distance = new int[costs.length]; //Information about the distance of each node and its previous node
        for (int i = 0; i < costs.length; i++) {
            unvisitedNode.add(i);
            distance[i] = inf;
        }

        //initialize with the start node, detting its distance to 0
        distance[0] = 0;
        //Checks if there is a negative cost
        for (int i = 0; i < costs.length; i++)
            for (int j = 0; j < costs.length; j++)
                if (costs[i][j] < 0) {
                    System.out.println("The graph cannot have negative costs");
                    return null;
                }

        while (!unvisitedNode.isEmpty()) { // While there are unvisited nodes
            visitingNode = unvisitedNode.get(0); //Get an unvisited node to compare and select the one which has the shortest distance value
            for (int i = 0; i < unvisitedNode.size(); i++) {
                Integer testNode = unvisitedNode.get(i);
                if (distance[visitingNode] > distance[testNode]) {
                    visitingNode = testNode; //Set the selected node as the actual visting node
                    break;
                }
            }
            unvisitedNode.remove(visitingNode); //After selecting the node with the shortest distance, removes it.

            for (int i = 0; i < costs.length; i++) { // Calculates the distance for all adjacent nodes
                int dist = distance[visitingNode] + costs[visitingNode][i];
                if (dist < distance[i]) { //If its lower than the one stored, it updates.
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
        Suurballe.distance = distance;
        return path;
    }
}
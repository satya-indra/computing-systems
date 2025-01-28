package org.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * input
 * 7 #vertices
 * 8 #edges
 * 0 1 10
 * 1 2 10
 * 2 3 10
 * 0 3 10
 * 3 4 10
 * 4 5 10
 * 5 6 10
 * 4 6 10
 * 0 # find path from
 * 6 # find path to
 */
public class PrintAllPaths {

    public static void main(String[] args) {
        int vertex = 7;
        int edges = 8;
        List<Edge>[] graph = getGraph();

        boolean[] visited = new boolean[7];
        String visitedSoFar = new String();

//        path(graph, 0, 6, visited, visitedSoFar + 0);

        pathIterative(graph);

    }

    private static void pathIterative(List<Edge>[] graph) {
        int source = 0;
        int destination = 6;

        boolean[] visited = new boolean[7];
        List<Edge> edges = graph[source];
        Stack<List<Edge>> stack = new Stack<>();
        stack.push(edges);
        visited[source] = true;
        String psof = "0";
        System.out.print("0");

        while (!stack.empty()) {
            List<Edge> e = stack.pop();
            for (Edge ele : e) {
                int nbr = ele.neighbour;
                if(!visited[nbr]) {
                    System.out.print(nbr);
                    List<Edge> nbrEdges = graph[nbr];
                    stack.push(nbrEdges);
                }
            }
        }

    }

    private static void path(List<Edge>[] graph, int source, int destination, boolean[] visited, String visitedSoFar) {

        if(source == destination) {
            System.out.println(visitedSoFar.toString());
            return;
        }

        List<Edge> edgesForSelectedVertex = graph[source];
        // pre order in recursion
        visited[source] = true;
        for(Edge edge : edgesForSelectedVertex) {
            int nextNeighbour = edge.neighbour;
            if(!visited[nextNeighbour]) {
                path(graph, nextNeighbour, destination, visited, visitedSoFar + nextNeighbour);
            }
        }
        // post order in recursion
        visited[source] = false;

    }

    private static List<Edge>[] getGraph() {
        int vertex = 7;
        int edges = 8;
        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(0, 1, 10));
        input.add(List.of(1, 2, 10));
        input.add(List.of(2, 3, 10));
        input.add(List.of(0, 3, 10));
        input.add(List.of(3, 4, 10));
        input.add(List.of(4, 5, 10));
        input.add(List.of(5, 6, 10));
        input.add(List.of(4, 6, 10));

        List<Edge>[] graph = new ArrayList[7];

        for (List<Integer> in : input) {
            List<Edge> res = graph[in.get(0)];
            if(res == null) {
                res = new ArrayList<>();
            }
            res.add(new Edge(in.get(0), in.get(1), in.get(2)));
            graph[in.get(0)] = res;

            List<Edge> res2 = graph[in.get(1)];
            if(res2 == null) {
                res2 = new ArrayList<>();
            }
            res2.add(new Edge(in.get(1), in.get(0), in.get(2)));
            graph[in.get(1)] = res2;


        }
        return graph;
    }


    static class Edge {
        int source;
        int neighbour;
        int weight;

        public Edge(int source, int neighbour, int weight) {
            this.source = source;
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }
    
    
}

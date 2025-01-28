package org.example.graph;


import java.util.ArrayList;
import java.util.List;

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
public class HasPath {

    public static void main(String[] args) {
        List<Edge>[] graph = getGraph();

        boolean[] visited = new boolean[7];

        boolean ans = hasPath(graph, 0, 6, visited);

        System.out.println(ans);

    }

    private static boolean hasPath(List<Edge>[] graph, int start, int end, boolean[] visited) {

        if(start == end) {
            return true;
        }

        visited[start] = true;

        for (Edge ele : graph[start]) {
            int neighbour = ele.neighbour;
            if(visited[neighbour] == false) {
                boolean doesPathExistsFromNeighbour = hasPath(graph, neighbour, end, visited);
                if (doesPathExistsFromNeighbour) {
                    return true;
                }
            }

        }

        return false;


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

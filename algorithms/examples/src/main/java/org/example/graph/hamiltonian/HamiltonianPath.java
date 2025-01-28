package org.example.graph.hamiltonian;

import java.util.*;

public class HamiltonianPath {
    public static void main(String[] args) {
        int totalVertex = 7;

        List<Edge>[] graph = getGraph(getInputLists(), totalVertex);

        int source = 0;
        Set<Integer> visited = new HashSet<>();
        String psf = "0";

        getHamiltonianPathForK(graph,source, visited, psf, 0);


    }

    private static void getHamiltonianPathForK(List<Edge>[] graph, int source, Set<Integer> visited, String psf, int originalSource) {
        visited.add(source);

        // base case check if all vertex has been visited
        if(graph.length == visited.size()) {

            System.out.print(psf);

            // now check if is a hamiltonian cycle
            // means last node has neighbour original source

            boolean isClosingEdge = false;

            for (Edge edge : graph[source]) {
                if(edge.neighbour == originalSource) {
                    isClosingEdge = true;
                    break;
                }
            }

            if (isClosingEdge) {
                System.out.print("*");
            } else {
                System.out.print(".");
            }

            System.out.println();


            visited.remove(source);

            return;
        }


        for(Edge edge : graph[source]) {
            int neighbour = edge.neighbour;
            if(!visited.contains(neighbour)) {
                getHamiltonianPathForK(graph, neighbour, visited, psf + neighbour, originalSource);
            }
        }

        visited.remove(source);

    }

    private static List<Edge>[] getGraph(List<List<Integer>> input, int totalVertex) {

        List<Edge>[] graph = new ArrayList[totalVertex];

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

    private static List<List<Integer>> getInputLists() {
        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(0, 1, 10));
        input.add(List.of(0, 3, 10));
        input.add(List.of(1, 2, 10));
        input.add(List.of(2, 3, 10));
        input.add(List.of(2, 5, 10));
        input.add(List.of(3, 4, 10));
        input.add(List.of(4, 5, 10));
        input.add(List.of(4, 6, 10));
        input.add(List.of(5, 6, 10));
        return input;
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

package Knapsack01;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KanpsackCode {
     

 

    // Defines edge structure
    static class Edge {
        int p1, p2, weight;

        public Edge(int p1, int p2, int weight) {
            this.p1 = p1;
            this.p2 = p2;
            this.weight = weight;
        }
    }

    // Starting point of program execution
    public static void main(String[] args) {
        int V = 4;
        List<Edge> graphEdge = new ArrayList<>(List.of(
            new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(1, 3, 15),
            new Edge(2, 3, 4)
        ));

        // Sort the edges in non-decreasing order (increasing with repetition)
        graphEdge.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });

        Kruskal(V, graphEdge);
    }

    // Function to find the MST
    public static void Kruskal(int V, List<Edge> edgeList) {
        int j = 0;
        int noOfEdges = 0;
        int[] visit = new int[V];
        Edge[] result = new Edge[V];

        // Number of edges to be taken is equal to V - 1
        while (noOfEdges < V - 1) {
            Edge nextEdge = edgeList.get(j++);
            // You would typically check here for cycles using Union-Find
            // This part seems to be on the next page or incomplete
        }
    }
    int x = nextEdge.p1;
int y = nextEdge.p2;

if (visit[x] == 0 || visit[y] == 0) {
    result[nofEdge] = nextEdge;
    nofEdge++;
    visit[x] = visit[y] = 1;
}
j++;

// ...

public class Main {
    public static void kruskal(int V, List<Edge> edges) {
        System.out.println("Following edges of MST:");
        int minCost = 0;
        for (int i = 0; i < nofEdge; i++) {
            System.out.println(result[i].p1 + " --- " +result[i].p2 + " == " +
                               result[i].weight);
            minCost += result[i].weight;
        }
        System.out.println("Total cost of MST: " + minCost);
    }
}
}

    


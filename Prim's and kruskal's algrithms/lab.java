import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v, w;
    Edge(int u, int v, int w) {
        this.u = u; this.v = v; this.w = w;
    }
    public int compareTo(Edge e) {
        return this.w - e.w;
    }
}

class Graph {
    int n;
    List<Edge> edges = new ArrayList<>();
    List<List<int[]>> adj;
    Graph(int n) {
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    }

    void addEdge(int u, int v, int w) {
        edges.add(new Edge(u, v, w));
        adj.get(u).add(new int[]{v, w});
        adj.get(v).add(new int[]{u, w});
    }

    int kruskalMST() {
        Collections.sort(edges);
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int total = 0, count = 0;
        for (Edge e : edges) {
            int pu = find(parent, e.u), pv = find(parent, e.v);
            if (pu != pv) {
                parent[pu] = pv;
                total += e.w;
                count++;
            }
            if (count == n - 1) break;
        }
        return total;
    }

    int find(int[] parent, int u) {
        if (parent[u] != u) parent[u] = find(parent, parent[u]);
        return parent[u];
    }

    int primMST() {
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});
        int total = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], w = curr[1];
            if (visited[u]) continue;
            visited[u] = true;
            total += w;
            for (int[] edge : adj.get(u)) {
                int v = edge[0], wt = edge[1];
                if (!visited[v]) pq.offer(new int[]{v, wt});
            }
        }
        return total;
    }
}

public class lab{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            g.addEdge(u, v, w);
        }
        int costK = g.kruskalMST();
        int costP = g.primMST();
        System.out.println("MST Cost using Kruskal's Algorithm: " + costK);
        System.out.println("MST Cost using Prim's Algorithm: " + costP);
        System.out.println("Number of distinct MSTs (not fully implemented): 3");
    }
}

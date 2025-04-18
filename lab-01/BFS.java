import java.util.*;
public class BFS {
    static boolean isCyclicBFS(int V, List<List<Integer>> adj) {
        int[] visited = new int[V];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                queue.add(new int[]{i, -1}); 
                visited[i] = 1;

                while (!queue.isEmpty()) {
                    int[] node = queue.poll();
                    int curr = node[0], parent = node[1];

                    for (int neighbor : adj.get(curr)) {
                        if (visited[neighbor] == 0) {
                            queue.add(new int[]{neighbor, curr});
                            visited[neighbor] = 1;
                        } else if (neighbor != parent) {
                            return true; // Cycle detected
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes and edges:");
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        System.out.println("Enter the edges:");
        for (int i = 0; i < E; i++) {
            int u = sc.next().charAt(0) - 'A';
            int v = sc.next().charAt(0) - 'A';
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        if (isCyclicBFS(V, adj))
            System.out.println("Cycle detected in the graph.");
        else
            System.out.println("No cycle detected in the graph.");
        
        sc.close();
    }
}

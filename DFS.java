import java.util.*;

public class DFS {
    static int mat[][] = new int[20][20];
    static int stack[] = new int[20];
    static int top = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8, edge = 9, a, b;
        int visit[] = new int[n];

        System.out.println("Enter " + edge + " pair of nodes (edges): ");
        for (int i = 0; i < edge; i++) {
            a = (int) sc.next().charAt(0) - 'A'; // Convert character to integer index (e.g., A -> 0)
            b = (int) sc.next().charAt(0) - 'A';
            mat[a][b] = mat[b][a] = 1; // Undirected graph
        }

        int src = 7; // Starting from node 'H' (index 7)
        push(src);
        visit[src] = 1;

        while (top >= 0) { // While stack is not empty
            int par = stack[top];
            int flag = 0;

            for (int child = 0; child < n; child++) {
                if (mat[par][child] == 1 && visit[child] != 1) {
                    visit[child] = 1;
                    push(child);
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                pop();
            }
        }
    }

    static void push(int item) {
        stack[++top] = item;
        System.out.println((char) (item + 'A')); // Print node as a character
    }

    static void pop() {
        top--;
    }
}

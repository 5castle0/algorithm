import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] parent;
    static int ans = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 집의 개수
        m = Integer.parseInt(st.nextToken()); // 길의 개수

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Node(a, b, cost));
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (find(now.a) != find(now.b)) {
                union(now.a, now.b);
                ans += now.cost;
                max = Math.max(max, now.cost);

            }
        }

        bw.write(String.valueOf(ans - max));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

    private static int find(int a) {
        if (parent[a] != a) {
            return parent[a] = find(parent[a]);
        }

        return a;
    }

    static class Node implements Comparable<Node> {

        int a;
        int b;
        int cost;
        
        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
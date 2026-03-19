import java.io.*;
import java.util.*;

public class Main {

    static int n, m, x;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            temp += dijkstra(i, x);
            temp += dijkstra(x, i);

            if (max < temp) {
                max = temp;
            }
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijkstra(int start, int end) {
        boolean[] visited = new boolean[n + 1];

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.index]) {
                continue;
            }
            visited[now.index] = true;

            for (Node i : graph[now.index]) {
                if (distance[i.index] > distance[now.index] + i.weight) {
                    distance[i.index] = distance[now.index] + i.weight;
                    pq.add(new Node(i.index, distance[i.index]));
                }
            }
        }

        return distance[end];
    }

    static class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int v;
    static int e;
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken()); // 정점의 개수
        e = Integer.parseInt(st.nextToken()); // 간선의 개수

        root = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            root[i] = i;
        }

        PriorityQueue<Connection> pq = new PriorityQueue<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.add(new Connection(a, b, weight));
        }

        // 최종 가중치
        int finalWeight = 0;

        while (!pq.isEmpty()) {
            Connection now = pq.poll();

            if (find(now.a) != find(now.b)) {
                union(now.a, now.b);
                finalWeight += now.weight;
            }
        }

        bw.write(String.valueOf(finalWeight));
        bw.flush();
        bw.close();
        br.close();
    }

    // 정점들의 연결 정보
    static class Connection implements Comparable<Connection> {
        int a;
        int b;
        int weight;

        public Connection(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Connection o) {
            return this.weight - o.weight;
        }
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // 더 작은 걸 기준으로 union
        if (rootA < rootB) {
            root[rootB] = rootA;
        } else {
            root[rootA] = rootB;
        }
    }

    private static int find(int a) {
        if (root[a] != a) {
            return root[a] = find(root[a]);
        }

        return a;
    }
}
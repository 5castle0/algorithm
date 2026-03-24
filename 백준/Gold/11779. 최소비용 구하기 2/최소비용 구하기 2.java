import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int realStart, realGoal;
    static List<Node>[] info;
    static int min;
    static int[] prior;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine()); // 도시의 개수
        m = Integer.parseInt(br.readLine()); // 버스의 개수

        info = new ArrayList[n + 1]; // 버스 정보
        prior = new int[n + 1]; // 도시 방문 순서
        for (int i = 1; i <= n; i++) {
            info[i] = new ArrayList<>();
            prior[i] = i;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            info[start].add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        realStart = Integer.parseInt(st.nextToken());
        realGoal = Integer.parseInt(st.nextToken());

        min = dijkstra();

        bw.write(min + "\n");

        Stack<Integer> stack = new Stack<>();
        stack.add(realGoal);
        while (true) {
            int now = stack.peek();

            // 현재 요소 이전 index를 push
            int temp = prior[now];

            stack.add(temp);

            if (temp == realStart) {
                break;
            }
        }

        bw.write(stack.size() + "\n");
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijkstra() {

        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[realStart] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(realStart, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > cost[now.index]) {
                continue;
            }

            for (Node next : info[now.index]) {
                if (cost[next.index] > cost[now.index] + next.cost) {
                    cost[next.index] = cost[now.index] + next.cost;
                    prior[next.index] = now.index;
                    pq.add(new Node(next.index, cost[next.index]));
                }
            }
        }

        return cost[realGoal];
    }

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
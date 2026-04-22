import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int n, k;
    static int[] time;
    static int[] enter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            time = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            enter = new int[n + 1];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                enter[b]++;
            }

            int w = Integer.parseInt(br.readLine()); // goal

            bw.write(topology(w) + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int topology(int goal) {
        Queue<Integer> queue = new LinkedList<>();

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = time[i];

            if (enter[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i : graph[x]) {
                enter[i]--;
                dp[i] = Math.max(dp[i], dp[x] + time[i]);

                if (enter[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return dp[goal];
    }
}
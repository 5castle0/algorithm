import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int n, m;
    static int[] enter; // 진입 차수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 인접 리스트
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        enter = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a -> b
            graph[a].add(b);

            enter[b]++;
        }

        bw.write(topology());
        bw.flush();
        bw.close();
        br.close();
    }

    private static String topology() {

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> answer = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (enter[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int person = queue.poll();
            answer.add(person);

            for (int i : graph[person]) {
                enter[i]--;

                if (enter[i] == 0) {
                    queue.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }

        return sb.toString();
    }
}
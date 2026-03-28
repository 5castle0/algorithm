import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<Integer>[] info;
    static int[] enter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        info = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            info[i] = new ArrayList<>();
        }
        enter = new int[n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            info[a].add(b);
            enter[b]++;
        }

        List<Integer> order = topology();

        for (int i : order) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static List<Integer> topology() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        List<Integer> order = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (enter[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();
            order.add(now);

            for (int i : info[now]) {
                enter[i]--;

                if (enter[i] == 0) {
                    pq.add(i);
                }
            }
        }

        return order;
    }
}
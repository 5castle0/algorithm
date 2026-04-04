import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            list[deadline].add(count);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            pq.addAll(list[i]);

            while (pq.size() > i) {
                pq.poll();
            }
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();
    }
}

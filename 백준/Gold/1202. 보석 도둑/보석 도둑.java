import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Gem[] gems = new Gem[n];
        int[] bag = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            gems[i] = new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        Arrays.sort(gems);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long ans = 0;
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (index < n) {
                if (bag[i] >= gems[index].m) {
                    pq.add(gems[index++].v);
                } else {
                    break;
                }
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();
    }

    static class Gem implements Comparable<Gem> {
        int m;
        int v;

        public Gem(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Gem o) {
            if (this.m != o.m) {
                return this.m - o.m;
            } else {
                return o.v - this.v;
            }
        }
    }
}
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 9019
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String instruction = bfs(a, b);
            bw.write(instruction + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static String bfs(int a, int b) {
        Queue<DSLR> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];

        queue.add(new DSLR(a, ""));

        while (!queue.isEmpty()) {
            DSLR now = queue.poll();

            if(visited[now.n]){
                continue;
            }

            visited[now.n] = true;

            if (now.n == b) {
                return now.instruction;
            }

            // D
            queue.add(new DSLR((2 * now.n) % 10000, now.instruction + "D"));

            // S
            int temp = now.n;
            if (temp == 0) {
                temp = 9999;
            } else {
                temp--;
            }
            queue.add(new DSLR(temp, now.instruction + "S"));


            int d1 = now.n / 1000;
            int d2 = (now.n / 100) % 10;
            int d3 = (now.n / 10 % 10);
            int d4 = now.n % 10;

            // L
            int l = d2 * 1000 + d3 * 100 + d4 * 10 + d1;
            queue.add(new DSLR(l, now.instruction + "L"));

            // R
            int r = d4 * 1000 + d1 * 100 + d2 * 10 + d3;
            queue.add(new DSLR(r, now.instruction + "R"));

        }

        return "";
    }

    static class DSLR {
        int n;
        String instruction;

        public DSLR(int n, String instruction) {
            this.n = n;
            this.instruction = instruction;
        }
    }
}
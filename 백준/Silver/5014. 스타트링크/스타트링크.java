import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken()); // total floor
        int s = Integer.parseInt(st.nextToken()); // now
        int g = Integer.parseInt(st.nextToken()); // goal
        int u = Integer.parseInt(st.nextToken()); // up
        int d = Integer.parseInt(st.nextToken()); // down

        boolean[] visited = new boolean[f + 1];

        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(s, 0));
        visited[s] = true;
        boolean flag = false;
        while (!queue.isEmpty()) {
            Move now = queue.poll();

            if (now.floor == g) {
                bw.write(String.valueOf(now.count));
                flag = true;
                break;
            }

            if (now.floor + u <= f && !visited[now.floor + u]) {
                queue.add(new Move(now.floor + u, now.count + 1));
                visited[now.floor + u] = true;
            }

            if (now.floor - d > 0 && !visited[now.floor - d]) {
                queue.add(new Move(now.floor - d, now.count + 1));
                visited[now.floor - d] = true;
            }
        }

        if (!flag) {
            bw.write("use the stairs");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static class Move {
        int floor;
        int count;

        public Move(int floor, int count) {
            this.floor = floor;
            this.count = count;
        }
    }
}
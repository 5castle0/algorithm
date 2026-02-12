import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 13549
public class Main {

    static int SIZE = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[SIZE + 1];
        visited[n] = true;

        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(n, 0));

        while (!queue.isEmpty()) {
            Move now = queue.poll();

            if (now.spot == k) {
                bw.write(String.valueOf(now.time));
                break;
            }

            if (2 * now.spot <= SIZE && !visited[2 * now.spot]) {
                queue.add(new Move(2 * now.spot, now.time));
                visited[2 * now.spot] = true;
            }

            if (0 <= now.spot - 1 && !visited[now.spot - 1]) {
                queue.add(new Move(now.spot - 1, now.time + 1));
                visited[now.spot - 1] = true;
            }

            if (now.spot + 1 <= SIZE && !visited[now.spot + 1]) {
                queue.add(new Move(now.spot + 1, now.time + 1));
                visited[now.spot + 1] = true;

            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Move {
        int spot;
        int time;

        Move(int spot, int time) {
            this.spot = spot;
            this.time = time;
        }
    }
}
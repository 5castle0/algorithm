import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2589
public class Main {

    static int x, y;
    static boolean[][] land;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        land = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                if (str.charAt(j) == 'L') {
                    land[i][j] = true;
                }
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (land[i][j]) {
                    bfs(i, j);
                }
            }
        }

        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int py, int px) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(px, py, 0));
        boolean[][] visited = new boolean[y][x];
        visited[py][px] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (time < now.move) {
                time = now.move;
            }

            for (int i = 0; i < 4; i++) {
                int cx = now.x + dx[i];
                int cy = now.y + dy[i];
                if (0 <= cx && cx < x && 0 <= cy && cy < y) {
                    if (land[cy][cx] && !visited[cy][cx]) {
                        queue.add(new Point(cx, cy, now.move + 1));
                        visited[cy][cx] = true;
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int move;

        Point(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
}
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 14940
public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[] start = new int[2]; // y x
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }

                // 방문 배열 초기화
                if (map[i][j] == 0 || map[i][j] == 2) {
                    visited[i][j] = 0;
                } else {
                    visited[i][j] = -1;
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start[0], start[1], 0));
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                    if (visited[nextY][nextX] == -1) {
                        queue.add(new Point(nextY, nextX, now.distance + 1));
                        visited[nextY][nextX] = now.distance + 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(visited[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        int distance;

        Point(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
}
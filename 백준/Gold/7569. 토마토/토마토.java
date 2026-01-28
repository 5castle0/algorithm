import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7569
public class Main {
    static int[][][] box;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 가로칸의 수
        int n = Integer.parseInt(st.nextToken()); // 세로칸의 수
        int h = Integer.parseInt(st.nextToken()); // 상자의 수

        box = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    // -1 은 토마토가 없는 칸
                    // 0 은 안 익은 토마토
                    // 1은 익은 토마토
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();

        // 익어있던 토마토 큐에 집어넣기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 1) {
                        queue.add(new Point(i, j, k));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Point tomato = queue.poll();

            for (int i = 0; i < 6; i++) {
                int cx = tomato.x + dx[i];
                int cy = tomato.y + dy[i];
                int cz = tomato.h + dz[i];
                // 범위 내 있는지 확인
                if (0 <= cx
                        && cx < m
                        && 0 <= cy
                        && cy < n
                        && 0 <= cz
                        && cz < h) {
                    // 안익은 토마토 집어넣기
                    if (box[cz][cy][cx] == 0) {
                        box[cz][cy][cx] = box[tomato.h][tomato.y][tomato.x] + 1;

                        queue.add(new Point(cz, cy, cx));
                    }
                }
            }
        }

        int day = 0;
        boolean all = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        all = false;
                        break;
                    }
                    if (box[i][j][k] > day) {
                        day = box[i][j][k];
                    }
                }
            }
        }

        if (all) {
            bw.write(String.valueOf(day - 1));
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int x;
        int y;
        int h;

        Point(int h, int y, int x) {
            this.h = h;
            this.x = x;
            this.y = y;

        }
    }
}
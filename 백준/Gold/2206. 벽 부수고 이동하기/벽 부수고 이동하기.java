import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2206
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j) - 48;
            }
        }

        boolean[][][] visited = new boolean[n][m][2];
        visited[0][0][0] = true;

        Queue<Way> queue = new LinkedList<>();
        queue.add(new Way(0, 0, 1, false));
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int ans = -1;

        while (!queue.isEmpty()) {
            Way now = queue.poll();

            if (now.y == n - 1 && now.x == m - 1) {
                ans = now.distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int cy = now.y + dy[i];
                int cx = now.x + dx[i];
                if (0 <= cy && cy < n && 0 <= cx && cx < m) {
                    if (!now.breakWall) { // 벽을 부순 적이 없는 경우
                        // 벽이 아닌 경우
                        if (map[cy][cx] == 0 && !visited[cy][cx][0]) {
                            visited[cy][cx][0] = true;
                            queue.add(new Way(cy, cx, now.distance + 1, now.breakWall));
                        } else if (map[cy][cx] == 1 && !visited[cy][cx][1]) {
                            // 벽을 부수는 경우
                            // visited[][][1]에 들어감
                            visited[cy][cx][1] = true;
                            queue.add(new Way(cy, cx, now.distance + 1, true));
                        }
                    } else {
                        // 벽을 부순 적이 있는 경우
                        if (map[cy][cx] == 0 && !visited[cy][cx][1]) {
                            visited[cy][cx][1] = true;
                            queue.add(new Way(cy, cx, now.distance + 1, now.breakWall));
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();
    }

    static class Way {
        int y;
        int x;
        int distance;
        boolean breakWall;

        Way(int y, int x, int distance, boolean breakWall) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.breakWall = breakWall;
        }
    }

}

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 6593
public class Main {

    // 동 서 남 북 상 하
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            int[][][] building = new int[l][r][c]; // 층 행 열
            boolean[][][] visited = new boolean[l][r][c];

            Queue<Point> queue = new LinkedList<>();

            // 정보 입력
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String floorRow = br.readLine();
                    for (int k = 0; k < c; k++) {
                        char info = floorRow.charAt(k);

                        if (info == 'S') {
                            Point start = new Point(k, j, i, 0);
                            queue.add(start);
                            visited[i][j][k] = true;
                        } else if (info == '.') {
                            building[i][j][k] = 1;
                        } else if (info == 'E') {
                            building[i][j][k] = 2;
                        }
                    }
                }
                br.readLine(); // 공백 읽기
            }


            int ans = -1;

            while (!queue.isEmpty()) {
                Point now = queue.poll();

                if(building[now.z][now.y][now.x]==2){
                    ans = now.time;
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int nextZ = now.z + dz[i];
                    int nextY = now.y + dy[i];
                    int nextX = now.x + dx[i];

                    if (0 <= nextZ && nextZ < l && 0 <= nextY && nextY < r && 0 <= nextX && nextX < c) {
                        if ((building[nextZ][nextY][nextX] == 1 || building[nextZ][nextY][nextX] == 2) && !visited[nextZ][nextY][nextX]) {
                            queue.add(new Point(nextX, nextY, nextZ, now.time + 1));
                            visited[nextZ][nextY][nextX] = true;
                        }
                    }
                }
            }

            if(ans!=-1){
                bw.write("Escaped in " + ans + " minute(s).\n");
            }else{
                bw.write("Trapped!\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int x;
        int y;
        int z;
        int time;

        Point(int x, int y, int z, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }
}
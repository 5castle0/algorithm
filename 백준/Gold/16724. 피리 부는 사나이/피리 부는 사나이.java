import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] cycleEnd;

    // r l d u 순
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        cycleEnd = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        int direction = findDirection(y, x);

        int nextY = y + dy[direction];
        int nextX = x + dx[direction];

        if (!visited[nextY][nextX]) {
            dfs(nextY, nextX);
        } else {
            if (!cycleEnd[nextY][nextX]) {
                count++;
            }
        }

        cycleEnd[y][x] = true;
    }

    private static int findDirection(int y, int x) {
        char dir = map[y][x];
        int realDir = 0;

        if (dir == 'R') {
            realDir = 0;
        } else if (dir == 'L') {
            realDir = 1;
        } else if (dir == 'D') {
            realDir = 2;
        } else {
            realDir = 3;
        }

        return realDir;
    }
}
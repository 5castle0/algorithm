import java.io.*;
import java.util.StringTokenizer;

// 14503
public class Main {

    static int r, c, d;
    static int n, m;
    static int[][] room;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        // 바라보는 방향
        // 0:북쪽 , 1:동쪽 , 2:남쪽 , 3:서쪽
        d = Integer.parseInt(st.nextToken());

        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
            room[x][y] = 0; // 청소되지 않은 빈칸
            room[x][y] = 1; // 벽
            room[x][y] = 2; // 청소된 빈칸
         */
        while (true) {

            if (room[r][c] == 0) {
                room[r][c] = 2; // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
                count++;
            }

            if (!searchAround(r, c)) { // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
                moveBack(); // 1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                if (0 > r || r >= n || 0 > c || c >= m || room[r][c] == 1) {
                    break; // 2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                }
            } else { // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                turnAndMoveForward();
            }

        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }

    // 주변 4칸 중 청소되지 않은 칸이 있으면 true 반환
    static boolean searchAround(int r, int c) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int cr = r + dx[i];
            int cc = c + dy[i];
            if (0 <= cr && cr < n && 0 <= cc && cc < m) {
                if (room[cr][cc] == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    static void moveBack() {
        switch (d) {
            case 0:
                r++;
                break;
            case 1:
                c--;
                break;
            case 2:
                r--;
                break;
            case 3:
                c++;
                break;
        }
    }

    static void turnAndMoveForward() {
        for (int i = 0; i < 4; i++) {
            // 1. 반시계 방향으로 90도 회전한다.
            if (d == 0) {
                d = 3;
            } else {
                d--;
            }

            if (moveForward()) {
                return;
            }
        }
    }

    static boolean moveForward() {
        int newR = r;
        int newC = c;

        switch (d) {
            case 0:
                newR--;
                break;
            case 1:
                newC++;
                break;
            case 2:
                newR++;
                break;
            case 3:
                newC--;
                break;
        }

        if (room[newR][newC] == 0) { // 2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
            r = newR;
            c = newC;
            return true;
        }

        return false;
    }

}
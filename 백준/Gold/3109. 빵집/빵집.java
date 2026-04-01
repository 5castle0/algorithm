import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static char[][] map;
    static char[][] copy;
    static int ans = 0;
    static int check = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        copy = new char[r][c]; // 복사본 - 처음 값 유지
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            // 지난 경로에서 파이프가 놓여졌는지 확인하기 위한 변수
            check = ans;

            dfs(i, 0);
        }

        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int y, int x) {

        if (x == c - 1) {
            ans++;
            return;
        }

        move(y - 1, x + 1);
        move(y, x + 1);
        move(y + 1, x + 1);
    }

    private static void move(int y, int x) {
        // 이번 시작점에서 파이프를 이미 놓았을 경우
        if (check != ans) {
            return;
        }

        if (inRange(y, x) && map[y][x] == '.') {
            map[y][x] = 'X';
            dfs(y, x);

            if (check == ans) {
                map[y][x] = copy[y][x];
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return 0 <= y && y < r && 0 <= x && x < c;
    }
}
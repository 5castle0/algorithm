import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] circle;
    static int total = 0;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        circle = new int[n + 2][m];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                circle[i][j] = Integer.parseInt(st.nextToken());
                total += circle[i][j];
            }
        }

        count = n * m; // 총 원소 개수

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x의 배수 원판 회전
            int d = Integer.parseInt(st.nextToken()); // 0 : 시계 방향, 1 : 반시계 방향
            int k = Integer.parseInt(st.nextToken()); // 몇 칸 회전

            for (int j = x; j <= n; j += x) {
                circle[j] = rotate(j, d, k);
            }

            erase();
        }

        bw.write(String.valueOf(total));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] rotate(int x, int d, int k) {
        int[] rotated = new int[m];

        if (d == 0) {
            // 시계 방향 회전
            for (int i = 0; i < m; i++) {
                rotated[i] = circle[x][(i + m - k) % m];
            }
        } else {
            // 반시계 방향 회전
            for (int i = 0; i < m; i++) {
                rotated[i] = circle[x][(i + k) % m];
            }
        }

        return rotated;
    }

    private static void erase() {
        boolean flag = false;
        boolean[][] makeZero = new boolean[n + 2][m];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {

                if (circle[i][j] == 0) {
                    continue;
                }

                // 같은 원판 인접 수 확인
                if (circle[i][j] == circle[i][(j + 1) % m]) {
                    makeZero[i][j] = true;
                    makeZero[i][(j + 1) % m] = true;
                    flag = true;
                }

                if (circle[i][j] == circle[i][(j - 1 + m) % m]) {
                    makeZero[i][j] = true;
                    makeZero[i][(j - 1 + m) % m] = true;
                    flag = true;
                }

                // 위 원판 인접 수 확인
                if (circle[i][j] == circle[i + 1][j]) {
                    makeZero[i][j] = true;
                    makeZero[i + 1][j] = true;
                    flag = true;
                }
            }
        }

        if (flag) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < m; j++) {
                    if (makeZero[i][j] && circle[i][j] != 0) {
                        total -= circle[i][j];
                        count--;
                        circle[i][j] = 0;
                    }
                }
            }
        } else {
            float average = (float) total / count;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < m; j++) {
                    if (circle[i][j] == 0) {
                        continue;
                    }

                    if (circle[i][j] > average) {
                        circle[i][j]--;
                        total--;
                    } else if (circle[i][j] < average) {
                        circle[i][j]++;
                        total++;
                    }
                }
            }
        }
    }
}

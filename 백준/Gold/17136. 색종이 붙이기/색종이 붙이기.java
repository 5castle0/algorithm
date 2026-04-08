import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper = new int[10][10];
    static int[] count = {5, 5, 5, 5, 5};
    static int ans = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs();

        if (ans == 26) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(ans));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs() {

        // 1이 더 이상 없으면 return
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (paper[i][j] == 1) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }

        if (flag) {
            int temp = 0;
            for (int i : count) {
                temp += i;
            }

            ans = Math.min(ans, 25 - temp);
            return;
        }

        // dfs
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (paper[i][j] == 1) {
                    int size = measure(i, j);

                    for (int k = 1; k <= size; k++) {
                        // 색종이가 남아있을 때에만 진행 가능
                        if (count[k - 1] > 0) {
                            fill(i, j, k, 0);
                            count[k - 1]--;
                            dfs();
                            fill(i, j, k, 1);
                            count[k - 1]++;
                        }
                    }
                    return;
                }
            }
        }
    }

    // 사이즈 측정
    private static int measure(int y, int x) {
        int size = 1;

        for (int i = 1; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= i; k++) {
                    // 범위 밖이면
                    if (!inRange(y + j, x + k)) {
                        return size;
                    }

                    // 1이 아니면
                    if (paper[y + j][x + k] == 0) {
                        return size;
                    }
                }
            }
            size = i + 1;
        }

        return size;
    }

    private static void fill(int y, int x, int size, int what) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                paper[i][j] = what;
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return 0 <= y && y < 10 && 0 <= x && x < 10;
    }
}
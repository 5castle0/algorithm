import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] ans = new int[3];
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rec(n, 0, 0);

        for (int i : ans) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void rec(int n, int y, int x) {
        int standard = arr[y][x];
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (standard != arr[y + i][x + j]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }

        if (flag) {
            ans[standard + 1]++;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    rec(n / 3, y + n / 3 * i, x + n / 3 * j);
                }
            }
        }
    }
}
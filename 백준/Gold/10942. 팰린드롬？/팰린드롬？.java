import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1) {
                    if (arr[i] == arr[j]) {
                        dp[i][j] = true;
                    }
                } else {
                    if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (dp[a][b]) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
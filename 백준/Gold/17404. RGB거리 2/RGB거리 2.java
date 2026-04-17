import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1000 * 1000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n + 1][3];
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cost[i][0] = a;
            cost[i][1] = b;
            cost[i][2] = c;
        }

        int ans = INF;

        for (int i = 0; i < 3; i++) {
            // 첫 집의 색 고정 
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[1][j] = cost[1][i];
                } else {
                    dp[1][j] = INF;
                }
            }

            for (int j = 2; j <= n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + cost[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + cost[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + cost[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    continue;
                }

                ans = Math.min(ans, dp[n][j]);
            }
        }

        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();
    }
}
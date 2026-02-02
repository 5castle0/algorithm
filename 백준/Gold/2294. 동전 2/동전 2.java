import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2294
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (0 <= i - coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        if (dp[k] == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(dp[k]));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
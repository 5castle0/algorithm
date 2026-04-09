import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); // 최소 고객
        int n = Integer.parseInt(st.nextToken()); // 도시의 개수

        int[] dp = new int[c + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int ans = Integer.MAX_VALUE;

        /*
            dp 인덱스 = 사람 수
            dp 값 = 최소 비용
         */

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int consumer = Integer.parseInt(st.nextToken());

            for (int i = consumer; i <= c + 100; i++) {
                if (dp[i - consumer] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - consumer] + cost);
                }
            }
        }

        for (int i = c; i <= c + 100; i++) {
            if (ans > dp[i]) {
                ans = dp[i];
            }
        }
        
        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();
    }
}
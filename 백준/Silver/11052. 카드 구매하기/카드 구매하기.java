import java.io.*;
import java.util.StringTokenizer;

// 11052
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] price = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i-j] + price[j], dp[i]);
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }

}

/*
    dp[i] = i개를 샀을 때 최대값

    j : 1~i
    dp[i] = dp[i-j] + price[j];

 */


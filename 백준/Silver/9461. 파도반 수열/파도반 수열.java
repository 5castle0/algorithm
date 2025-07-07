import java.io.*;

public class Main {
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        dp[1] = dp[2] = dp[3] = 1;
        for(int i=4; i<=100; i++){
            dp[i] = dp[i-2] + dp[i-3];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
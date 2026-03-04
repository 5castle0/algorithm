import java.io.*;

public class Main {

    static int size = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] dp = new long[size + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= size; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            bw.write(dp[x] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
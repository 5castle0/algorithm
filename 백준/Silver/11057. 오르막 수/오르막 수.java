import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][11];

        for(int i=0; i<10; i++){
            dp[0][i] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=9; j>=0; j--){
                dp[i][j] = dp[i][j+1] + dp[i-1][j];
                dp[i][j] %= 10007;
            }
        }

        bw.write(String.valueOf(dp[n][0]));

        bw.flush();
        bw.close();
        br.close();
    }

}
import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][3];


        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+r;
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+g;
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+b;
        }

        int min = Integer.MAX_VALUE;
        for(int i:dp[n]){
            min = Math.min(min,i);
        }

        bw.write(String.valueOf(min));

        bw.flush();
        bw.close();
        br.close();
    }


}
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];
        dp[1] = arr[1];

        if(n!=1) {
            dp[2] = dp[1] + arr[2];
            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], Math.max(dp[i-1], dp[i-2] + arr[i]));
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();

    }

}

/*
    i-3 i-2 i-1 i
    o   x   o   o
    o   o   x   o
    x   o   o   x

 */
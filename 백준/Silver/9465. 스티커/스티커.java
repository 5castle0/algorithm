import java.io.*;
import java.util.StringTokenizer;

// 9465
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];

            // 윗줄 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                arr[0][i] = Integer.parseInt(st.nextToken());
            }

            // 아랫줄 입력
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][n+1];
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for(int i=2; i<=n; i++){
                dp[0][i] = arr[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
                dp[1][i] = arr[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
            }

            bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

}

/*
    자신의 위치를 무조건 떼기 + 전 칸 엇갈리게
    or
    자신의 위치를 무조건 떼기 + 전전칸 엇갈리게
 */
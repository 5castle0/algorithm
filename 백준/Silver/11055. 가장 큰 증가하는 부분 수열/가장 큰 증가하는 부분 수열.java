import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1001];
        dp[1] = arr[1];

        for(int i=2; i<=n; i++){
            dp[i] = arr[i];
            for(int j=i-1; j>=1; j--){
                if(arr[j] < arr[i]){
                    // 증가하는 수열일때
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        Arrays.sort(dp);
        bw.write(String.valueOf(dp[1000]));
        bw.flush();
        bw.close();
        br.close();
    }

}
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        int max = arr[0];
        dp[0] = arr[0];

        for(int i=1; i<n; i++){

            if(arr[i] < dp[i-1]+arr[i]){
                dp[i] = dp[i-1]+arr[i];
            }else{
                dp[i] = arr[i];
            }

            // 최대 연속합 찾기
            if(max < dp[i]){
                max = dp[i];
            }
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();

    }

}
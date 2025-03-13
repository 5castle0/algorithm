import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        arr[0] = 0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int[] sum = new int[n+1];
        sum[0] = arr[0];

        for(int i=1; i<=n; i++){
            sum[i] = sum[i-1] + arr[i];
        }

        for(int i=0; i<m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            bw.write(String.valueOf(sum[b]-sum[a-1])+'\n');
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i=n-1 ; ; i--){
            if(arr[i]>value) continue;

            int k = value / arr[i]; // 해당 동전 개수

            value -= k * arr[i]; // 가치 갱신

            count+=k;

            if(value==0) break;

        }
        
        bw.write(String.valueOf(count));
        
        bw.flush();
        bw.close();
        br.close();
    }
}
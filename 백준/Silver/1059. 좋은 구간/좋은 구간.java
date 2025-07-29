import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int ans=0;

        for(int i=0; i<n; i++){
            if(arr[i]<m && arr[i+1]>m){
                int left = arr[i];
                int right = arr[i+1];
                ans = (m-left) * (right-m) -1;
                break;
            }
        }

        bw.write(ans+" ");
        bw.flush();
        bw.close();
        br.close();
    }

}
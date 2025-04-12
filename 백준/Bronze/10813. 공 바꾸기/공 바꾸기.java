import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=1; i<=n; i++){
            arr[i-1]=i;
        }

        for(int i=0; i<m;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int temp = arr[a-1];

            arr[a-1]= arr[b-1];
            arr[b-1]= temp;

        }

        for(int i: arr){
            bw.write(i+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
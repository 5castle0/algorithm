import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];

        for(int i = 1; i<=n; i++){
            StringTokenizer st1= new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int num = Integer.parseInt(st1.nextToken());
                arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + num;
            }
        }


        for(int i=0; i<m; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st1.nextToken());
            int y1 = Integer.parseInt(st1.nextToken());
            int x2 = Integer.parseInt(st1.nextToken());
            int y2 = Integer.parseInt(st1.nextToken());

            bw.write(arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
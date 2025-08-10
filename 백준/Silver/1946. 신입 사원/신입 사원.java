import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (o1, o2) -> {
                return o1[0]-o2[0];
            });

            int count = 0;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if(arr[i][1] < min){
                    count++;
                    min = arr[i][1];
                }
            }

            bw.write(count+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
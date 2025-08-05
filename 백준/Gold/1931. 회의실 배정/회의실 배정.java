import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, ((o1, o2) -> {
            if(o1[1] == o2[1]){ // 끝나는 시간이 같을 경우 시작시간이 빠른 경우부터 정렬
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));

        int count = 0;
        int ing = 0;

        for(int[] meeting : arr ){
            int startTime = meeting[0];
            int endTime = meeting[1];

            if(startTime >= ing){
                ing = endTime;
                count++;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }

}
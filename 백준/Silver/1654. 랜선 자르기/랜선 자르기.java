import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        // 이분탐색을 위한 변수
        long min = 1;
        long max = 0;
        long count = 0;
        long ans = 0;

        long[] arr = new long[k];
        for(int i=0; i<k; i++){
            arr[i] = Long.parseLong(br.readLine());
            if (max < arr[i]) max = arr[i];
        }

        while(min <= max){
            count = 0;
            long mid = (min+max)/2;

            for(long len : arr){
                count += len/mid;
            }

            if(count < n){ // 잘린 랜선이 부족한 경우
                max = mid-1;
            }else{
                ans = mid;
                min = mid+1;
            }
        }

        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();

    }

}
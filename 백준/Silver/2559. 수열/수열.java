import java.io.*;
import java.util.StringTokenizer;

// 2559
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 전체 날짜의 수
        int k = Integer.parseInt(st.nextToken()); // 연속적인 날짜의 수
        int[] arr = new int[n];

        // 날짜 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int last = 0;

        // 초기 값 설정
        for(int i=0; i<k; i++){
            last += arr[i];
        }
        max = last;

        // 이전 값을 이용해 계산
        for(int i=1; i<n-k+1; i++){
            last = last - arr[i-1] + arr[i+k-1];

            if(max < last) max = last;
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

}
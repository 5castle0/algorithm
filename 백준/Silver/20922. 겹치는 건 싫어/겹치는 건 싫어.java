import java.io.*;
import java.util.StringTokenizer;

// 20922
public class Main {

    static int SIZE = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[SIZE + 1]; // 원소의 수

        int start = 1;
        int len = 1;

        for (int end = 1; end <= n; end++) {
            int x = arr[end];
            count[x]++;

            // k 초과시 수열 시작점 변경
            while (count[x] > k) {
                count[arr[start]]--;
                start++;
            }

            len = Math.max(len, end - start + 1);
        }

        bw.write(String.valueOf(len));

        bw.flush();
        bw.close();
        br.close();
    }
}

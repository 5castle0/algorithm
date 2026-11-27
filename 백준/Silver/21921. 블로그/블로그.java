import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }

        int ans = sum;
        int count = 1;

        for (int i = x; i < n; i++) {
            sum -= arr[i - x];
            sum += arr[i];

            if (sum == ans){
                count++;
            } else if (sum > ans) {
                ans = sum;
                count = 1;
            }
        }

        if (ans == 0) {
            bw.write("SAD");
        } else {
            bw.write(ans + "\n" + count);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
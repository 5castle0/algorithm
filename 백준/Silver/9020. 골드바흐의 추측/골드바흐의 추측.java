import java.io.*;
import java.util.Arrays;

// 9020
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 소수 찾기
        boolean[] prime = new boolean[10001];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i < Math.sqrt(10001); i++) {
            for (int j = 2; i * j < 10001; j++) {
                prime[i * j] = false;
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for (int i = n / 2; i >= 2; i--) {
                if (prime[n - i] && prime[i]) {
                    bw.write(i + " " + (n - i) + "\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
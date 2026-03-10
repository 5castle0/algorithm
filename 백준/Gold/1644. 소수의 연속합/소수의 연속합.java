import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 에라토스테네스의 체
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = 2; i * j <= n; j++) {
                primes[i * j] = false;
            }
        }

        // 소수 리스트
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                list.add(i);
            }
        }

        int left = 0;
        int right = 0;
        int ans = 0;
        int sum = 0;

        while (left <= right) {
            if (sum == n) {
                ans++;
                sum -= list.get(left);
                left++;
            } else if (sum > n) {
                sum -= list.get(left);
                left++;
            } else {
                // sum < n
                if (list.size() > right) {
                    sum += list.get(right);
                    right++;
                } else {
                    break;
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
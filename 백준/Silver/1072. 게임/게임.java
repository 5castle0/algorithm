import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());

        long z = y * 100 / x;

        long left = 0;
        long right = 1000000000;

        if (z >= 99) {
            bw.write("-1");
        } else {
            while (left < right) {
                long mid = (right + left) / 2;

                if ((y + mid) * 100 / (x + mid) != z) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            bw.write(String.valueOf(left));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
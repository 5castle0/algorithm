import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] left = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }

        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            int personSLeft = left[i];
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (order[j] == 0) {
                    if (personSLeft == count) {
                        order[j] = i + 1;
                        break;
                    }
                    count++;
                }
            }
        }

        for (int i : order) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.util.StringTokenizer;

// 1051
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = Math.min(n, m);

        int[][] square = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                square[i][j] = str.charAt(j);
            }
        }

        int size = 1;

        for (int i = 2; i <= min; i++) {
            for (int j = 0; j <= n - i; j++) {
                for (int k = 0; k <= m - i; k++) {
                    if (square[j][k] == square[j][k + i - 1]
                            && square[j][k] == square[j + i - 1][k]
                            && square[j][k] == square[j + i - 1][k + i - 1]) {
                        size = i;
                        break;
                    }
                }
            }
        }

        bw.write(size * size + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
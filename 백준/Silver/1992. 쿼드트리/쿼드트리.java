
import java.io.*;

// 1992
public class Main {

    static int n;
    static int[][] data;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        data = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                data[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        condense(0, 0, n, 1);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    // 해당 범위에서 압축가능한지 확인
    // kind == 0 : 2사분면 압축
    // kind == 1 : 중간 압축
    // kind == 2 : 4사분면 압축
    static void condense(int y, int x, int size, int kind) {

        int standard = data[y][x];
        boolean possible = true;

        if (kind == 0) {
            sb.append("(");
        }

        // 압축가능한지 확인
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (standard != data[i][j]) {
                    possible = false;
                }
            }
        }


        if (possible) { // 가능하다면 압축
            sb.append(standard);
        } else {
            int newSize = size / 2;

            condense(y, x, newSize, 0);
            condense(y, x + newSize, newSize, 1);
            condense(y + newSize, x, newSize, 1);
            condense(y + newSize, x + newSize, newSize, 2);
        }

        if (kind == 2) {
            sb.append(")");
        }
    }
}


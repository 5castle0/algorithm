import java.io.*;
import java.util.StringTokenizer;

// 1717
public class Main {

    static int n;
    static int r;
    static int c;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 배열의 크기
        r = Integer.parseInt(st.nextToken()); // 행
        c = Integer.parseInt(st.nextToken()); // 열

        int size = (int) Math.pow(2, n);

        visitZ(size, r, c);

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }

    static void visitZ(int size, int y, int x) {
        int newSize = size / 2;
        int temp = newSize * newSize; // count에 추가할 수
        int newr = y;
        int newc = x;

        if (size == 1) {
            return;
        }

        if (y < newSize) {
            if (x < newSize) {
                // 2사분면
            } else {
                // 1사분면
                newc -= newSize;
                count += temp;
            }
        } else {
            if (x < newSize) {
                // 3사분면
                newr -= newSize;
                count += temp * 2;
            } else {
                // 4사분면
                newc -= newSize;
                newr -= newSize;
                count += temp * 3;
            }
        }
        
        visitZ(newSize, newr, newc);
    }
}

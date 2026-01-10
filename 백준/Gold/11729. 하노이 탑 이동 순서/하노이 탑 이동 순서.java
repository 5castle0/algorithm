import java.io.*;

// 11729
public class Main {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        rec(n, 1, 2, 3);

        bw.write(count + "\n");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    /*
        n : 원판의 개수
        start : 현재 위치
        temp : 중간에 둘 곳
        end : 목적지
     */
    static void rec(int n, int start, int temp, int end) {

        count++;

        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        rec(n - 1, start, end, temp);

        sb.append(start).append(" ").append(end).append("\n");

        rec(n - 1, temp, start, end);
    }
}

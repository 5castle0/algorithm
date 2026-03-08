import java.io.*;

public class Main {

    static int n;
    static int[] board;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        // 체스 보드
        // board의 i는 보드의 행
        // board[i]는 보드의 열
        board = new int[n + 1];

        nQueen(1);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void nQueen(int depth) {

        // 퀸 n개를 놓은 경우
        if (depth > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (checkRow(i) && checkDiagonal(i, depth)) {
                board[depth] = i;
                nQueen(depth + 1);
                board[depth] = 0;
            }
        }
    }

    private static boolean checkRow(int x) {
        for (int i = 1; i <= n; i++) {
            if (board[i] == x) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkDiagonal(int x, int depth) {
        for (int i = 0; i < depth; i++) {
            if (board[depth - i] == x - i || board[depth - i] == x + i) {
                return false;
            }
        }

        return true;
    }
}
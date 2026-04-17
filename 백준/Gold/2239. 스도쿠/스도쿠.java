import java.io.*;

public class Main {

    static int[][] sudoku = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        dfs(0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int y, int x) {

        if (flag) {
            return;
        }

        // 종료 조건
        if (y == 9) {
            flag = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]);
                }
                sb.append("\n");
            }

            return;
        }

        if (sudoku[y][x] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isValid(y, x, i)) {
                    sudoku[y][x] = i;

                    next(y, x);

                    if (flag) {
                        return;
                    }

                    sudoku[y][x] = 0;
                }
            }
        } else {
            next(y, x);
        }
    }

    private static void next(int y, int x) {
        if (x == 8) {
            dfs(y + 1, 0);
        } else {
            dfs(y, x + 1);
        }
    }

    private static boolean isValid(int y, int x, int n) {

        // 가로 세로 확인
        for (int i = 0; i < 9; i++) {
            if (sudoku[y][i] == n || sudoku[i][x] == n) {
                return false;
            }
        }

        // 같은 박스 확인
        int sy = (y / 3) * 3;
        int sx = (x / 3) * 3;

        for (int i = sy; i < sy + 3; i++) {
            for (int j = sx; j < sx + 3; j++) {
                if (sudoku[i][j] == n) {
                    return false;
                }
            }
        }

        return true;
    }
}
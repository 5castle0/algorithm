import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

// 1987
public class Main {

    static int r, c;
    static char[][] board;
    static HashMap<Character, Integer> hashMap = new HashMap<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        hashMap.put(board[0][0], 1);
        dfs(0, 0, 1);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int y, int x, int count) {
        if (count > ans) {
            ans = count;
        }

        for (int i = 0; i < 4; i++) {
            int cy = y + dy[i];
            int cx = x + dx[i];
            if (0 <= cy && cy < r && 0 <= cx && cx < c) {
                if (!hashMap.containsKey(board[cy][cx])) {
                    hashMap.put(board[cy][cx], 1);
                    dfs(cy, cx, count + 1);
                    hashMap.remove(board[cy][cx]);
                }
            }
        }
    }

}

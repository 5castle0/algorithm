import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static HashMap<Integer, Integer> hash = new HashMap<>();
    static int count;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int index = 2; // hashmap key

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    count = 1;
                    visited[i][j] = true;
                    map[i][j] = index;
                    dfs(i, j);
                    hash.put(index, count);
                    index++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    int ans = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int cy = dy[k] + i;
                        int cx = dx[k] + j;
                        if (inRange(cy, cx) && map[cy][cx] != 1) {
                            int id = map[cy][cx];
                            if(!set.contains(id)){
                                ans += hash.get(id);
                                set.add(id);
                            }
                        }
                    }
                    sb.append(ans % 10);
                } else {
                    sb.append("0");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int cy = y + dy[i];
            int cx = x + dx[i];

            if (inRange(cy, cx) && map[cy][cx] == 0 && !visited[cy][cx]) {
                count++;
                visited[cy][cx] = true;
                map[cy][cx] = index;
                dfs(cy, cx);
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}
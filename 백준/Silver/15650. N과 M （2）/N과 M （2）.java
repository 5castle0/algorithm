import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        dfs(1,0);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int index, int depth) {
        if (depth == m) {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
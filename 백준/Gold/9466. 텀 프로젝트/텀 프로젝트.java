import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int n;
    static int count;
    static boolean[] visited;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            count = 0;
            visited = new boolean[n + 1];
            check = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            bw.write(n - count + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int now) {
        visited[now] = true;
        int next = arr[now];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!check[next]) {
                count++; // now's count
                for (int i = next; i != now; i = arr[i]) {
                    count++;
                }
            }
        }
        check[now] = true;
    }
}
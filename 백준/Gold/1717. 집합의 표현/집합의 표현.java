import java.io.*;
import java.util.StringTokenizer;

// 1717
public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int func = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (func == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }

        return parent[n];
    }

    private static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent >= bParent) {
            parent[aParent] = bParent;
        } else {
            parent[bParent] = aParent;
        }
    }

}
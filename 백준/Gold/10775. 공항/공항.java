import java.io.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        int count = 0;

        parent = new int[g + 1];
        for (int i = 1; i <= g; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < p; i++) {
            int x = Integer.parseInt(br.readLine());

            if (find(x) == 0) {
                break;
            }

            count++;
            union(find(x), find(x) - 1);

        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        parent[a] = b;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);

    }
}

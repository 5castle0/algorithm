import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        boolean flag = false;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a)==find(b)){
                flag = true;
                bw.write(String.valueOf(i));
                break;
            }

            union(a,b);
        }

        if(!flag){
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

    private static int find(int a) {
        if (parent[a] != a) {
            return parent[a] = find(parent[a]);
        }

        return a;
    }
}
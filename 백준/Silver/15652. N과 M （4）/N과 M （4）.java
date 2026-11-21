import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static StringBuilder sb  = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        for (int i = 1; i <= n; i++) {
            arr[0] = i;
            dfs(i, 1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int i, int depth){
        if(depth == m){
            for(int x : arr){
                sb.append(x).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int j=i; j<=n; j++){
            arr[depth] = j;
            dfs(j, depth + 1);
        }
    }
}
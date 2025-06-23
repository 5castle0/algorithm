import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[] visited;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        int count = 0;

        for(int i=1; i<= n; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int v){
        visited[v] = true;
        for(int i=1; i<=n; i++){
            if(!visited[i] && arr[v][i]==1){
                dfs(i);
            }
        }
    }
}
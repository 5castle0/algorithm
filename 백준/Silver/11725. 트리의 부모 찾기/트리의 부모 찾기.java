import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main { //11725

    static int n;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        parent = new int[n+1];
        arr = new ArrayList[n+1];

        for(int i=0; i<=n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);

        }

        dfs(1);

        for(int i=2; i<=n; i++){
            bw.write(parent[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start){
        visited[start] = true;
        for(int next : arr[start]){
            if(!visited[next]){
                parent[next] = start;
                dfs(next);
            }
        }
    }

}
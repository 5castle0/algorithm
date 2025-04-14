import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visit;
    static int n;
    static int m;
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // node
        m = Integer.parseInt(st.nextToken()); // 간선
        int v = Integer.parseInt(st.nextToken()); // 시작점

        arr = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i=0;i<m;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            arr[a][b] = arr[b][a] = 1; // 1 = 간선 존재
        }

        dfs(v);
        System.out.println();
        visit = new boolean[n+1];
        bfs(v);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int v){
        visit[v] = true;
        System.out.print(v + " ");

        for(int i=1;i<=n;i++){
            if(arr[v][i]==1 && !visit[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        q.offer(v);
        visit[v] = true;

        while (!q.isEmpty()){
            v = q.poll();
            System.out.print(v + " ");

            for(int i=1;i<=n;i++){
                if(arr[v][i]==1 && !visit[i]){
                    q.offer(i);
                    visit[i] = true;
                }
            }

        }
    }
}

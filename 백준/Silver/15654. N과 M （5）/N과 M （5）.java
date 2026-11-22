import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        ans = new int[m];
        for(int i = 0; i < n; i++){
            ans[0] = arr[i];
            visited[i] = true;
            dfs(i+1, 1);
            visited[i] = false;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int i, int depth){
        if(depth == m){
            for(int j : ans){
                sb.append(j).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int j=0; j<n; j++){
            if(!visited[j]){
                visited[j] = true;
                ans[depth] = arr[j];
                dfs(j, depth + 1);
                visited[j] = false;
            }
        }
    }
}
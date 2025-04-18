import java.io.*;
import java.util.*;

public class Main {

    static int node,line;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node+1][node+1];
        visited = new boolean[node+1];

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        dfs(1);

        int count = 0;
        for (boolean b : visited) {
            if(b) count++;
        }

        bw.write(String.valueOf(count-1)); // 1번 컴퓨터 빼주기

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start){
        visited[start] = true;
        for(int i=0; i<=node; i++){
            if(arr[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

}
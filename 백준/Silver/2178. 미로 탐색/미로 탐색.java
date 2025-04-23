import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1}; //상하좌우
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0,0);

        bw.write(String.valueOf(arr[n-1][m-1]));

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int cx = cur[0] + dx[k];
                int cy = cur[1] + dy[k];
                if(0<=cx && cx<n && 0<=cy && cy<m) {
                    if(arr[cx][cy] == 1 && !visited[cx][cy]) {
                        q.add(new int[] {cx,cy});
                        arr[cx][cy] = arr[cur[0]][cur[1]] + 1;
                        visited[cx][cy] = true;
                    }
                }
            }
        }
    }

}

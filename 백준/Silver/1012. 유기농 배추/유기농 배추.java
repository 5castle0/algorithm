import java.io.*;
import java.util.*;

public class Main {

    static int n,m,k;
    static int[][] arr;
    static boolean[][] visited;
    static int count;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            count = 0;
            arr = new int[n][m]; // n이 세로(y), m이 가로(x)
            visited = new boolean[n][m];
            while(k-->0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j]==1 && !visited[i][j]){
                        bfs(i,j);
                    }
                }
            }

            bw.write(count + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll(); // {x,y} 형태
            for (int i = 0; i < 4; i++) {
                int cx = cur[0] + dx[i];
                int cy = cur[1] + dy[i];

                if (cy>=0 && cx>=0 && cx<m && cy<n
                && visited[cy][cx] == false && arr[cy][cx] == 1) {
                    q.offer(new int[]{cx, cy});
                    visited[cy][cx] = true;
                }
            }
        }
        count++;
    }
}

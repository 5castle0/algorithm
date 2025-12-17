import java.io.*;
import java.util.StringTokenizer;

// 1926
public class Main {

    static int n,m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int count = 0;
    static int tempArea = 0;
    static int max = 0; // 가장 큰 그림 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0;j <m; j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    tempArea = 1;
                    dfs(i, j);
                    count++;
                }
            }
        }

        bw.write(count + "\n" + max);

        bw.flush();
        bw.close();
        br.close();
    }


    // x는 n과 관계, y는 m과 관계
    static void dfs(int x, int y){
        visited[x][y] = true;

        // 가장 넓은 그림의 넓이
        if(max < tempArea) max = tempArea;

        for(int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(0<=cx && cx<n && 0<=cy && cy<m){
                if(!visited[cx][cy] && arr[cx][cy]==1) {
                    tempArea++;
                    dfs(cx,cy);
                }
            }
        }
    }
}
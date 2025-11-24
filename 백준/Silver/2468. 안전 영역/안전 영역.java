import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 2468
public class Main {

    static int n;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] arr;
    static boolean[][] visited;
    static int count = 0;
    static int max = 1;
    static List<Integer> height = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        // 배열 입력
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int x = Integer.parseInt(st.nextToken());
                arr[i][j] = x;

                if(!height.contains(x)){
                    height.add(x);
                }
            }
        }

        for(int i : height){
            visited = new boolean[n][n];
            count = 0;
            for(int x=0; x<n; x++){
                for(int y=0; y<n; y++){
                    if(!visited[x][y] && arr[x][y]>=i){
                        dfs(x,y,i);
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y, int height){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(0<=cx && cx<n && 0<=cy && cy<n){
                if(!visited[cx][cy] && arr[cx][cy]>=height){
                    dfs(cx, cy, height);
                }
            }
        }
    }
    
}
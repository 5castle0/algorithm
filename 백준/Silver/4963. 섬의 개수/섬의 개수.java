import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0,1,1,1,0,-1,-1,-1}; //12시부터 시계방향
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    static int[][] arr;
    static boolean[][] visited;
    static int h,w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0){
                break;
            }

            arr = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count =0;

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(arr[i][j]==1 && !visited[i][j]){
                        visited[i][j] = true;
                        dfs(i,j);
                        count ++;
                    }
                }
            }

            bw.write(count+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y){
        for(int i=0; i<8; i++){
            int nowx = x+dx[i];
            int nowy = y+dy[i];
            if(0<=nowx && nowx<h && 0<= nowy && nowy<w){
                if(arr[nowx][nowy]==1 && !visited[nowx][nowy]){
                    visited[nowx][nowy] = true;
                    dfs(nowx,nowy);
                }
            }
        }
    }
}
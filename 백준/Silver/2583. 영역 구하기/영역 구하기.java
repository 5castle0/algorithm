import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 2583
public class Main {

    static int m,n,k,count;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int temp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 모눈종이의 세로
        n = Integer.parseInt(st.nextToken()); // 모눈종이의 가로
        k = Integer.parseInt(st.nextToken()); // 직사각형의 개수

        visited = new boolean[m][n];

        while(k-->0){
            st = new StringTokenizer(br.readLine());

            // 왼쪽 아래 꼭짓점
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            // 오른쪽 위 꼭짓점
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for(int y=ly; y<ry; y++){
                for(int x=lx; x<rx; x++){
                    visited[y][x] = true;
                }
            }
        }

        for(int y=0; y<m; y++){
            for(int x=0; x<n; x++){
                if(!visited[y][x]){
                    temp = 0;
                    count++;
                    dfs(x,y);
                    list.add(temp);
                }
            }
        }

        Collections.sort(list);

        bw.write(count + "\n");

        for(int area : list){
            bw.write(area + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y){
        visited[y][x] = true;
        temp++;
        for(int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(0<=cx && cx<n && 0<=cy && cy<m){
                if(!visited[cy][cx]){
                    visited[cy][cx] = true;
                    dfs(cx, cy);
                }
            }
        }
    }
}
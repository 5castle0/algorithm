import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    static boolean[][] visited;
    static int[][] depth;
    static int wishX, wishY;
    static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int test = 0; test< t; test++){
            l = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 나이트의 현재 위치
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            wishX = Integer.parseInt(st.nextToken()); // 나이트의 목표 위치
            wishY = Integer.parseInt(st.nextToken());

            visited = new boolean[l][l];
            depth = new int[l][l];

            bfs(x,y);

            bw.write(depth[wishX][wishY]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0]==wishX && cur[1] ==wishY){
                return;
            }
            for(int i=0; i<8; i++){
                int cx = cur[0]+dx[i];
                int cy = cur[1]+dy[i];
                if( 0<=cx && cx<l && 0<=cy && cy<l ){
                    if(!visited[cx][cy]){
                        visited[cx][cy] = true;
                        depth[cx][cy] = depth[cur[0]][cur[1]] + 1;
                        queue.add(new int[]{cx,cy});
                    }
                }
            }
        }
    }

}
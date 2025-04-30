import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<int[]> q = new LinkedList<>();
    static int day;
    static boolean flag;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                int tomato = Integer.parseInt(st.nextToken());
                arr[i][j] = tomato;
                if(tomato==0){
                    flag = true;
                }
            }
        }

        if(!flag){ // 저장될때 부터 모든 토마토가 익어있는지 확인하기 위한 flag
            bw.write("0");
            bw.flush();
            return;
        }


        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j]==1){
                   q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0;i<size;i++){
                int[] cur = q.poll();

                for(int k = 0;k<4;k++){
                    int cx = cur[0]+dx[k];
                    int cy = cur[1]+dy[k];
                    if(0<=cx&&cx<n&&0<=cy&&cy<m){
                        if(arr[cx][cy]==0){
                            arr[cx][cy]=1;
                            q.add(new int[]{cx,cy});
                        }
                    }
                }
            }

            if(!q.isEmpty()) day++;
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j]==0){
                    bw.write("-1");
                    bw.flush();
                    return;
                }
            }
        }

        bw.write(String.valueOf(day));

        bw.flush();
        bw.close();
        br.close();
    }

}
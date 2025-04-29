import java.io.*;

public class Main {

    static int n;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int count1 , count2;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        // 정상인 사람
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    count1++;
                }
            }
        }

        // 적록색약인 경우
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    count2++;
                }
            }
        }

        bw.write(count1 +" "+ count2);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x,int y) {
        visited[x][y] = true;
        char curLetter = arr[x][y];
        for(int k = 0; k < 4; k++) {
            int cx = x + dx[k];
            int cy = y + dy[k];
            if(0<=cx && cx<n && 0<=cy && cy<n) {
                if(!visited[cx][cy] & arr[cx][cy] == curLetter) {
                    dfs(cx,cy);
                }
            }
        }
    }
}
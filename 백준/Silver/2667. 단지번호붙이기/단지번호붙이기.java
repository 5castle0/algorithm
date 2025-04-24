import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1}; //상하좌우
    static int[] dy = {-1,1,0,0};
    static int count = 1;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    list.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(list);

        bw.write(list.size() + "\n");
        for(int i: list){
            bw.write(i + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int i, int j){
        visited[i][j] = true;
        for(int k = 0; k < 4; k++){
            int cx = i + dx[k];
            int cy = j + dy[k];
            if(0<=cx && cx<n && 0<=cy && cy<n &&
                    arr[cx][cy] == 1 && !visited[cx][cy]){
                dfs(cx, cy);
                count++;
            }
        }
    }

}
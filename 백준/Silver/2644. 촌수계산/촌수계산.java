import java.io.*;
import java.util.*;

public class Main {


    static int[][] arr;
    static boolean[] visited;
    static int count = 0;
    static int n,a,b;
    static boolean flag;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        dfs(a);

        if(flag){
            bw.write(String.valueOf(count));
        }
        else{
            bw.write("-1");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start){
        if(start==b){
            flag = true;
            return;
        }

        visited[start] = true;
        for(int i=1; i<=n; i++){
            if(arr[start][i]==1 && visited[i]==false && !flag){
                count++;
                dfs(i);
                if(!flag){ count--;}

            }
        }
    }
}

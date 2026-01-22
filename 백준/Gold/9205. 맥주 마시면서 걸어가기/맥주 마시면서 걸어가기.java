
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 9205
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int homeX = Integer.parseInt(st.nextToken());
            int homeY = Integer.parseInt(st.nextToken());

            int[][] convenience = new int[n][2];
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                convenience[i][0] = Integer.parseInt(st.nextToken());
                convenience[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int festX = Integer.parseInt(st.nextToken());
            int festY = Integer.parseInt(st.nextToken());

            Queue<Integer[]> q = new LinkedList<>();
            q.add(new Integer[]{homeX, homeY});

            boolean flag = false;

            while(!q.isEmpty()){
                Integer[] now = q.poll();

                if(Math.abs(now[0]-festX) + Math.abs(now[1]-festY) <= 1000){
                    flag = true;
                    break;
                }

                for(int i=0 ;i<n; i++){
                    if(!visited[i] && (Math.abs(now[0]-convenience[i][0]) + Math.abs(now[1]-convenience[i][1]) <= 1000)){
                        visited[i] = true;
                        q.add(new Integer[]{convenience[i][0], convenience[i][1]});
                    }
                }
            }

            if(flag){
                bw.write("happy\n");
            }else{
                bw.write("sad\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
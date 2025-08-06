import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Integer> queue = new LinkedList<>();
    static int n, k;
    static boolean[] visited = new boolean[100001];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited[n] = true;
        bfs(n);

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int start){
        queue.add(start);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0; i< size; i++){
                int x = queue.poll();

                if(x==k) return;

                if(x-1>=0 && x-1<=100000 && !visited[x-1]) {
                    queue.add(x-1);
                    visited[x-1] = true;
                }
                if(x+1>=0 && x+1<=100000 && !visited[x+1]) {
                    queue.add(x+1);
                    visited[x+1] = true;
                }
                if(2*x>=0 && 2*x<=100000 && !visited[2*x]) {
                    queue.add(2*x);
                    visited[2*x] = true;
                }
            }

            count++;
        }
        
    }

}
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int SIZE = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[SIZE + 1];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(n, 0));
        visited[n] = true;

        int time = Integer.MAX_VALUE;
        int count = 0;
        boolean flag = false;

        while(!queue.isEmpty()){
            Point now = queue.remove();
            int nowX = now.x;
            int nowTime = now.time;
            visited[nowX] = true;

            if(nowTime > time) break;

            if(nowX == k){
                time = nowTime;
                count++;
                flag = true;
            }

            if(flag) continue;

            if(isInRange(nowX+1) && !visited[nowX+1]){
                queue.add(new Point(nowX+1, nowTime+1));
            }

            if(isInRange(nowX-1) && !visited[nowX-1]){
                queue.add(new Point(nowX-1, nowTime+1));
            }

            if(isInRange(nowX*2) && !visited[nowX*2]) {
                queue.add(new Point(nowX*2, nowTime+1));
            }
        }

        bw.write(time+"\n"+count);

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isInRange(int x){
        return 0<=x && x<=SIZE;
    }

    static class Point {
        int x;
        int time;

        public Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
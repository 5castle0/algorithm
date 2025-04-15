import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        int count = 0;
        boolean flag = false;

        Queue<Long> q = new LinkedList<>();
        q.offer(a);

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                long n = q.poll();
                if(n == b){
                    bw.write(String.valueOf(count+1));
                    flag = true;
                }
                if(n*2<=b) q.offer(n*2);
                if(n*10+1<=b) q.offer(n*10+1);
            }
            count++;

        }

        if(!flag) bw.write("-1");

        bw.flush();
        bw.close();
        br.close();
    }

}

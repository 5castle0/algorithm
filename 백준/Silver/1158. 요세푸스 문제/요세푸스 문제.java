import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++){
            q.offer(i);
        }

        bw.write("<");

        while(q.size()!=1){
            int a = q.poll();
            count++;
            if(count==k){
                bw.write(a + ", ");
                count=0;
            }
            else{
                q.offer(a);
            }
        }

        bw.write(q.poll()+">");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
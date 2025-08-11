import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        for(int i=0; i<n; i++){
            heap.add(Long.parseLong(br.readLine()));
        }

        long ans = 0;

        while(heap.size()>1){
            long x = heap.poll();
            long y = heap.poll();

            ans = ans +x +y;
            heap.add(x+y);
        }

        bw.write(String.valueOf(ans));
        
        bw.flush();
        bw.close();
        br.close();
    }
}
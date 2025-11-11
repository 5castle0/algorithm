import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 11286
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(n-->0){
            int x = Integer.parseInt(br.readLine());
            int abs = Math.abs(x);

            if(x==0){
                if(pq.isEmpty()) bw.write(0 + "\n");
                else {
                    int out = pq.poll();
                    if(arr.contains(out)){
                        bw.write("-" + out+ "\n");
                        arr.remove(Integer.valueOf(out));
                    }else{
                        bw.write(out + "\n");
                    }
                }
            }else{
                pq.add(abs);
                if(x<0){
                   arr.add(abs);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
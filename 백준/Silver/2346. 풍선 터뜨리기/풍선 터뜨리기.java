import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 2346
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> deque = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            deque.add(new int[]{i+1,arr[i]});
        }

        for(int i=0; i<n-1; i++){
            int[] balloon = deque.removeFirst();
            int index = balloon[0]; // 풍선 번호
            int value = balloon[1]; // 종이에 적혀있는 번호

            if(value>0){
                value -= 1;
//                value %= deque.size();
                for(int j=0; j<value; j++){
                    int[] temp = deque.removeFirst();
                    deque.addLast(temp);
                }
            }else{
//                value %= deque.size();
                value = Math.abs(value);
                for(int j=0; j<value; j++){
                    int[] temp = deque.removeLast();
                    deque.addFirst(temp);
                }
            }

            bw.write(index + " ");
        }

        bw.write(deque.peekFirst()[0]+ " ");
        
        bw.flush();
        bw.close();
        br.close();
    }
}